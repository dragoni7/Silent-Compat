package com.github.dragoni7.silentcompat.item;

import java.util.function.Supplier;

import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.item.gear.GearSwordItem;

public class GearHalberdItem extends GearSwordItem {
	
	public final Supplier<GearType> gearType;

	public GearHalberdItem(Supplier<GearType> gearType) {
		super(gearType);
		this.gearType = gearType;
	}
}
