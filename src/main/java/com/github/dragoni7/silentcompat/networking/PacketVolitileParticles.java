package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

public class PacketVolitileParticles extends AbstractPacketDisplayHitParticle {

	public PacketVolitileParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketVolitileParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, BlockPos pos, double y) {
        
        level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.getX() + 1, pos.getY() + y, pos.getZ() + 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.getX() + 1, pos.getY() + y, pos.getZ() - 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.getX() - 1, pos.getY() + y, pos.getZ() + 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.getX() - 1, pos.getY() + y, pos.getZ() - 1, 1.0D, 0.0D, 0.0D);
	}
}
