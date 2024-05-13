package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.RegistryObject;
import net.silentchaos512.gear.api.item.ICoreItem;
import net.silentchaos512.gear.item.MainPartItem;
import net.silentchaos512.gear.util.Const;
import net.silentchaos512.lib.registry.ItemRegistryObject;

public class SilentCompatItemModels extends ItemModelProvider {

	public SilentCompatItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, SilentCompat.MODID, existingFileHelper);
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
		
		ModelFile itemHandheld = getExistingFile(new ResourceLocation("item/handheld"));
		
		tempGearStandardTool(SilentCompatItems.HALBERD, itemHandheld);
		
		tempMainPart(SilentCompatItems.HALBERD_HEAD);
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
	
    private ItemModelBuilder tempGearStandardTool(ItemRegistryObject<? extends ICoreItem> item, ModelFile parent) {
        String name = item.get().getGearType().getName();
        String path = item.getId().getPath();
        ModelFile mainModelFile = new ModelFile.UncheckedModelFile(modLoc("item/" + path));

        ItemModelBuilder model_lc = getBuilder(path + "_lc")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_lc");
        ItemModelBuilder model_hc = getBuilder(path + "_hc")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_hc")
                .texture("layer2", "item/" + name + "/_highlight");
        ItemModelBuilder model_lc_tip = getBuilder(path + "_lc_tip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_lc")
                .texture("layer2", "item/blank")
                .texture("layer3", "item/" + name + "/tip_sharp");
        ItemModelBuilder model_hc_tip = getBuilder(path + "_hc_tip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_hc")
                .texture("layer2", "item/" + name + "/_highlight")
                .texture("layer3", "item/" + name + "/tip_sharp");
        ItemModelBuilder model_lc_grip = getBuilder(path + "_lc_grip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_lc")
                .texture("layer2", "item/blank")
                .texture("layer3", "item/blank")
                .texture("layer4", "item/" + name + "/grip_wool");
        ItemModelBuilder model_hc_grip = getBuilder(path + "_hc_grip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_hc")
                .texture("layer2", "item/" + name + "/_highlight")
                .texture("layer3", "item/blank")
                .texture("layer4", "item/" + name + "/grip_wool");
        ItemModelBuilder model_lc_tip_grip = getBuilder(path + "_lc_tip_grip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_lc")
                .texture("layer2", "item/blank")
                .texture("layer3", "item/" + name + "/tip_sharp")
                .texture("layer4", "item/" + name + "/grip_wool");
        ItemModelBuilder model_hc_tip_grip = getBuilder(path + "_hc_tip_grip")
                .parent(mainModelFile)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_hc")
                .texture("layer2", "item/" + name + "/_highlight")
                .texture("layer3", "item/" + name + "/tip_sharp")
                .texture("layer4", "item/" + name + "/grip_wool");

        ItemModelBuilder mainBuilder = getBuilder(path)
                .parent(parent)
                .override().predicate(Const.MODEL, 2).model(model_lc).end()
                .override().predicate(Const.MODEL, 3).model(model_hc).end()
                .override().predicate(Const.MODEL, 4 | 2).model(model_lc_tip).end()
                .override().predicate(Const.MODEL, 4 | 3).model(model_hc_tip).end()
                .override().predicate(Const.MODEL, 8 | 2).model(model_lc_grip).end()
                .override().predicate(Const.MODEL, 8 | 3).model(model_hc_grip).end()
                .override().predicate(Const.MODEL, 8 | 4 | 2).model(model_lc_tip_grip).end()
                .override().predicate(Const.MODEL, 8 | 4 | 3).model(model_hc_tip_grip).end()
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_lc");
        return mainBuilder;
    }

    private ItemModelBuilder tempGear(ItemRegistryObject<? extends ICoreItem> item, ModelFile parent) {
        String name = item.get().getGearType().getName();
        return getBuilder(item.getId().getPath())
                .parent(parent)
                .texture("layer0", "item/" + name + "/rod_generic_lc")
                .texture("layer1", "item/" + name + "/main_generic_hc")
                .texture("layer2", "item/" + name + "/_highlight");
    }
    
    private ItemModelBuilder tempMainPart(ItemRegistryObject<MainPartItem> item) {
        String name = item.get().getGearType().getName();
        return getBuilder(item.getId().getPath())
                .parent(getExistingFile(new ResourceLocation("item/generated")))
                .texture("layer0", "item/" + name + "/main_generic_hc")
                .texture("layer1", "item/" + name + "/_highlight")
                .texture("layer2", "item/part_marker");
    }

}
