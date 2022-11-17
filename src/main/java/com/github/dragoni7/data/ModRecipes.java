package com.github.dragoni7.data;

import java.util.function.Consumer;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;
import com.github.dragoni7.core.SilentCompatItems;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes extends RecipeProvider {

	public ModRecipes(DataGenerator genIn) {
		super(genIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		materialSetRecipes(MaterialRegistry.BUNNYSTEEL, consumer);
		materialSetRecipes(MaterialRegistry.CAPSID_ALLOY, consumer);
		materialSetRecipes(MaterialRegistry.DARKCHOCOLATE, consumer);
		materialSetRecipes(MaterialRegistry.MIDNIGHTIRON, consumer);
		materialSetRecipes(MaterialRegistry.SCULKALLOY, consumer);
		materialSetRecipes(MaterialRegistry.PLASTEEL, consumer);
		materialSetRecipes(MaterialRegistry.SOURCE_STEEL, consumer);
		
		ShapedRecipeBuilder.shaped(MaterialRegistry.BUNNYSTEEL.ingot.get())
		.pattern(" L ")
		.pattern("RSR")
		.pattern(" L ")
		.define('R', Items.RABBIT_FOOT)
		.define('L', Items.RABBIT_HIDE)
		.define('S', ModItemTags.STEEL_INGOT)
		.group(SilentCompat.MODID).unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RABBIT_FOOT)).save(consumer);
		
		ShapedRecipeBuilder.shaped(MaterialRegistry.MIDNIGHTIRON.ingot.get())
		.pattern(" S ")
		.pattern("SIS")
		.pattern(" S ")
		.define('I', Items.IRON_INGOT)
		.define('S', Items.BLACKSTONE)
		.group(SilentCompat.MODID).unlockedBy("iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.SCULKALLOY.ingot.get())
		.requires(Items.ECHO_SHARD)
		.requires(ModItemTags.SKREECHER_SOUL)
		.requires(Items.OBSIDIAN)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(ModItemTags.SKREECHER_SOUL)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.DARKCHOCOLATE.ingot.get())
		.requires(ModItemTags.CHOCOLATE)
		.requires(Items.COCOA_BEANS)
		.requires(Items.COCOA_BEANS)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("coco_beans", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(consumer);

		ShapelessRecipeBuilder.shapeless(MaterialRegistry.CAPSID_ALLOY.ingot.get())
		.requires(ModItemTags.CAPSID)
		.requires(ModItemTags.CAPSID)
		.requires(Items.DIAMOND)
		.requires(Items.DIAMOND)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(ModItemTags.CAPSID)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(SilentCompatItems.OUTBACK_LEATHER.get(), 3)
		.requires(ModItemTags.EMU_FEATHER)
		.requires(ModItemTags.EMU_FEATHER)
		.requires(ModItemTags.KANGAROO_HIDE)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(ModItemTags.EMU_FEATHER)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.SOURCE_STEEL.ingot.get())
		.requires(ModItemTags.STEEL_INGOT)
		.requires(ModItemTags.CONJURATION_ESSENCE)
		.requires(ModItemTags.ABJURATION_ESSENCE)
		.requires(ModItemTags.EARTH_ESSENCE)
		.requires(ModItemTags.SOURCE_GEM)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(ModItemTags.STEEL_INGOT)).save(consumer);
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
