package com.github.dragoni7.silentcompat.core.registry;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.item.GearHalberdItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.part.PartType;
import net.silentchaos512.gear.item.CompoundPartItem;
import net.silentchaos512.gear.item.GearItemSet;
import net.silentchaos512.gear.item.MainPartItem;
import net.silentchaos512.gear.item.blueprint.GearBlueprintItem;
import net.silentchaos512.gear.item.blueprint.PartBlueprintItem;
import net.silentchaos512.gear.item.gear.GearSwordItem;
import net.silentchaos512.gear.setup.gear.GearTypes;

public class SilentCompatItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SilentCompat.MODID);

	public static final DeferredItem<Item> RAW_PLASTEEL = ITEMS.register("raw_plasteel",
			() -> new Item(new Item.Properties()));
	
	public static final DeferredItem<Item> RAW_VOIDMETAL = ITEMS.register("raw_voidmetal",
			() -> new Item(new Item.Properties()));
	
	public static final DeferredItem<Item> RAW_ARCMETAL = ITEMS.register("raw_arcmetal",
			() -> new Item(new Item.Properties()));
	
	public static final DeferredItem<Item> RAW_SOLARMETAL = ITEMS.register("raw_solarmetal",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> OUTBACK_LEATHER = ITEMS.register("outback_leather",
			() -> new Item(new Item.Properties()));

	public static final DeferredItem<Item> CHOCOLATECHIP = ITEMS.register("chocolate_chip",
			() -> new Item(new Item.Properties()
					.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.2F).build())));
	
	public static final DeferredItem<Item> CRYSTALLINE_ALLOY = ITEMS.register("crystalline_alloy",
			() -> new Item(new Item.Properties()));
	
	// Ore items
	
	public static final DeferredItem<Item> ARCMETAL_ORE_ITEM = ITEMS.register("arcmetal_ore",
			() -> new BlockItem(MaterialRegistry.ARCMETAL_ORE.get(), new Item.Properties()));
	
	public static final DeferredItem<Item> VOIDMETAL_ORE_ITEM = ITEMS.register("voidmetal_ore",
			() -> new BlockItem(MaterialRegistry.VOIDMETAL_ORE.get(), new Item.Properties()));

	public static final DeferredItem<Item> SOLARMETAL_ORE_ITEM = ITEMS.register("solarmetal_ore",
			() -> new BlockItem(MaterialRegistry.SOLARMETAL_ORE.get(), new Item.Properties()));
	
	public static final DeferredItem<Item> PLASTEEL_ORE_ITEM = ITEMS.register("plasteel_ore",
			() -> new BlockItem(MaterialRegistry.PLASTEEL_ORE.get(), new Item.Properties()));
	
    private static Item.Properties baseProps() {
        return new Item.Properties();
    }
    
    private static Item.Properties unstackableProps() {
        return baseProps().stacksTo(1);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Collection<T> getItems(Class<T> clazz) {
        return ITEMS.getEntries().stream()
                .map(DeferredItem::get)
                .filter(clazz::isInstance)
                .map(item -> (T) item)
                .collect(Collectors.toList());
    }

    public static Collection<Item> getItems(Predicate<Item> predicate) {
        return ITEMS.getEntries().stream()
                .map(DeferredItem::get)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
