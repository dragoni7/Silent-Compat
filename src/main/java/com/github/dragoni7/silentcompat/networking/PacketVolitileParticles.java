package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketVolitileParticles extends AbstractPacketDisplayHitParticle {

	public PacketVolitileParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketVolitileParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
		
		level.addParticle(SilentCompatParticles.VOID.get(), pos.x(), pos.y() + 0.5D, pos.z(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.VOID.get(), pos.x() + 0.1D, pos.y() + 0.5D, pos.z(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.VOID.get(), pos.x(), pos.y() + 0.5D, pos.z() + 0.1D, 0, 0, 0);
	}
}
