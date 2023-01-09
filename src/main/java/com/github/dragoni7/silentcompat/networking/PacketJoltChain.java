package com.github.dragoni7.silentcompat.networking;

import java.util.function.Supplier;

import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

public class PacketJoltChain {
	private Vec3 origin;
	private Vec3 target;

	public PacketJoltChain(Vec3 origin, Vec3 target) {
		this.origin = origin;
		this.target = target;
	}

	public PacketJoltChain(FriendlyByteBuf buf) {
		this.origin = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
		this.target = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeDouble(origin.x);
		buf.writeDouble(origin.y);
		buf.writeDouble(origin.z);
		
		buf.writeDouble(target.x);
		buf.writeDouble(target.y);
		buf.writeDouble(target.z);
	}

	public boolean handle(Supplier<NetworkEvent.Context> context) {
		if (context.get().getDirection().getReceptionSide().isClient()) {
			context.get().enqueueWork(() -> {
				Minecraft minecraft = Minecraft.getInstance();
				ClientLevel level = minecraft.level;
				double distance = origin.distanceTo(target);
				if (level != null) {
					for (double d = 0.0; d < distance; d += 1.0D / 4.0D) {
						double fdist = d / distance;
		                level.addParticle(SilentCompatParticles.JOLT_CHAIN.get(), Mth.lerp(fdist, origin.x, target.x),  Mth.lerp(fdist, origin.y, target.y) + 1.0D, Mth.lerp(fdist, origin.z, target.z), 0.0, 0.0, 0.0);
					}
				}
			});
			
			return true;
		}
		return false;
	}

}
