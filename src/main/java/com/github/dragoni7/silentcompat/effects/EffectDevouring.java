package com.github.dragoni7.silentcompat.effects;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class EffectDevouring extends MobEffect {
	
	int tickCount = 40;
	
	public EffectDevouring() {
		super(MobEffectCategory.BENEFICIAL, 0X74a9cf);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
		if (tickCount == 40) {
			// add void particles
			Vec3 pos = entity.position();
			entity.level.addParticle(SilentCompatParticles.VOID.get(), pos.x, pos.y + 0.5D, pos.z, 0, 0, 0);
			entity.level.addParticle(SilentCompatParticles.VOID.get(), pos.x + 0.1D, pos.y + 0.5D, pos.z, 0, 0, 0);
			entity.level.addParticle(SilentCompatParticles.VOID.get(), pos.x, pos.y + 0.5D, pos.z + 0.1D, 0, 0, 0);
			tickCount = 0;
		}
		else {
			tickCount++;
		}
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.devouring";
	}
}
