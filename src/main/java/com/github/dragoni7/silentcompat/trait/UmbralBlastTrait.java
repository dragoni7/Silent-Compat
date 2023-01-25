package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.projectiles.UmbralBlastProjectile;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;

public class UmbralBlastTrait extends SimpleTrait {
	
	public static final Serializer<UmbralBlastTrait> SERIALIZER = new Serializer<UmbralBlastTrait>(new ResourceLocation(SilentCompat.MODID, "umbral_blast"), UmbralBlastTrait::new);

	public UmbralBlastTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
    @Override
    public void onItemSwing(ItemStack stack, LivingEntity wielder, int traitLevel) {
    	
        if (wielder instanceof Player && wielder.hasEffect(SilentCompatEffects.DEVOURING.get())) {
        	
        	Player player = (Player) wielder;
        	Level level = player.level;
        	
        	if (!player.level.isClientSide && stack.getDamageValue() < stack.getMaxDamage() - 10 - 1) {
        		
        		GearHelper.attemptDamage(stack, 10, player, stack.getEquipmentSlot());
        		
        		// spawn projectile
        		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHULKER_SHOOT, SoundSource.PLAYERS, 0.4f, 0.6f);
        		Vec3 vec3 = player.getViewVector(1.0f);
        		UmbralBlastProjectile projectile = new UmbralBlastProjectile(level, player, vec3.x, vec3.y, vec3.z, traitLevel * 3);
        		projectile.setPos(player.getX() + vec3.x, player.getY(0.5D), player.getZ() + vec3.z);
        		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.0f, 1.0f);
        		level.addFreshEntity(projectile);
			}
    		
        	player.removeEffect(SilentCompatEffects.DEVOURING.get());
        }
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Consumes devouring on tool swing, launching a projectile that weakens, damages, and knocks back targets. Damage is equal to 3 times the trait level");
        return ret;
    }


}
