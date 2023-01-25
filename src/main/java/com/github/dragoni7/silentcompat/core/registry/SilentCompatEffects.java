package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.effects.EffectAmplified;
import com.github.dragoni7.silentcompat.effects.EffectDevouring;
import com.github.dragoni7.silentcompat.effects.EffectVolitile;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SilentCompatEffects {
	
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SilentCompat.MODID);
	
	public static final RegistryObject<MobEffect> AMPLIFIED = MOB_EFFECTS.register("amplified", () -> new EffectAmplified());
	
	public static final RegistryObject<MobEffect> DEVOURING = MOB_EFFECTS.register("devouring", () -> new EffectDevouring());
	
	public static final RegistryObject<MobEffect> VOLITILE = MOB_EFFECTS.register("volitile", () -> new EffectVolitile());
	
}
