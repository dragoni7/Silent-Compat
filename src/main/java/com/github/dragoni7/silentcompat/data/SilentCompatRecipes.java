package com.github.dragoni7.silentcompat.data;

import java.util.function.Consumer;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

public class SilentCompatRecipes extends RecipeProvider {

	public SilentCompatRecipes(DataGenerator genIn) {
		super(genIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			materialSetRecipes(set, consumer);
		}
		
		ShapedRecipeBuilder.shaped(MaterialRegistry.MATERIAL_SETS.get("bunny_steel").ingot.get())
		.pattern(" L ")
		.pattern("RSR")
		.pattern(" L ")
		.define('R', Items.RABBIT_FOOT)
		.define('L', Items.RABBIT_HIDE)
		.define('S', SilentCompatItemTags.STEEL_INGOT)
		.group(SilentCompat.MODID).unlockedBy("has_steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RABBIT_FOOT)).save(consumer);
		
		ShapedRecipeBuilder.shaped(MaterialRegistry.MATERIAL_SETS.get("midnight_iron").ingot.get())
		.pattern(" S ")
		.pattern("SIS")
		.pattern(" S ")
		.define('I', Items.IRON_INGOT)
		.define('S', Items.BLACKSTONE)
		.group(SilentCompat.MODID).unlockedBy("has_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("sculk_alloy").ingot.get())
		.requires(Items.ECHO_SHARD)
		.requires(SilentCompatItemTags.SKREECHER_SOUL)
		.requires(Items.OBSIDIAN)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_skreecher_soul", has(SilentCompatItemTags.SKREECHER_SOUL)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("dark_chocolate").ingot.get())
		.requires(SilentCompatItemTags.CHOCOLATE)
		.requires(Items.COCOA_BEANS)
		.requires(Items.COCOA_BEANS)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_coco_beans", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(consumer);

		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("capsid_alloy").ingot.get())
		.requires(SilentCompatItemTags.CAPSID)
		.requires(SilentCompatItemTags.CAPSID)
		.requires(Items.DIAMOND)
		.requires(Items.DIAMOND)
		.group(SilentCompat.MODID).unlockedBy("has_capsid", has(SilentCompatItemTags.CAPSID)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(SilentCompatItems.OUTBACK_LEATHER.get(), 3)
		.requires(SilentCompatItemTags.EMU_FEATHER)
		.requires(SilentCompatItemTags.EMU_FEATHER)
		.requires(SilentCompatItemTags.KANGAROO_HIDE)
		.group(SilentCompat.MODID).unlockedBy("has_emu_feather", has(SilentCompatItemTags.EMU_FEATHER)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("source_steel").ingot.get())
		.requires(SilentCompatItemTags.STEEL_INGOT)
		.requires(SilentCompatItemTags.CONJURATION_ESSENCE)
		.requires(SilentCompatItemTags.ABJURATION_ESSENCE)
		.requires(SilentCompatItemTags.EARTH_ESSENCE)
		.requires(SilentCompatItemTags.SOURCE_GEM)
		.group(SilentCompat.MODID).unlockedBy("has_steel_ingot", has(SilentCompatItemTags.STEEL_INGOT)).save(consumer);
	}
	
	private void materialSetRecipes(MaterialSet set, Consumer<FinishedRecipe> consumer) {
		unpackingRecipe(set.ingot.get(), set.nugget.get(), consumer);
		unpackingRecipe(set.blockItem.get(), set.ingot.get(), consumer);
		packingRecipe(set.nugget.get(), set.ingot.get(), consumer);
		packingRecipe(set.ingot.get(), set.blockItem.get(), consumer);
	}
	
	private void unpackingRecipe(Item itemIn, Item itemOut, Consumer<FinishedRecipe> consumer) {
		String itemName = ForgeRegistries.ITEMS.getKey(itemIn).getPath();
		ShapelessRecipeBuilder.shapeless(itemOut, 9)
		.requires(itemIn)
		.group(SilentCompat.MODID).unlockedBy(ForgeRegistries.ITEMS.getKey(itemIn).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(itemIn))
		.save(consumer, itemName + "_unpacking");
	}
	
	private void packingRecipe(Item itemIn, Item itemOut, Consumer<FinishedRecipe> consumer) {
		String itemName = ForgeRegistries.ITEMS.getKey(itemIn).getPath();
		ShapelessRecipeBuilder.shapeless(itemOut)
		.requires(itemIn, 9)
		.group(SilentCompat.MODID).unlockedBy(itemName, InventoryChangeTrigger.TriggerInstance.hasItems(itemIn))
		.save(consumer, itemName + "_packing");
	}

}
