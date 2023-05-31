package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketVolatileExplosionParticles extends AbstractPacketDisplayHitParticle {

	public PacketVolatileExplosionParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketVolatileExplosionParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
        
        level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.x() + 1, pos.y() + y, pos.z() + 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.x() + 1, pos.y() + y, pos.z() - 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.x() - 1, pos.y() + y, pos.z() + 1, 1.0D, 0.0D, 0.0D);
		level.addParticle(SilentCompatParticles.VOLITILE.get(), pos.x() - 1, pos.y() + y, pos.z() - 1, 1.0D, 0.0D, 0.0D);
	}
}
