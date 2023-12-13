package com.github.dragoni7.silentcompat.projectiles;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatEntities;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class BlindingProjectile extends AbstractHurtingProjectile {
	
	private float damage = 4.0f;
	
	public BlindingProjectile(EntityType<? extends BlindingProjectile> type, Level level) {
		super(type, level);
	}
	
	public BlindingProjectile(Level level, LivingEntity entity, double x, double y, double z, float damage) {
		super(SilentCompatEntities.BLINDING_PROJECTILE.get(), entity, x, y, z, level);
		this.damage = damage;
	}
	
	public BlindingProjectile(LivingEntity owner, Level level, float damage) {
		super(SilentCompatEntities.BLINDING_PROJECTILE.get(), level);
		this.damage = damage;
	}
	
	protected void onHitEntity(EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		
		if (!this.level().isClientSide) {
			Entity entity = hitResult.getEntity();
			Entity owner = this.getOwner();
			
			if (owner instanceof LivingEntity) {
				entity.hurt(entity.damageSources().indirectMagic(this, (LivingEntity) owner), damage);
				this.doEnchantDamageEffects((LivingEntity) owner, entity);
				
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 240));
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.DARKNESS, 240));
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 3));
				}
			}
		}
	}
	
	@Override
	protected ParticleOptions getTrailParticle() {
		return SilentCompatParticles.JOLT.get();
	}
	
	@Override
	protected boolean shouldBurn() {
		return false;
	}

}
