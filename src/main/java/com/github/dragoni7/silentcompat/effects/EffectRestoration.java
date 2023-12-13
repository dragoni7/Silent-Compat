package com.github.dragoni7.silentcompat.effects;


import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EffectRestoration extends MobEffect {

	public EffectRestoration() {
		super(MobEffectCategory.BENEFICIAL, 0Xf1a333);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
		if (entity.tickCount % 30 == 0) {
			Vec3 pos = entity.position();
			Level level = entity.level();
			double d1 = level.random.nextDouble();
			level.addParticle(SilentCompatParticles.RESTORATION.get(), pos.x() + 0.1D + d1, pos.y() + 0.3D + d1, pos.z() + 0.1D + d1, 0.0D, 0.2D, 0.0D);
			level.addParticle(SilentCompatParticles.RESTORATION.get(), pos.x() + 0.1D + d1, pos.y() + 0.3D + d1, pos.z() - 0.1D - d1, 0.0D, 0.2D, 0.0D);
			level.addParticle(SilentCompatParticles.RESTORATION.get(), pos.x() - 0.1D - d1, pos.y() + 0.3D + d1, pos.z() + 0.1D + d1, 0.0D, 0.2D, 0.0D);
			level.addParticle(SilentCompatParticles.RESTORATION.get(), pos.x() - 0.1D - d1, pos.y() + 0.3D + d1, pos.z() - 0.1D - d1, 0.0D, 0.2D, 0.0D);
			
			if (entity.getHealth() < entity.getMaxHealth()) {
				entity.heal(2.0F);
			}
		}
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.restoration";
	}
}
