package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
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
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		
		if (event.includeServer()) {
			generator.addProvider(true, new SilentCompatRecipes(generator));
			generator.addProvider(true, new SilentCompatLootTables(generator));
			BlockTagsProvider blocks = new BlockTagsProvider(generator, SilentCompat.MODID, fileHelper);
			generator.addProvider(true, new AddBlockTags(generator, fileHelper));
			generator.addProvider(true, new AddItemTags(generator, blocks, fileHelper));
		}
		
		if (event.includeClient()) {
			generator.addProvider(true, new SilentCompatBlockStates(generator, SilentCompat.MODID, fileHelper));
			generator.addProvider(true, new SilentCompatItemModels(generator, SilentCompat.MODID, fileHelper));
			generator.addProvider(true, new lang(generator, "en_us"));
		}
	}
}
