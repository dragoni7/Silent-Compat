package com.github.dragoni7.silentcompat.networking;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Networking {
	private static SimpleChannel INSTANCE;
	private static int ID = 0;
	
	private static int nextID() {
		return ID++;
	}
	
	public static void registerMessages() {
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(SilentCompat.MODID), () -> "1.0", s -> true, s -> true);
		
		INSTANCE.messageBuilder(PacketJoltParticles.class, nextID())
		.encoder(PacketJoltParticles::write)
		.decoder(PacketJoltParticles::new)
		.consumerMainThread(PacketJoltParticles::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketImmuneParticles.class, nextID())
		.encoder(PacketImmuneParticles::write)
		.decoder(PacketImmuneParticles::new)
		.consumerMainThread(PacketImmuneParticles::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketJoltChain.class, nextID())
		.encoder(PacketJoltChain::write)
		.decoder(PacketJoltChain::new)
		.consumerMainThread(PacketJoltChain::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketVolatileExplosionParticles.class, nextID())
		.encoder(PacketVolatileExplosionParticles::write)
		.decoder(PacketVolatileExplosionParticles::new)
		.consumerMainThread(PacketVolatileExplosionParticles::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketIgnitionParticles.class, nextID())
		.encoder(PacketIgnitionParticles::write)
		.decoder(PacketIgnitionParticles::new)
		.consumerMainThread(PacketIgnitionParticles::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketVolatileParticles.class, nextID())
		.encoder(PacketVolatileParticles::write)
		.decoder(PacketVolatileParticles::new)
		.consumerMainThread(PacketVolatileParticles::handle)
		.add();
		
		INSTANCE.messageBuilder(PacketScorchParticles.class, nextID())
		.encoder(PacketScorchParticles::write)
		.decoder(PacketScorchParticles::new)
		.consumerMainThread(PacketScorchParticles::handle)
		.add();
	}
	
	public static void sendToClient(Object packet, ServerPlayer player) {
		INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
	}
	
	public static void sendToServer(Object packet) {
		INSTANCE.sendToServer(packet);
	}
}
