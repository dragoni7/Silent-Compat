package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PacketImmuneParticles extends AbstractPacketDisplayHitParticle {

	public PacketImmuneParticles(int hitEntity) {
		super(hitEntity);
	}

	public PacketImmuneParticles(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	protected void addParticles(Level level, Vec3 pos, double y) {
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.x() + 1, pos.y() + y, pos.z() + 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.x() + 1, pos.y() + y, pos.z() - 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.x() - 1, pos.y() + y, pos.z() + 1, 0.1D, 0, 0.1D);
		level.addParticle(SilentCompatParticles.IMMUNE.get(), pos.x() - 1, pos.y() + y, pos.z() - 1, 0.1D, 0, 0.1D);
	}

}
