package com.github.dragoni7.silentcompat.core.registry;

import java.util.HashMap;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MaterialRegistry {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilentCompat.MODID);
	
	public static final HashMap<String, MaterialSet> MATERIAL_SETS = new HashMap<>();
	
	public static final RegistryObject<Block> SOLARMETAL_ORE = MaterialRegistry.BLOCKS.register("solarmetal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.BASALT), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> VOIDMETAL_ORE = MaterialRegistry.BLOCKS.register("voidmetal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> ARCMETAL_ORE = MaterialRegistry.BLOCKS.register("arcmetal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.STONE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> PLASTEEL_ORE = MaterialRegistry.BLOCKS.register("plasteel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS), UniformInt.of(3, 7)));
	
	public static void register(IEventBus modEventBus) {
		
		MATERIAL_SETS.put("midnight_iron", new MaterialSet("midnight_iron", MaterialColor.COLOR_BLACK));
		MATERIAL_SETS.put("dark_chocolate", new MaterialSet("dark_chocolate", MaterialColor.COLOR_BROWN));
		MATERIAL_SETS.put("sculk_alloy", new MaterialSet("sculk_alloy", MaterialColor.COLOR_PURPLE));
		MATERIAL_SETS.put("bunny_steel", new MaterialSet("bunny_steel", MaterialColor.METAL));
		MATERIAL_SETS.put("capsid_alloy", new MaterialSet("capsid_alloy", MaterialColor.COLOR_BROWN));
		MATERIAL_SETS.put("plasteel", new MaterialSet("plasteel", MaterialColor.COLOR_BLUE));
		MATERIAL_SETS.put("source_steel", new MaterialSet("source_steel", MaterialColor.COLOR_PINK));
		MATERIAL_SETS.put("arcmetal", new MaterialSet("arcmetal", MaterialColor.COLOR_CYAN));
		MATERIAL_SETS.put("solarmetal", new MaterialSet("solarmetal", MaterialColor.COLOR_ORANGE));
		MATERIAL_SETS.put("voidmetal", new MaterialSet("voidmetal", MaterialColor.COLOR_PURPLE));
		
		
		
		BLOCKS.register(modEventBus);
		SilentCompatItems.ITEMS.register(modEventBus);
		
		SilentCompat.LOGGER.info("registered SilentCompat materials");
	}
}
