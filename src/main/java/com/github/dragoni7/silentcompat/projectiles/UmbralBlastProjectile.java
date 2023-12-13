package com.github.dragoni7.silentcompat.projectiles;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatEntities;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class UmbralBlastProjectile extends AbstractHurtingProjectile {
	
	private float damage = 4.0f;
	
	public UmbralBlastProjectile(EntityType<? extends UmbralBlastProjectile> type, Level level) {
		super(type, level);
	}
	
	public UmbralBlastProjectile(Level level, LivingEntity entity, double x, double y, double z, float damage) {
		super(SilentCompatEntities.UMBRAL_BLAST_PROJECTILE.get(), entity, x, y, z, level);
		this.damage = damage;
	}
	
	public UmbralBlastProjectile(LivingEntity owner, Level level, float damage) {
		super(SilentCompatEntities.UMBRAL_BLAST_PROJECTILE.get(), level);
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
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200));
					((LivingEntity) entity).knockback(3, -(double)Mth.sin(this.getYRot() * ((float)Math.PI / 180F)), -(double)(-Mth.cos(this.getYRot() * ((float)Math.PI / 180F))));
				}
			}
		}
	}
	
	@Override
	protected ParticleOptions getTrailParticle() {
		return SilentCompatParticles.VOID.get();
	}
	
	@Override
	protected boolean shouldBurn() {
		return false;
	}

}
