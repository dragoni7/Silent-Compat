package com.github.dragoni7.silentcompat.data;

import java.util.Collections;
import java.util.List;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		
		if (event.includeServer()) {
			generator.addProvider(true, new SilentCompatRecipes(packOutput));
			generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(SilentCompatLootTables::new, LootContextParamSets.BLOCK))));
			AddBlockTags blocks = new AddBlockTags(event);
			generator.addProvider(true, blocks);
			generator.addProvider(true, new AddItemTags(event, blocks));
		}
		
		if (event.includeClient()) {
			generator.addProvider(true, new SilentCompatBlockStates(packOutput, fileHelper));
			generator.addProvider(true, new SilentCompatItemModels(packOutput, fileHelper));
			generator.addProvider(true, new lang(packOutput, "en_us"));
		}
	}
}
