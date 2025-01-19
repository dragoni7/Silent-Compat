package com.github.dragoni7.silentcompat.data;

import java.util.ArrayList;
import java.util.Collection;

import com.github.dragoni7.silentcompat.*;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;
import net.silentchaos512.gear.api.data.part.PartBuilder;
import net.silentchaos512.gear.api.data.part.PartsProviderBase;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.part.PartType;
import net.silentchaos512.gear.api.stats.ItemStats;
import net.silentchaos512.gear.api.stats.StatInstance;
import net.silentchaos512.gear.item.MainPartItem;
import net.silentchaos512.gear.util.ModResourceLocation;
import net.silentchaos512.lib.util.NameUtils;

public final class SilentCompatParts extends PartsProviderBase {

	public SilentCompatParts(DataGenerator generator) {
		super(generator, SilentCompat.MODID);
	}
	
	@Override
	public Collection<PartBuilder> getParts() {
		Collection<PartBuilder> ret = new ArrayList<>();
		
		SilentCompatItems.getItems(MainPartItem.class).forEach(item -> {
			PartBuilder builder = part(NameUtils.fromItem(item).getPath(), item.getGearType(), item.getPartType(), item);
			ret.add(addHeadStats(builder));
		});
		
		return ret;
	}
	
	private static PartBuilder addHeadStats(PartBuilder builder) {
		
		if (isMainPart(builder, SilentCompatItems.HALBERD_HEAD))
			return builder
					.stat(ItemStats.MELEE_DAMAGE, 4, StatInstance.Operation.ADD)
					.stat(ItemStats.ATTACK_SPEED, -3f, StatInstance.Operation.ADD)
					.stat(ItemStats.ATTACK_REACH, 1, StatInstance.Operation.ADD)
					.stat(ItemStats.REPAIR_EFFICIENCY, 1f);
		
		throw new IllegalArgumentException("Stats for " + builder.getId() + " are missing!");
	}
	
    private static boolean isMainPart(PartBuilder builder, ItemLike item) {
        if (!(item.asItem() instanceof MainPartItem))
            throw new IllegalArgumentException("Item " + NameUtils.fromItem(item) + " is not a main part item!");
        return builder.getId().equals(NameUtils.fromItem(item));
    }
	
    private static PartBuilder part(String name, GearType gearType, PartType partType, ItemLike item) {
        return new PartBuilder(new ModResourceLocation("silentcompat:" + name), gearType, partType, item)
                .name(Component.translatable("part.silentcompat." + name.replace('/', '.')));
    }

}
