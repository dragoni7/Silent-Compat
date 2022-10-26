package com.github.dragoni7.data;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;
import com.github.dragoni7.core.SilentCompatItems;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModels extends ItemModelProvider {

	public ModItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		registerMaterialSetItemModels(MaterialRegistry.MIDNIGHTIRON);
		registerMaterialSetItemModels(MaterialRegistry.BUNNYSTEEL);
		registerMaterialSetItemModels(MaterialRegistry.DARKCHOCOLATE);
		registerMaterialSetItemModels(MaterialRegistry.SCULKALLOY);
		registerMaterialSetItemModels(MaterialRegistry.CAPSID_ALLOY);
		
		singleTextureItemModel(SilentCompatItems.CHOCOLATECHIP, "item/chocolate_chip");
	}
	
	private void registerMaterialSetItemModels(MaterialSet set) {
		blockItemModel(set.blockItem, "block/" + set.name + "_block");
		singleTextureItemModel(set.ingot, "item/" + set.name + "_ingot");
		singleTextureItemModel(set.nugget, "item/" + set.name + "_nugget");
	}
	
	private void singleTextureItemModel(RegistryObject<Item> item, String path) {
		singleTexture(item.getId().getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(SilentCompat.MODID, path));
		
	}

	private void blockItemModel(RegistryObject<Item> item, String path) {
		withExistingParent(item.getId().getPath(), new ResourceLocation(SilentCompat.MODID, path));
	}

}
