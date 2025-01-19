package com.github.dragoni7.silentcompat.item;

import net.minecraftforge.common.ToolActions;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.item.gear.GearSwordItem;

public class GearBattleStaffItem extends GearSwordItem {
	
	public static final GearType GEAR_TYPE = GearType.getOrCreate("battlestaff",  GearType.MELEE_WEAPON, b -> 
	b.toolActions(ToolActions.DEFAULT_SWORD_ACTIONS));

	public GearBattleStaffItem() {
		super(GEAR_TYPE);
	}
}
