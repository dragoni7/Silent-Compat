package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SilentCompatParticles {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SilentCompat.MODID);
	
	public static final RegistryObject<SimpleParticleType> JOLT = PARTICLES.register("jolt", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> JOLT_CHAIN = PARTICLES.register("jolt_chain", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> IMMUNE = PARTICLES.register("immune", () -> new SimpleParticleType(false));

}
