package com.github.dragoni7.silentcompat.data;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;

public class SilentCompatLootTables extends VanillaBlockLoot {
	
	protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
	
	protected void addTables() {
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			basicBlockTable(set.block.get(), set.name + "_block");
		}
		
		rareOreTable(MaterialRegistry.ARCMETAL_ORE.get(), SilentCompatItems.RAW_ARCMETAL.get(), "arcmetal_ore");
		rareOreTable(MaterialRegistry.SOLARMETAL_ORE.get(), SilentCompatItems.RAW_SOLARMETAL.get(), "solarmetal_ore");
		rareOreTable(MaterialRegistry.VOIDMETAL_ORE.get(), SilentCompatItems.RAW_VOIDMETAL.get(), "voidmetal_ore");
		rareOreTable(MaterialRegistry.PLASTEEL_ORE.get(), SilentCompatItems.RAW_PLASTEEL.get(), "plasteel_ore");
	}
	
	@Override
	protected void generate() {
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			basicBlockTable(set.block.get(), set.name + "_block");
		}
		
		rareOreTable(MaterialRegistry.ARCMETAL_ORE.get(), SilentCompatItems.RAW_ARCMETAL.get(), "arcmetal_ore");
		rareOreTable(MaterialRegistry.SOLARMETAL_ORE.get(), SilentCompatItems.RAW_SOLARMETAL.get(), "solarmetal_ore");
		rareOreTable(MaterialRegistry.VOIDMETAL_ORE.get(), SilentCompatItems.RAW_VOIDMETAL.get(), "voidmetal_ore");
		rareOreTable(MaterialRegistry.PLASTEEL_ORE.get(), SilentCompatItems.RAW_PLASTEEL.get(), "plasteel_ore");
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(SilentCompat.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
	}
	
	private void basicBlockTable(Block block, String name) {
		lootTables.put(block, simpleBlockTable(name, block));
	}
	
	private void rareOreTable(Block block, Item item, String name) {
		lootTables.put(block, createSilkTouchTable(name, block, item, 1, 1));
	}
	
	private LootTable.Builder createSilkTouchTable(String name, Block block, Item item, float min, float max) {
		LootPool.Builder builder = LootPool.lootPool()
				.name(name)
				.setRolls(ConstantValue.exactly(1))
				.add(AlternativesEntry.alternatives(
						LootItem.lootTableItem(block)
						.when(MatchTool.toolMatches(ItemPredicate.Builder.item()
								.hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
						LootItem.lootTableItem(item)
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
						.apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
						.apply(ApplyExplosionDecay.explosionDecay())
					)
				);
		return LootTable.lootTable().withPool(builder);
	}
	
	private LootTable.Builder simpleBlockTable(String name, Block block) {
		LootPool.Builder builder = LootPool.lootPool()
				.name(name)
				.setRolls(ConstantValue.exactly(1))
				.add(LootItem.lootTableItem(block));
				return LootTable.lootTable().withPool(builder);
	}
}
