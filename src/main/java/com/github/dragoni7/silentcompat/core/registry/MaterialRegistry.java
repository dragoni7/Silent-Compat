package com.github.dragoni7.silentcompat.core.registry;

import java.util.HashMap;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MaterialRegistry {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilentCompat.MODID);
	
	public static final HashMap<String, MaterialSet> MATERIAL_SETS = new HashMap<>();
	
	/*public static final MaterialSet MIDNIGHTIRON = new MaterialSet("midnight_iron", MaterialColor.METAL);
	public static final MaterialSet DARKCHOCOLATE = new MaterialSet("dark_chocolate", MaterialColor.COLOR_BROWN);
	public static final MaterialSet SCULKALLOY = new MaterialSet("sculk_alloy", MaterialColor.COLOR_PURPLE);
	public static final MaterialSet BUNNYSTEEL = new MaterialSet("bunny_steel", MaterialColor.COLOR_BROWN);
	public static final MaterialSet CAPSID_ALLOY = new MaterialSet("capsid_alloy", MaterialColor.COLOR_PURPLE);
	public static final MaterialSet PLASTEEL = new MaterialSet("plasteel", MaterialColor.COLOR_BLUE);
	public static final MaterialSet SOURCE_STEEL = new MaterialSet("source_steel", MaterialColor.COLOR_PINK);
	public static final MaterialSet ARCMETAL = new MaterialSet("arcmetal", MaterialColor.COLOR_CYAN);
	public static final MaterialSet SOLARMETAL = new MaterialSet("solarmetal", MaterialColor.COLOR_ORANGE);
	public static final MaterialSet VOIDMETAL = new MaterialSet("voidmetal", MaterialColor.COLOR_PURPLE);*/
	
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
