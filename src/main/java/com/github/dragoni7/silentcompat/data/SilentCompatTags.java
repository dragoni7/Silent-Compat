package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class SilentCompatTags {
	
	public static final TagKey<Block> SOLARMETAL_ORES = forgeBlockTag("ores/solarmetal");
	public static final TagKey<Block> VOIDMETAL_ORES = forgeBlockTag("ores/voidmetal");
	public static final TagKey<Block> ARCMETAL_ORES = forgeBlockTag("ores/arcmetal");
	public static final TagKey<Block> PLASTEEL_ORES = forgeBlockTag("ores/plasteel");
	
	public static final TagKey<Item> SOLARMETAL_ORES_ITEMS = forgeItemTag("ores/solarmetal");
	public static final TagKey<Item> VOIDMETAL_ORES_ITEMS = forgeItemTag("ores/voidmetal");
	public static final TagKey<Item> ARCMETAL_ORES_ITEMS = forgeItemTag("ores/arcmetal");
	public static final TagKey<Item> PLASTEEL_ORES_ITEMS = forgeItemTag("ores/plasteel");
	
	public static final TagKey<Item> RAW_MATERIAL_SOLARMETAL = forgeItemTag("raw_materials/solarmetal");
	public static final TagKey<Item> RAW_MATERIAL_VOIDMETAL = forgeItemTag("raw_materials/voidmetal");
	public static final TagKey<Item> RAW_MATERIAL_ARCMETAL = forgeItemTag("raw_materials/arcmetal");
	public static final TagKey<Item> RAW_MATERIAL_PLASTEEL = forgeItemTag("raw_materials/plasteel");
	
	public static final TagKey<Item> WARDEN_INGOT = forgeItemTag("ingots/warden");
	public static final TagKey<Item> OUTBACK_LEATHER = createItemTag("outback_leather");
	
	
	// Other mod's items

	public static final TagKey<Item> BEE_STINGER = createItemTag("bee_stinger");
	public static final TagKey<Item> BLAST_PROOF_PLATING = createItemTag("blast_proof_plating");
	public static final TagKey<Item> STEEL_INGOT = forgeItemTag("ingots/steel");
	public static final TagKey<Item> SOURCE_GEM = forgeItemTag("gems/source");
	public static final TagKey<Item> CONJURATION_ESSENCE = forgeItemTag("essence/conjuration");
	public static final TagKey<Item> ABJURATION_ESSENCE = forgeItemTag("essence/abjuration");
	public static final TagKey<Item> EARTH_ESSENCE = forgeItemTag("essence/earth");
	public static final TagKey<Item> CHOCOLATE = forgeItemTag("chocolate");
	public static final TagKey<Item> SKREECHER_SOUL = createItemTag("skreecher_soul");
	public static final TagKey<Item> CAPSID = createItemTag("capsid");
	public static final TagKey<Item> ALPHA_YETI_FUR = createItemTag("alpha_yeti_fur");
	public static final TagKey<Item> CLOTH = createItemTag("cloth");
	public static final TagKey<Item> CRYPTIC_END_ROD = createItemTag("cryptic_end_rod");
	public static final TagKey<Item> DRAGON_SCALE = forgeItemTag("dragon_scale");
	public static final TagKey<Item> ELASTIC_TENDON = createItemTag("elastic_tendon");
	public static final TagKey<Item> EMU_FEATHER = createItemTag("emu_feather");
	public static final TagKey<Item> KANGAROO_HIDE = createItemTag("kangaroo_hide");
	public static final TagKey<Item> FARSEER_ARM = createItemTag("farseer_arm");
	public static final TagKey<Item> FORTUNES_FAVOR = createItemTag("fortunes_favor");
	public static final TagKey<Item> HONEY_CRYSTAL = forgeItemTag("gems/honey_crystal_shards");
	public static final TagKey<Item> TENTACLE = createItemTag("tentacle");
	public static final TagKey<Item> MASTICATOR_SCALE = createItemTag("masticator_scales");
	public static final TagKey<Item> MOSSY_TOOTH = createItemTag("mossy_tooth");
	public static final TagKey<Item> NAGA_SCALE = createItemTag("naga_scale");
	public static final TagKey<Item> PHANTOPLASM = createItemTag("phantoplasm");
	public static final TagKey<Item> ROADRUNNER = createItemTag("roadrunner_feather");
	public static final TagKey<Item> ROCKY_SHELL = createItemTag("rocky_shell");
	public static final TagKey<Item> SCULK_VINE = createItemTag("sculk_vines");
	public static final TagKey<Item> TARANTUAL_HAWK = createItemTag("tarantula_hawk_wing");
	public static final TagKey<Item> VOID_WORM = createItemTag("void_worm");
	public static final TagKey<Item> ROTTEN_FLESH = createItemTag("rotten_flesh");
	public static final TagKey<Item> ANDESITE_ALLOY = forgeItemTag("ingots/andesite_alloy");
	public static final TagKey<Item> CAST_IRON = forgeItemTag("ingots/cast_iron");
	public static final TagKey<Item> SOUL_STEEL = forgeItemTag("ingots/soul_steel");
	public static final TagKey<Item> SHARK_TOOTH = createItemTag("shark_tooth");
	public static final TagKey<Item> GAZELLE_HORN = createItemTag("gazelle_horn");
	public static final TagKey<Item> CROCODILE = createItemTag("crocodile_scute");
	public static final TagKey<Item> KOMODO_SPIT = createItemTag("komodo_spit");
	public static final TagKey<Item> MIMICREAM = createItemTag("mimicream");
	public static final TagKey<Item> CENTIPEDE = createItemTag("centipede_leg");
	public static final TagKey<Item> STRADDLITE = createItemTag("straddlite");
	public static final TagKey<Item> OOZE = createItemTag("ooze");
	public static final TagKey<Item> MAGE_FIBER = createItemTag("magebloom_fiber");
	public static final TagKey<Item> BLAZE_FIBER = createItemTag("blaze_fiber");
	public static final TagKey<Item> END_FIBER = createItemTag("end_fiber");
	public static final TagKey<Item> SCULK_BONE = createItemTag("sculk_bone");
	public static final TagKey<Item> SOUL_CRYSTAL = createItemTag("soul_crystal");
	public static final TagKey<Item> GOO = createItemTag("goo");
	public static final TagKey<Item> MOGMOSS = createItemTag("mogmoss");
	public static final TagKey<Item> DITCHBULB = createItemTag("ditchbulb");
	public static final TagKey<Item> BRUTE_TUSK = createItemTag("brute_tusk");
	public static final TagKey<Item> BEAR_HAIR = createItemTag("bear_hair");
	public static final TagKey<Item> SERPENT_TOOTH = createItemTag("serpent_tooth");
	public static final TagKey<Item> BLOOD_SAC = createItemTag("blood_sac");
	public static final TagKey<Item> HEMOLYMPH_SAC = createItemTag("hemolymph_sac");
	public static final TagKey<Item> RACCOON_TAIL = createItemTag("raccoon_tail");
	public static final TagKey<Item> ANTLER = createItemTag("moose_antler");
	public static final TagKey<Item> SPIKED_SCUTE = createItemTag("spiked_scute");
	public static final TagKey<Item> COCKROACH_WING = createItemTag("cockroach_wing");
	public static final TagKey<Item> DROPBEAR_CLAW = createItemTag("dropbear_claw");
	public static final TagKey<Item> WHALE_TOOTH = createItemTag("whale_tooth");
	public static final TagKey<Item> SERRATED_SHARK_TOOTH = createItemTag("serrated_shark_tooth");
	public static final TagKey<Item> FROSTSTALKER_HORN = createItemTag("froststalker_horn");
	public static final TagKey<Item> BISON_FUR = createItemTag("bison_fur");
	public static final TagKey<Item> FISH_BONES = createItemTag("fish_bones");
	public static final TagKey<Item> STELLIUM = forgeItemTag("ingots/stellium");
	public static final TagKey<Item> IGNITIUM = forgeItemTag("ingots/ignitium");
	public static final TagKey<Item> WITHERITE = forgeItemTag("ingots/witherite");
	public static final TagKey<Item> MONSTEROUS_HORN = createItemTag("monstrous_horn");
	public static final TagKey<Item> VOID_CORE = forgeItemTag("gems/void");
	public static final TagKey<Item> VOID_SHARD = forgeItemTag("gems/void_crystal_shard");
	public static final TagKey<Item> CRYSTAL_SHARD = forgeItemTag("gems/crystal_shard");
	public static final TagKey<Item> CRYSTALLINE_ALLOY = createItemTag("crystalline_alloy");
	public static final TagKey<Item> GLOW_SILK = createItemTag("glowsilk");
	public static final TagKey<Item> ALLURITE = forgeItemTag("gems/allurite");
	public static final TagKey<Item> LUMIERE = forgeItemTag("gems/lumiere");
	public static final TagKey<Item> CINDERSHELL_SHARD = createItemTag("cindershell_shard");
	public static final TagKey<Item> YETI_HIDE = createItemTag("yeti_hide");
	public static final TagKey<Item> REINFORCED_ECHO_SHARD = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("deeperdarker:reinforced_echo_shard"));
	public static final TagKey<Item> CRUDE_CLADDING = createItemTag("crude_cladding");
	public static final TagKey<Item> PROSPERITY_SHARD = forgeItemTag("shards/prosperity");
	public static final TagKey<Item> EXOTIC_FLESH = createItemTag("exotic_flesh");
	public static final TagKey<Item> LIVING_FLESH = createItemTag("living_flesh");
	public static final TagKey<Item> UNSTABLE_COMPOUND = createItemTag("unstable_compound");
	public static final TagKey<Item> CORROSIVE_ADDITIVE = createItemTag("corrosive_additive");
	public static final TagKey<Item> GAIA_INGOT = forgeItemTag("ingots/gaia");
	public static final TagKey<Item> GAIA_STEEL_INGOT = forgeItemTag("ingots/gaiasteel");
	public static final TagKey<Item> ALF_STEEL_INGOT = forgeItemTag("ingots/alfsteel");
	public static final TagKey<Item> MANA_WEAVE = createItemTag("mana_weave");
	public static final TagKey<Item> VENOM_SAC = createItemTag("venom_sac");
	public static final TagKey<Item> MAJ_ENDERIUM = createItemTag("maj_enderium");
	
	private static TagKey<Item> createItemTag(String name) {
		return ItemTags.create(SilentCompat.getId(name));
	}
	
	private static TagKey<Item> forgeItemTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}
	
	private static TagKey<Block> forgeBlockTag(String name) {
		return BlockTags.create(new ResourceLocation("forge", name));
	}
}