package com.github.dragoni7.silentcompat.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EffectVolitile extends MobEffect {
	
	int tickCount = 40;
	
	public EffectVolitile() {
		super(MobEffectCategory.HARMFUL, 0X74a9cf);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.volitile";
	}
}
