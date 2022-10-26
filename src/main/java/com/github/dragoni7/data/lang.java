package com.github.dragoni7.data;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;
import com.github.dragoni7.core.SilentCompatItems;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class lang extends LanguageProvider {

	public lang(DataGenerator gen, String locale) {
		super(gen, SilentCompat.MODID, locale);
	}
	
	@Override
	protected void addTranslations() {
		add("itemGroup." + SilentCompat.MODID, "SilentCompat");
		
		translateMaterialSet(MaterialRegistry.MIDNIGHTIRON, "Midnight Iron");
		translateMaterialSet(MaterialRegistry.BUNNYSTEEL, "Bunny Steel");
		translateMaterialSet(MaterialRegistry.DARKCHOCOLATE, "Dark Chocolate");
		translateMaterialSet(MaterialRegistry.SCULKALLOY, "Sculk Alloy");
		translateMaterialSet(MaterialRegistry.CAPSID_ALLOY, "Capsid Alloy");
		
		add(SilentCompatItems.CHOCOLATECHIP.get(), "Chocolate Chip");
		
		add("trait.silentcompat.diurnal", "Diurnal");
		add("trait.silentcompat.diurnal.desc", "Deal increased damage during the day. Gear slowly repairs during the day");
		add("trait.silentcompat.nocturnal", "Diurnal");
		add("trait.silentcompat.nocturnal.desc", "Deal increased damage at night. Gear slowly repairs at night");
		add("trait.silentcompat.decay", "Decay");
		add("trait.silentcompat.decay.desc", "Applies Decay to targets");
		add("trait.silentcompat.ender_flu", "Ender Flu");
		add("trait.silentcompat.ender_flu.desc", "Infects the target with Ender Flu");
		add("trait.silentcompat.dodging", "Dodging");
		add("trait.silentcompat.dodging.desc", "Grants a chance to avoid damage.");
		add("trait.silentcompat.edible", "Edible");
		add("trait.silentcompat.edible.desc", "Chance to drop a chocolate chip on durability loss");
		add("trait.silentcompat.fleetfooted", "Fleet-Footed");
		add("trait.silentcompat.fleetfooted.desc", "Increases speed while jumping and sprinting on-hit");
		add("trait.silentcompat.freezing", "Freezing");
		add("trait.silentcompat.freezing.desc", "Attacks build up freezing on target. At max freeze, damage is dealth over time");
		add("trait.silentcompat.featherweight", "Featherweight");
		add("trait.silentcompat.featherweight.desc", "Targets take additional knockback when hit");
		add("trait.silentcompat.vorpal", "Vorpal");
		add("trait.silentcompat.vorpal.desc", "Deal more damage to targets with over 100 hearts");
		add("trait.silentcompat.hungering_strike", "Hungering Strike");
		add("trait.silentcompat.hungering_strike.desc", "Deal more damage while under half hunger");
		add("trait.silentcompat.soul_steal", "Soul Steal");
		add("trait.silentcompat.soul_steal.desc", "Chance to gain life steal on hit");
	}
	
	private void translateMaterialSet(MaterialSet set, String name) {
		add(set.ingot.get(), name + " Ingot");
		add(set.nugget.get(), name + " Nugget");
		add(set.block.get(), name + " Block");
		add("material.silentcompat." + set.name, name);
	}
}
