package com.github.dragoni7.silentcompat.core.registry;

import java.util.HashMap;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MaterialRegistry {
	
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SilentCompat.MODID);
	
	public static final HashMap<String, MaterialSet> MATERIAL_SETS = new HashMap<>();
	
	public static final DeferredBlock<Block> SOLARMETAL_ORE = BLOCKS.register("solarmetal_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.BASALT)));
	public static final DeferredBlock<Block> VOIDMETAL_ORE = BLOCKS.register("voidmetal_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.DEEPSLATE)));
	public static final DeferredBlock<Block> ARCMETAL_ORE = BLOCKS.register("arcmetal_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.STONE)));
	public static final DeferredBlock<Block> PLASTEEL_ORE = BLOCKS.register("plasteel_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)));
	
	public static void register(IEventBus modEventBus) {
		
		MATERIAL_SETS.put("midnight_iron", new MaterialSet("midnight_iron", MapColor.COLOR_BLACK));
		MATERIAL_SETS.put("dark_chocolate", new MaterialSet("dark_chocolate", MapColor.COLOR_BROWN));
		MATERIAL_SETS.put("sculk_alloy", new MaterialSet("sculk_alloy", MapColor.COLOR_PURPLE));
		MATERIAL_SETS.put("bunny_steel", new MaterialSet("bunny_steel", MapColor.METAL));
		MATERIAL_SETS.put("capsid_alloy", new MaterialSet("capsid_alloy", MapColor.COLOR_BROWN));
		MATERIAL_SETS.put("plasteel", new MaterialSet("plasteel", MapColor.COLOR_BLUE));
		MATERIAL_SETS.put("source_steel", new MaterialSet("source_steel", MapColor.COLOR_PINK));
		MATERIAL_SETS.put("arcmetal", new MaterialSet("arcmetal", MapColor.COLOR_CYAN));
		MATERIAL_SETS.put("solarmetal", new MaterialSet("solarmetal", MapColor.COLOR_ORANGE));
		MATERIAL_SETS.put("voidmetal", new MaterialSet("voidmetal", MapColor.COLOR_PURPLE));
		
		
		
		BLOCKS.register(modEventBus);
		SilentCompatItems.ITEMS.register(modEventBus);
		
		SilentCompat.LOGGER.info("registered SilentCompat materials");
	}
}
