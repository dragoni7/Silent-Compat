package com.github.dragoni7.silentcompat.data;

import java.util.function.Consumer;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.MaterialSet;
import com.github.dragoni7.silentcompat.core.SilentCompatItems;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

public class SilentCompatRecipes extends RecipeProvider {

	public SilentCompatRecipes(DataGenerator genIn) {
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
		.define('S', SilentCompatItemTags.STEEL_INGOT)
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
		.requires(SilentCompatItemTags.SKREECHER_SOUL)
		.requires(Items.OBSIDIAN)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(SilentCompatItemTags.SKREECHER_SOUL)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.DARKCHOCOLATE.ingot.get())
		.requires(SilentCompatItemTags.CHOCOLATE)
		.requires(Items.COCOA_BEANS)
		.requires(Items.COCOA_BEANS)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("coco_beans", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(consumer);

		ShapelessRecipeBuilder.shapeless(MaterialRegistry.CAPSID_ALLOY.ingot.get())
		.requires(SilentCompatItemTags.CAPSID)
		.requires(SilentCompatItemTags.CAPSID)
		.requires(Items.DIAMOND)
		.requires(Items.DIAMOND)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(SilentCompatItemTags.CAPSID)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(SilentCompatItems.OUTBACK_LEATHER.get(), 3)
		.requires(SilentCompatItemTags.EMU_FEATHER)
		.requires(SilentCompatItemTags.EMU_FEATHER)
		.requires(SilentCompatItemTags.KANGAROO_HIDE)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(SilentCompatItemTags.EMU_FEATHER)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.SOURCE_STEEL.ingot.get())
		.requires(SilentCompatItemTags.STEEL_INGOT)
		.requires(SilentCompatItemTags.CONJURATION_ESSENCE)
		.requires(SilentCompatItemTags.ABJURATION_ESSENCE)
		.requires(SilentCompatItemTags.EARTH_ESSENCE)
		.requires(SilentCompatItemTags.SOURCE_GEM)
		.group(SilentCompat.MODID).unlockedBy("has_item", has(SilentCompatItemTags.STEEL_INGOT)).save(consumer);
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
