package com.github.dragoni7.silentcompat.event;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.client.particles.ImmuneParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltChainParticle;
import com.github.dragoni7.silentcompat.client.particles.JoltParticle;
import com.github.dragoni7.silentcompat.client.particles.VoidParticles;
import com.github.dragoni7.silentcompat.client.particles.ElementalExplosionParticle;
import com.github.dragoni7.silentcompat.client.projectiles.BlindingProjectileRender;
import com.github.dragoni7.silentcompat.client.projectiles.UmbralBlastProjectileModel;
import com.github.dragoni7.silentcompat.client.projectiles.UmbralBlastProjectileRender;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEntities;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatParticles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEventHandler {
	
	public static final ResourceLocation AMPLIFIED = new ResourceLocation(SilentCompat.MODID, "shaders/post/amplified.json");
	public static final ResourceLocation DEVOURING = new ResourceLocation(SilentCompat.MODID, "shaders/post/devouring.json");
	public static final ResourceLocation RESTORATION = new ResourceLocation(SilentCompat.MODID, "shaders/post/restoration.json");

	public static void setUp(IEventBus modBus) {
		
		modBus.addListener(ClientEventHandler::registerParticles);
		modBus.addListener(ClientEventHandler::registerEntityLayers);
		modBus.addListener(ClientEventHandler::registerEntityRenders);
	}
	
	private static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(SilentCompatParticles.JOLT.get(), JoltParticle.Provider::new);
		event.register(SilentCompatParticles.JOLT_CHAIN.get(), JoltChainParticle.Provider::new);
		event.register(SilentCompatParticles.IMMUNE.get(), ImmuneParticle.ImmuneParticleProvider::new);
		event.register(SilentCompatParticles.VOID.get(), VoidParticles.Provider::new);
		event.register(SilentCompatParticles.VOLITILE.get(), ElementalExplosionParticle.Provider::new);
		event.register(SilentCompatParticles.IGNITION.get(), ElementalExplosionParticle.Provider::new);
		event.register(SilentCompatParticles.RESTORATION.get(), FlameParticle.Provider::new);
	}
	
	private static void registerEntityLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(UmbralBlastProjectileModel.LAYER_LOCATION, UmbralBlastProjectileModel::createBodyLayer);
	}
	
	private static void registerEntityRenders(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SilentCompatEntities.BLINDING_PROJECTILE.get(), BlindingProjectileRender::new);
		event.registerEntityRenderer(SilentCompatEntities.UMBRAL_BLAST_PROJECTILE.get(), UmbralBlastProjectileRender::new);
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingEvent.LivingTickEvent event) {
		if (event.getEntity() == Minecraft.getInstance().player) {
			GameRenderer renderer = Minecraft.getInstance().gameRenderer;
			MobEffectInstance amplified = event.getEntity().getEffect(SilentCompatEffects.AMPLIFIED.get());
			MobEffectInstance devouring = event.getEntity().getEffect(SilentCompatEffects.DEVOURING.get());
			MobEffectInstance restoration = event.getEntity().getEffect(SilentCompatEffects.RESTORATION.get());
			
			if (amplified != null && renderer.currentEffect() == null) {
				renderer.loadEffect(AMPLIFIED);
			}
			if (amplified == null && renderer.currentEffect() != null && renderer.currentEffect().getName() != null && AMPLIFIED.toString().equals(renderer.currentEffect().getName())) {
				renderer.shutdownEffect();
			}
			
			if (devouring != null && renderer.currentEffect() == null) {
				renderer.loadEffect(DEVOURING);
			}
			if (devouring == null && renderer.currentEffect() != null && renderer.currentEffect().getName() != null && DEVOURING.toString().equals(renderer.currentEffect().getName())) {
				renderer.shutdownEffect();
			}
			
			if (restoration != null && renderer.currentEffect() == null) {
				renderer.loadEffect(RESTORATION);
			}
			if (restoration == null && renderer.currentEffect() != null && renderer.currentEffect().getName() != null && RESTORATION.toString().equals(renderer.currentEffect().getName())) {
				renderer.shutdownEffect();
			}
		}
	}
}
