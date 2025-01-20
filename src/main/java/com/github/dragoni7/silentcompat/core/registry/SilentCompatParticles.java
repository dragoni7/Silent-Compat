package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SilentCompatParticles {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, SilentCompat.MODID);
	
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> JOLT = PARTICLES.register("jolt", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> JOLT_CHAIN = PARTICLES.register("jolt_chain", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> IMMUNE = PARTICLES.register("immune", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID = PARTICLES.register("void", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOLITILE = PARTICLES.register("volatile", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> IGNITION = PARTICLES.register("ignition", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RESTORATION = PARTICLES.register("restoration", () -> new SimpleParticleType(false));

}
