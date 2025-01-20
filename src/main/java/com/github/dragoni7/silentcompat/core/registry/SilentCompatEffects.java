package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.effects.EffectAmplified;
import com.github.dragoni7.silentcompat.effects.EffectDevouring;
import com.github.dragoni7.silentcompat.effects.EffectRestoration;
import com.github.dragoni7.silentcompat.effects.EffectScorch;
import com.github.dragoni7.silentcompat.effects.EffectVolatile;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SilentCompatEffects {
	
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, SilentCompat.MODID);
	
	public static final DeferredHolder<MobEffect, EffectAmplified> AMPLIFIED = MOB_EFFECTS.register("amplified", EffectAmplified::new);
	
	public static final DeferredHolder<MobEffect, EffectDevouring> DEVOURING = MOB_EFFECTS.register("devouring", EffectDevouring::new);
	
	public static final DeferredHolder<MobEffect, EffectVolatile> VOLATILE = MOB_EFFECTS.register("volatile", EffectVolatile::new);
	
	public static final DeferredHolder<MobEffect, EffectRestoration> RESTORATION = MOB_EFFECTS.register("restoration", EffectRestoration::new);
	
	public static final DeferredHolder<MobEffect, EffectScorch> SCORCH = MOB_EFFECTS.register("scorch", EffectScorch::new);
	
}
