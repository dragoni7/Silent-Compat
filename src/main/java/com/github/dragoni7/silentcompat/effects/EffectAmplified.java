package com.github.dragoni7.silentcompat.effects;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

public class EffectAmplified extends MobEffect {

	public EffectAmplified() {
		super(MobEffectCategory.BENEFICIAL, 0X74a9cf);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(SilentCompat.MODID, "effect.amplified"), 1.0,
				AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Vec3 pos = entity.position();
		if (entity.getRandom().nextFloat() < 0.15f) {
			entity.level().addParticle(SilentCompatParticles.JOLT.get(), pos.x, pos.y + 1.5D, pos.z, 0, 0, 0);
		}
		
		return true;
	}
	
	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.amplified";
	}
}
