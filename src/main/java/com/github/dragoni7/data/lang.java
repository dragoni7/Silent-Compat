package com.github.dragoni7.data;

import com.github.dragoni7.SilentCompat;
import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;

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
		
		add("trait.silentcompat.diurnal", "Diurnal");
		add("trait.silentcompat.diurnal.desc", "Deal increased damage during the day. Gear slowly repairs during the day");
		add("trait.silentcompat.nocturnal", "Diurnal");
		add("trait.silentcompat.nocturnal.desc", "Deal increased damage at night. Gear slowly repairs at night");
	}
	
	private void translateMaterialSet(MaterialSet set, String name) {
		add(set.ingot.get(), name + " Ingot");
		add(set.nugget.get(), name + " Nugget");
		add(set.block.get(), name + " Block");
		add("material.silentcompat." + set.name, name);
	}
}
