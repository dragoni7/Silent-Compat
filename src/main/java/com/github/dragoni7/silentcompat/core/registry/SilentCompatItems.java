package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SilentCompatItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SilentCompat.MODID);

	public static final RegistryObject<Item> RAW_PLASTEEL = ITEMS.register("raw_plasteel",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	public static final RegistryObject<Item> RAW_VOIDMETAL = ITEMS.register("raw_voidmetal",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	public static final RegistryObject<Item> RAW_ARCMETAL = ITEMS.register("raw_arcmetal",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	public static final RegistryObject<Item> RAW_SOLARMETAL = ITEMS.register("raw_solarmetal",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));

	public static final RegistryObject<Item> WARDEN_INGOT = ITEMS.register("warden_ingot",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));

	public static final RegistryObject<Item> OUTBACK_LEATHER = ITEMS.register("outback_leather",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));

	public static final RegistryObject<Item> CHOCOLATECHIP = ITEMS.register("chocolate_chip",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)
					.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build())));
	
	public static final RegistryObject<Item> CRYSTALLINE_ALLOY = ITEMS.register("crystalline_alloy",
			() -> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	// Ore items
	
	public static final RegistryObject<Item> ARCMETAL_ORE_ITEM = ITEMS.register("arcmetal_ore",
			() -> new BlockItem(MaterialRegistry.ARCMETAL_ORE.get(), new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	public static final RegistryObject<Item> VOIDMETAL_ORE_ITEM = ITEMS.register("voidmetal_ore",
			() -> new BlockItem(MaterialRegistry.VOIDMETAL_ORE.get(), new Item.Properties().tab(SilentCompat.SilentCompatTab)));

	public static final RegistryObject<Item> SOLARMETAL_ORE_ITEM = ITEMS.register("solarmetal_ore",
			() -> new BlockItem(MaterialRegistry.SOLARMETAL_ORE.get(), new Item.Properties().tab(SilentCompat.SilentCompatTab)));
	
	public static final RegistryObject<Item> PLASTEEL_ORE_ITEM = ITEMS.register("plasteel_ore",
			() -> new BlockItem(MaterialRegistry.PLASTEEL_ORE.get(), new Item.Properties().tab(SilentCompat.SilentCompatTab)));
}
