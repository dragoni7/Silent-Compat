package com.github.dragoni7.silentcompat.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.MaterialRegistry;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class SilentCompatLootTables extends LootTableProvider {
	
	protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
	private final DataGenerator generator;

	public SilentCompatLootTables(DataGenerator genIn) {
		super(genIn);
		this.generator = genIn;
	}
	
	protected void addTables() {
		basicBlockTable(MaterialRegistry.BUNNYSTEEL.block.get(), "bunny_steel_block");
		basicBlockTable(MaterialRegistry.CAPSID_ALLOY.block.get(), "capsid_alloy_block");
		basicBlockTable(MaterialRegistry.DARKCHOCOLATE.block.get(), "dark_chocolate_block");
		basicBlockTable(MaterialRegistry.MIDNIGHTIRON.block.get(), "midnight_iron_block");
		basicBlockTable(MaterialRegistry.SCULKALLOY.block.get(), "sculk_alloy_block");
		basicBlockTable(MaterialRegistry.PLASTEEL.block.get(), "plasteel_block");
		basicBlockTable(MaterialRegistry.SOURCE_STEEL.block.get(), "source_steel_block");
	}
	
	@Override
	public void run(CachedOutput cache) {
		addTables();
		
		Map<ResourceLocation, LootTable> tables = new HashMap<>();
		for(Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
			tables.put(entry.getKey().getLootTable(),entry.getValue().setParamSet(LootContextParamSets.BLOCK).build());
			
		}
		writeTables(cache, tables);
	}
	
	private void basicBlockTable(Block block, String name) {
		lootTables.put(block, simpleBlockTable(name, block));
	}
	
	private LootTable.Builder simpleBlockTable(String name, Block block) {
		LootPool.Builder builder = LootPool.lootPool()
				.name(name)
				.setRolls(ConstantValue.exactly(1))
				.add(LootItem.lootTableItem(block));
				return LootTable.lootTable().withPool(builder);
	}
	
	private void writeTables(CachedOutput cache, Map<ResourceLocation, LootTable> tables) {
		Path outputFolder = this.generator.getOutputFolder();
		tables.forEach((key, lootTable) -> {
			Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
			try {
				DataProvider.saveStable(cache, LootTables.serialize(lootTable), path);
			} catch(IOException e) {
				SilentCompat.LOGGER.error("Couldn't write loot table {}", path, e);
			}
		});
	}
	
	@Override
	public String getName() {
		return "SilentCompat LootTables";
	}

}
