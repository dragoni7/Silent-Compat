package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketIgnitionParticles extends AbstractPacketDisplayHitParticle {
	
	public PacketIgnitionParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketIgnitionParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
		
		double d1 = level.random.nextDouble();
        
        level.addParticle(SilentCompatParticles.IGNITION.get(), pos.x() + 1 + d1, pos.y() + y + d1, pos.z() + 1 + d1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.IGNITION.get(), pos.x() + 1 + d1, pos.y() + y + d1, pos.z() - 1 - d1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.IGNITION.get(), pos.x() - 1 - d1, pos.y() + y + d1, pos.z() + 1 + d1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.IGNITION.get(), pos.x() - 1 - d1, pos.y() + y + d1, pos.z() - 1 - d1, 1.0D, 0.0D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() + 1 + d1, pos.y() + y + d1, pos.z() + 1 + d1, 0.0D, 0.1D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() + 1 + d1, pos.y() + y + d1, pos.z() - 1 - d1, 0.0D, 0.1D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() - 1 - d1, pos.y() + y + d1, pos.z() + 1 + d1, 0.0D, 0.1D, 0.0D);
		level.addParticle(ParticleTypes.FLAME, pos.x() - 1 - d1, pos.y() + y + d1, pos.z() - 1 - d1, 0.0D, 0.1D, 0.0D);
		level.addParticle(ParticleTypes.FLASH, pos.x(), pos.y(), pos.z(), 0.0D, 0.0D, 0.0D);
	}

}
