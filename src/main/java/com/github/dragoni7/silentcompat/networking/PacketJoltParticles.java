package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketJoltParticles extends AbstractPacketDisplayHitParticle {

	public PacketJoltParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketJoltParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.x(), pos.y() + y, pos.z(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.x(), pos.y() + y, pos.z(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.x(), pos.y() + y, pos.z(), 0, 0, 0);
	}

}
