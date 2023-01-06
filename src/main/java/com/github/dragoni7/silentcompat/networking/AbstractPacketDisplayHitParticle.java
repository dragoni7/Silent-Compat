package com.github.dragoni7.silentcompat.networking;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

public abstract class AbstractPacketDisplayHitParticle {

	private int hitEntity;

	public AbstractPacketDisplayHitParticle(int hitEntity) {
		this.hitEntity = hitEntity;
	}

	public AbstractPacketDisplayHitParticle(FriendlyByteBuf buf) {
		this.hitEntity = buf.readInt();
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(hitEntity);
	}

	public boolean handle(Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {

			Player player = context.get().getSender();

			if (context.get().getDirection().getReceptionSide().isClient()) {
				player = getClientPlayer();
			}

			if (player != null) {
				if (player.level != null) {
					Entity entity = player.level.getEntity(hitEntity);
					BlockPos pos = entity.blockPosition();
					if (entity instanceof LivingEntity) {
						double y = (entity.getBoundingBox().getYsize() / 2) + entity.level.random.nextDouble();

						addParticles(entity.level, pos, y);
					}
				}
			}
		});

		return true;
	}

	protected abstract void addParticles(Level level, BlockPos pos, double y);

	@OnlyIn(Dist.CLIENT)
	private Player getClientPlayer() {
		return Minecraft.getInstance().player;
	}
}
