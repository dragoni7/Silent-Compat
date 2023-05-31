package com.github.dragoni7.silentcompat.effects;

import com.github.dragoni7.silentcompat.networking.Networking;
import com.github.dragoni7.silentcompat.networking.PacketVolatileParticles;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EffectVolatile extends MobEffect {
	
	public EffectVolatile() {
		super(MobEffectCategory.HARMFUL, 0X890368);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
		if (entity.tickCount % 5 == 0) {
			Level level = entity.level;
			Player player = level.getNearestPlayer(entity, 24);
			if (player instanceof ServerPlayer) {
				Networking.sendToClient(new PacketVolatileParticles(entity.getId()), (ServerPlayer) player);
			}
		}
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration > 0;
	}

	public String getDescriptionId() {
		return "silentcompat.effect.volatile";
	}
}
