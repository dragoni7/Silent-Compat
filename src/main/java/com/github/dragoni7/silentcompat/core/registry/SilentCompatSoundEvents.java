package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SilentCompatSoundEvents {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, SilentCompat.MODID);
	
	public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_ZAP = SOUND_EVENTS.register("electric_zap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SilentCompat.MODID, "electric_zap")));

}
