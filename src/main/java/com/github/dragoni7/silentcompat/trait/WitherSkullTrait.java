package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;

public class WitherSkullTrait extends SimpleTrait {
	
	public static final Serializer<WitherSkullTrait> SERIALIZER = new Serializer<WitherSkullTrait>(new ResourceLocation(SilentCompat.MODID, "wither_skull"), WitherSkullTrait::new);

	public WitherSkullTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	private int counter = 0;
	private boolean canFire = false;
	
	@Override
	public void onUpdate(TraitActionContext context, boolean isEquipped) {
		
		if (isEquipped) {
			
			counter++;
			
			if (counter == 400) {
				canFire = true;
				counter = 0;
			}
		}
	}
	
    @Override
    public void onItemSwing(ItemStack stack, LivingEntity wielder, int traitLevel) {
    	
        if (wielder instanceof Player) {
        	
        	Player player = (Player) wielder;
        	Level level = player.level;
        	
        	if (!player.level.isClientSide && stack.getDamageValue() < stack.getMaxDamage() - 50 - 1 && canFire) {
        		
        		GearHelper.attemptDamage(stack, 50, player, stack.getEquipmentSlot());
        		
        		// spawn projectile
        		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_SHOOT, SoundSource.PLAYERS, 0.3f, 0.9f);
        		Vec3 vec3 = player.getViewVector(1.0f);
        		WitherSkull projectile = new WitherSkull(level, player, vec3.x, vec3.y, vec3.z);
        		projectile.setPos(player.getX() + vec3.x, player.getY(0.5D), player.getZ() + vec3.z);
        		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.0f, 1.0f);
        		level.addFreshEntity(projectile);
        		canFire = false;
			}
    		
        	player.removeEffect(SilentCompatEffects.AMPLIFIED.get());
        }
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Summons a wither skull projectile on swing, costing durability");
        return ret;
    }
}
