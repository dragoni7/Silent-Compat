package com.github.dragoni7.silentcompat.networking;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketScorchParticles extends AbstractPacketDisplayHitParticle {
	
	public PacketScorchParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketScorchParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
		
		double d1 = level.random.nextDouble();
		level.addParticle(ParticleTypes.FLAME, pos.x() + 1 + d1, pos.y() + 0.3D + d1, pos.z() + 1 + d1, 0.0D, 0.2D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() + 1 + d1, pos.y() + 0.3D + d1, pos.z() - 1 - d1, 0.0D, 0.2D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() - 1 - d1, pos.y() + 0.3D + d1, pos.z() + 1 + d1, 0.0D, 0.2D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() - 1 - d1, pos.y() + 0.3D + d1, pos.z() - 1 - d1, 0.0D, 0.2D, 0.0D);
	}

}
