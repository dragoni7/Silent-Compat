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
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
		.define('S', SilentCompatTags.STEEL_INGOT)
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
		.requires(SilentCompatTags.SKREECHER_SOUL)
		.requires(Items.OBSIDIAN)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_skreecher_soul", has(SilentCompatTags.SKREECHER_SOUL)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("dark_chocolate").ingot.get())
		.requires(SilentCompatTags.CHOCOLATE)
		.requires(Items.COCOA_BEANS)
		.requires(Items.COCOA_BEANS)
		.requires(Items.OBSIDIAN)
		.group(SilentCompat.MODID).unlockedBy("has_coco_beans", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(consumer);

		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("capsid_alloy").ingot.get())
		.requires(SilentCompatTags.CAPSID)
		.requires(SilentCompatTags.CAPSID)
		.requires(Items.DIAMOND)
		.requires(Items.DIAMOND)
		.group(SilentCompat.MODID).unlockedBy("has_capsid", has(SilentCompatTags.CAPSID)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(SilentCompatItems.OUTBACK_LEATHER.get(), 3)
		.requires(SilentCompatTags.EMU_FEATHER)
		.requires(SilentCompatTags.EMU_FEATHER)
		.requires(SilentCompatTags.KANGAROO_HIDE)
		.group(SilentCompat.MODID).unlockedBy("has_emu_feather", has(SilentCompatTags.EMU_FEATHER)).save(consumer);
		
		ShapelessRecipeBuilder.shapeless(MaterialRegistry.MATERIAL_SETS.get("source_steel").ingot.get())
		.requires(SilentCompatTags.STEEL_INGOT)
		.requires(SilentCompatTags.CONJURATION_ESSENCE)
		.requires(SilentCompatTags.ABJURATION_ESSENCE)
		.requires(SilentCompatTags.EARTH_ESSENCE)
		.requires(SilentCompatTags.SOURCE_GEM)
		.group(SilentCompat.MODID).unlockedBy("has_steel_ingot", has(SilentCompatTags.STEEL_INGOT)).save(consumer);
		
		createOreSmeltingRecipe(consumer, SilentCompatItems.ARCMETAL_ORE_ITEM.get(), MaterialRegistry.MATERIAL_SETS.get("arcmetal").ingot.get(), 1.0F, 300, "arcmetal_ore_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.VOIDMETAL_ORE_ITEM.get(), MaterialRegistry.MATERIAL_SETS.get("voidmetal").ingot.get(), 1.0F, 300, "voidmetal_ore_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.SOLARMETAL_ORE_ITEM.get(), MaterialRegistry.MATERIAL_SETS.get("solarmetal").ingot.get(), 1.0F, 300, "solarmetal_ore_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.PLASTEEL_ORE_ITEM.get(), MaterialRegistry.MATERIAL_SETS.get("plasteel").ingot.get(), 1.0F, 400, "plasteel_ore_to_ingot");
		
		createOreSmeltingRecipe(consumer, SilentCompatItems.RAW_ARCMETAL.get(), MaterialRegistry.MATERIAL_SETS.get("arcmetal").ingot.get(), 1.0F, 300, "raw_arcmetal_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.RAW_VOIDMETAL.get(), MaterialRegistry.MATERIAL_SETS.get("voidmetal").ingot.get(), 1.0F, 300, "raw_voidmetal_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.RAW_SOLARMETAL.get(), MaterialRegistry.MATERIAL_SETS.get("solarmetal").ingot.get(), 1.0F, 300, "raw_solarmetal_to_ingot");
		createOreSmeltingRecipe(consumer, SilentCompatItems.RAW_PLASTEEL.get(), MaterialRegistry.MATERIAL_SETS.get("plasteel").ingot.get(), 1.0F, 400, "raw_plasteel_to_ingot");
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
	
	private void createOreSmeltingRecipe(Consumer<FinishedRecipe> consumer, Item input, Item output, float xp, int time, String name) {
		  SimpleCookingRecipeBuilder.smelting(Ingredient.of(input),
				  output, xp, time) 
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name);
		  SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), 
				  output, xp, time/2)
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name + "_blasting");
	}

}
