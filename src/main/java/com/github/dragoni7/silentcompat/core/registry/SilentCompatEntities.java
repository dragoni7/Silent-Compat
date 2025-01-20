package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.projectiles.BlindingProjectile;
import com.github.dragoni7.silentcompat.projectiles.UmbralBlastProjectile;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SilentCompatEntities {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SilentCompat.MODID);
	
	public static final DeferredHolder<EntityType<?>, EntityType<BlindingProjectile>> BLINDING_PROJECTILE = ENTITY_TYPES.register("blinding_projectile", () -> 
	EntityType.Builder.<BlindingProjectile>of(BlindingProjectile::new, MobCategory.MISC)
	.sized(0.25f, 0.25f)
	.clientTrackingRange(4)
	.updateInterval(10)
	.build(ResourceLocation.fromNamespaceAndPath(SilentCompat.MODID, "blinding_projectile").toString()));

	public static final DeferredHolder<EntityType<?>, EntityType<UmbralBlastProjectile>> UMBRAL_BLAST_PROJECTILE = ENTITY_TYPES.register("umbral_blast_projectile", () -> 
	EntityType.Builder.<UmbralBlastProjectile>of(UmbralBlastProjectile::new, MobCategory.MISC)
	.sized(0.25f, 0.25f)
	.clientTrackingRange(4)
	.updateInterval(10)
	.build(ResourceLocation.fromNamespaceAndPath(SilentCompat.MODID, "umbral_blast_projectile").toString()));

}
