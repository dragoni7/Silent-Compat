package com.github.dragoni7.silentcompat.event;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.client.particles.ImmuneParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltChainParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltParticle;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEventHandler {
	
	public static final ResourceLocation AMPLIFIED = new ResourceLocation(SilentCompat.MODID, "shaders/post/amplified.json");

	public static void setUp(IEventBus modBus) {
		
		modBus.addListener(ClientEventHandler::registerParticles);
	}
	
	private static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(SilentCompatParticles.JOLT.get(), JoltParticle.Provider::new);
		event.register(SilentCompatParticles.JOLT_CHAIN.get(), JoltChainParticle.Provider::new);
		event.register(SilentCompatParticles.IMMUNE.get(), ImmuneParticle.ImmuneParticleProvider::new);
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingEvent.LivingTickEvent event) {
		if (event.getEntity() == Minecraft.getInstance().player) {
			GameRenderer renderer = Minecraft.getInstance().gameRenderer;
			MobEffectInstance amplified = event.getEntity().getEffect(SilentCompatEffects.AMPLIFIED.get());
			
			if (amplified != null && renderer.currentEffect() == null) {
				renderer.loadEffect(AMPLIFIED);
			}
			if (amplified == null && renderer.currentEffect() != null && renderer.currentEffect().getName() != null && AMPLIFIED.toString().equals(renderer.currentEffect().getName())) {
				renderer.shutdownEffect();
			}
		}
	}
}
