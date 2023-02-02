package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SilentCompatItemModels extends ItemModelProvider {

	public SilentCompatItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			registerMaterialSetItemModels(set);
		}
		
		blockItemModel(SilentCompatItems.ARCMETAL_ORE_ITEM, "block/arcmetal_ore");
		blockItemModel(SilentCompatItems.VOIDMETAL_ORE_ITEM, "block/voidmetal_ore");
		blockItemModel(SilentCompatItems.SOLARMETAL_ORE_ITEM, "block/solarmetal_ore");
		blockItemModel(SilentCompatItems.PLASTEEL_ORE_ITEM, "block/plasteel_ore");
		
		singleTextureItemModel(SilentCompatItems.RAW_PLASTEEL, "item/raw_plasteel");
		singleTextureItemModel(SilentCompatItems.RAW_ARCMETAL, "item/raw_arcmetal");
		singleTextureItemModel(SilentCompatItems.RAW_VOIDMETAL, "item/raw_voidmetal");
		singleTextureItemModel(SilentCompatItems.RAW_SOLARMETAL, "item/raw_solarmetal");
		
		singleTextureItemModel(SilentCompatItems.OUTBACK_LEATHER, "item/outback_leather");
		singleTextureItemModel(SilentCompatItems.CHOCOLATECHIP, "item/chocolate_chip");
		singleTextureItemModel(SilentCompatItems.CRYSTALLINE_ALLOY, "item/crystalline_alloy");
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
