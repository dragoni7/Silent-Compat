package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatSoundEvents;
import com.github.dragoni7.silentcompat.projectiles.BlindingProjectile;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;

public class BlindingTrait extends SimpleTrait {
	
	public static final Serializer<BlindingTrait> SERIALIZER = new Serializer<BlindingTrait>(new ResourceLocation(SilentCompat.MODID, "blinding"), BlindingTrait::new);

	public BlindingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
    @Override
    public void onItemSwing(ItemStack stack, LivingEntity wielder, int traitLevel) {
    	
        if (wielder instanceof Player && wielder.hasEffect(SilentCompatEffects.AMPLIFIED.get())) {
        	
        	Player player = (Player) wielder;
        	Level level = player.level();
        	
        	if (!player.level().isClientSide && stack.getDamageValue() < stack.getMaxDamage() - 10 - 1) {
        		
        		GearHelper.attemptDamage(stack, 10, player, stack.getEquipmentSlot());
        		
        		// spawn projectile
        		level.playSound(null, player.getX(), player.getY(), player.getZ(), SilentCompatSoundEvents.ELECTRIC_ZAP.get(), SoundSource.PLAYERS, 0.3f, 0.9f);
        		Vec3 vec3 = player.getViewVector(1.0f);
        		BlindingProjectile projectile = new BlindingProjectile(level, player, vec3.x, vec3.y, vec3.z, traitLevel * 3);
        		projectile.setPos(player.getX() + vec3.x, player.getY(0.5D), player.getZ() + vec3.z);
        		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.0f, 1.0f);
        		level.addFreshEntity(projectile);
			}
    		
        	player.removeEffect(SilentCompatEffects.AMPLIFIED.get());
        }
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Consumes amplified on tool swing, launching a projectile that blinds, damages, and slows targets. Damage is equal to 3 times the trait level");
        return ret;
    }

}
