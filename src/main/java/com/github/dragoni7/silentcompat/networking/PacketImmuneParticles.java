package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.SilentCompatParticles;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

public class PacketImmuneParticles extends AbstractPacketDisplayHitParticle {

	public PacketImmuneParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketImmuneParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, BlockPos pos, double y) {
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.getX() + 1, pos.getY() + y, pos.getZ() + 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.getX() + 1, pos.getY() + y, pos.getZ() - 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.getX() - 1, pos.getY() + y, pos.getZ() + 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.getX() - 1, pos.getY() + y, pos.getZ() - 1, 0.1D, 0, 0.1D);
	}

}
