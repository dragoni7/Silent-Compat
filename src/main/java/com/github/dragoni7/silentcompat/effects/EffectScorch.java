package com.github.dragoni7.silentcompat.effects;

import com.github.dragoni7.silentcompat.networking.Networking;
import com.github.dragoni7.silentcompat.networking.PacketScorchParticles;
import com.github.dragoni7.silentcompat.world.IgnitionExplosion;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EffectScorch extends MobEffect {

	public EffectScorch() {
		super(MobEffectCategory.HARMFUL, 0Xe7430e);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
		if (entity.tickCount % 10 == 0) {
			Level level = entity.level();
			Player player = level.getNearestPlayer(entity, 24);
			if (player instanceof ServerPlayer) {
				Networking.sendToClient(new PacketScorchParticles(entity.getId()), (ServerPlayer) player);
			}
		}
	}
	
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amp) {
		entity.setSecondsOnFire(9999);
		super.addAttributeModifiers(entity, attributeMap, amp);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amp) {
		entity.clearFire();
		// explode
		IgnitionExplosion explosion = new IgnitionExplosion(entity.level(), entity, amp, entity.damageSources().magic(), null, entity.getX(), entity.getY(0.0625D), entity.getZ(), (float)(2.0 + amp));
		explosion.finalizeExplosion(true);
		explosion.explode();
		super.removeAttributeModifiers(entity, attributeMap, amp);
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.scorch";
	}
}
