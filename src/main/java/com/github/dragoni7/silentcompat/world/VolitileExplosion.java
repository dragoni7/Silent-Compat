package com.github.dragoni7.silentcompat.world;

import com.github.dragoni7.silentcompat.networking.Networking;
import com.github.dragoni7.silentcompat.networking.PacketVolitileParticles;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;

public class VolitileExplosion extends Explosion {
	
	private final Player player;
	private final Entity attacked;
	private final Level level;
	private final double x;
	private final double y;
	private final double z;

	public VolitileExplosion(Player player, Entity entity, DamageSource source, ExplosionDamageCalculator damageCalculator,
			double x, double y, double z, float radius) {
		
		super(player.level, entity, source, damageCalculator, x, y, z, radius, false, Explosion.BlockInteraction.NONE);
		
		this.player = player;
		this.attacked = entity;
		this.level = player.level;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void finalizeExplosion(boolean particles) {
		
		this.level.playSound(null, this.x, this.y, this.z, SoundEvents.SHULKER_BULLET_HURT, SoundSource.NEUTRAL, 10.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F);

		if (player instanceof ServerPlayer) {
			Networking.sendToClient(new PacketVolitileParticles(attacked.getId()), (ServerPlayer) player);
		}
	}
}
