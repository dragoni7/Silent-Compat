package com.github.dragoni7.silentcompat.core.event;

import com.github.dragoni7.silentcompat.client.particles.ImmuneParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltChainParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltParticle;
import com.github.dragoni7.silentcompat.core.SilentCompatParticles;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ClientEventHandler {

	public static void init(IEventBus modBus) {
		
		modBus.addListener(ClientEventHandler::registerParticles);
	}
	
	private static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(SilentCompatParticles.JOLT.get(), JoltParticle.Provider::new);
		event.register(SilentCompatParticles.JOLT_CHAIN.get(), JoltChainParticle.Provider::new);
		event.register(SilentCompatParticles.IMMUNE.get(), ImmuneParticle.ImmuneParticleProvider::new);
	}
}
