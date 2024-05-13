package com.github.dragoni7.silentcompat.item;

import net.minecraftforge.common.ToolActions;
import net.silentchaos512.gear.api.item.GearType;

public final class SilentCompatGearType {

	public static final GearType HALBERD = GearType.getOrCreate("halberd",  GearType.MELEE_WEAPON, b -> 
	b.toolActions(ToolActions.DEFAULT_SWORD_ACTIONS));
}
