package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.SilentCompatParticles;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

public class PacketJoltParticles extends AbstractPacketDisplayHitParticle {

	public PacketJoltParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketJoltParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, BlockPos pos, double y) {
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.getX(), pos.getY() + y, pos.getZ(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.getX(), pos.getY() + y, pos.getZ(), 0, 0, 0);
		level.addParticle(SilentCompatParticles.JOLT.get(), pos.getX(), pos.getY() + y, pos.getZ(), 0, 0, 0);
	}

}
