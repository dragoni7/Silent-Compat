package com.github.dragoni7.silentcompat.core.registry;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.item.GearHalberdItem;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.part.PartType;
import net.silentchaos512.gear.item.CompoundPartItem;
import net.silentchaos512.gear.item.MainPartItem;
import net.silentchaos512.gear.item.blueprint.GearBlueprintItem;
import net.silentchaos512.gear.item.blueprint.PartBlueprintItem;
import net.silentchaos512.gear.item.gear.GearSwordItem;
import net.silentchaos512.lib.registry.ItemRegistryObject;

public class SilentCompatItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SilentCompat.MODID);

	public static final RegistryObject<Item> RAW_PLASTEEL = ITEMS.register("raw_plasteel",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_VOIDMETAL = ITEMS.register("raw_voidmetal",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_ARCMETAL = ITEMS.register("raw_arcmetal",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_SOLARMETAL = ITEMS.register("raw_solarmetal",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> OUTBACK_LEATHER = ITEMS.register("outback_leather",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> CHOCOLATECHIP = ITEMS.register("chocolate_chip",
			() -> new Item(new Item.Properties()
					.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build())));
	
	public static final RegistryObject<Item> CRYSTALLINE_ALLOY = ITEMS.register("crystalline_alloy",
			() -> new Item(new Item.Properties()));
	
	// Ore items
	
	public static final RegistryObject<Item> ARCMETAL_ORE_ITEM = ITEMS.register("arcmetal_ore",
			() -> new BlockItem(MaterialRegistry.ARCMETAL_ORE.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> VOIDMETAL_ORE_ITEM = ITEMS.register("voidmetal_ore",
			() -> new BlockItem(MaterialRegistry.VOIDMETAL_ORE.get(), new Item.Properties()));

	public static final RegistryObject<Item> SOLARMETAL_ORE_ITEM = ITEMS.register("solarmetal_ore",
			() -> new BlockItem(MaterialRegistry.SOLARMETAL_ORE.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> PLASTEEL_ORE_ITEM = ITEMS.register("plasteel_ore",
			() -> new BlockItem(MaterialRegistry.PLASTEEL_ORE.get(), new Item.Properties()));
	
	// Gear Items
	public static final ItemRegistryObject<GearBlueprintItem> HALBERD_BLUEPRINT = registerGearBlueprint(GearHalberdItem.GEAR_TYPE, false);
	
	public static final ItemRegistryObject<GearBlueprintItem> HALBERD_TEMPLATE = registerGearBlueprint(GearHalberdItem.GEAR_TYPE, true);
	
	public static final ItemRegistryObject<MainPartItem> HALBERD_HEAD = registerCompoundPart("halberd_head", () ->
    new MainPartItem(GearHalberdItem.GEAR_TYPE, unstackableProps()));
	
	public static final ItemRegistryObject<GearSwordItem> HALBERD = register("halberd", () -> new GearSwordItem(GearHalberdItem.GEAR_TYPE));
	
    private static Item.Properties baseProps() {
        return new Item.Properties();
    }
    
    private static Item.Properties unstackableProps() {
        return baseProps().stacksTo(1);
    }

    private static ItemRegistryObject<GearBlueprintItem> registerGearBlueprint(GearType gearType, boolean singleUse) {
        String name = gearType.getName() + "_" + (singleUse ? "template" : "blueprint");
        return register(name, () -> new GearBlueprintItem(gearType, singleUse, baseProps()));
    }

    private static ItemRegistryObject<PartBlueprintItem> registerPartBlueprint(PartType partType, boolean singleUse) {
        String name = partType.getName().getPath() + "_" + (singleUse ? "template" : "blueprint");
        return register(name, () -> new PartBlueprintItem(partType, singleUse, baseProps()));
    }

    private static <T extends Item> ItemRegistryObject<T> register(String name, Supplier<T> item) {
        return new ItemRegistryObject<>(ITEMS.register(name, item));
    }
    
    private static <T extends CompoundPartItem> ItemRegistryObject<T> registerCompoundPart(String name, Supplier<T> item) {
        return register(name, item);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Collection<T> getItems(Class<T> clazz) {
        return ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(clazz::isInstance)
                .map(item -> (T) item)
                .collect(Collectors.toList());
    }

    public static Collection<Item> getItems(Predicate<Item> predicate) {
        return ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
