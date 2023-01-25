package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.projectiles.BlindingProjectile;
import com.github.dragoni7.silentcompat.projectiles.UmbralBlastProjectile;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SilentCompatEntities {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SilentCompat.MODID);
	
	public static final RegistryObject<EntityType<BlindingProjectile>> BLINDING_PROJECTILE = ENTITY_TYPES.register("blinding_projectile", () -> 
	EntityType.Builder.<BlindingProjectile>of(BlindingProjectile::new, MobCategory.MISC)
	.sized(0.25f, 0.25f)
	.clientTrackingRange(4)
	.updateInterval(10)
	.build(new ResourceLocation(SilentCompat.MODID, "blinding_projectile").toString()));

	public static final RegistryObject<EntityType<UmbralBlastProjectile>> UMBRAL_BLAST_PROJECTILE = ENTITY_TYPES.register("umbral_blast_projectile", () -> 
	EntityType.Builder.<UmbralBlastProjectile>of(UmbralBlastProjectile::new, MobCategory.MISC)
	.sized(0.25f, 0.25f)
	.clientTrackingRange(4)
	.updateInterval(10)
	.build(new ResourceLocation(SilentCompat.MODID, "umbral_blast_projectile").toString()));

}
