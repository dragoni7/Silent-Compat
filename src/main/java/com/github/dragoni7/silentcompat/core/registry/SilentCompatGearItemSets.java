package com.github.dragoni7.silentcompat.core.registry;

import java.util.*;
import java.util.function.*;

import com.github.dragoni7.silentcompat.item.GearHalberdItem;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.silentchaos512.gear.api.item.GearItem;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.item.GearItemSet;
import net.silentchaos512.gear.setup.gear.GearTypes;

public class SilentCompatGearItemSets {
	private static final List<GearItemSet<?>> LIST = new ArrayList<>();
	
	public static final GearItemSet<GearHalberdItem> HALBERD = set(GearTypes.MELEE_WEAPON, "halberd_head", GearHalberdItem::new);
	
	
    private static <I extends Item & GearItem> GearItemSet<I> set(DeferredHolder<GearType, GearType> type, String partName, Function<Supplier<GearType>, I> itemFactory) {
        return set(new GearItemSet<>(type, partName, itemFactory));
    }

    private static <I extends Item & GearItem> GearItemSet<I> set(GearItemSet<I> set) {
        LIST.add(set);
        return set;
    }

    static void registerGearItems() {
        LIST.forEach(set -> set.registerGearItem(SilentCompatItems.ITEMS));
    }

    static void registerMainPartItems() {
        LIST.forEach(set -> set.registerMainPartItem(SilentCompatItems.ITEMS));
    }

    static void registerBlueprintItems() {
        LIST.forEach(set -> set.registerBlueprintItem(SilentCompatItems.ITEMS));
    }

    static void registerTemplateItems() {
        LIST.forEach(set -> set.registerTemplateItem(SilentCompatItems.ITEMS));
    }

    public static Iterator<GearItemSet<?>> getIterator() {
        return LIST.iterator();
    }
}
