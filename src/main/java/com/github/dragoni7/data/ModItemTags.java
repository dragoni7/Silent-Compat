package com.github.dragoni7.data;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
	
	public static final TagKey<Item> RAW_PLASTEEL = forgeTag("raw_materials/plasteel");
	
	// Other mod's items

	public static final TagKey<Item> BEE_STINGER = createTag("bee_stinger");
	public static final TagKey<Item> BLAST_PROOF_PLATING = createTag("blast_proof_plating");
	public static final TagKey<Item> STEEL_INGOT = forgeTag("ingots/steel");
	public static final TagKey<Item> CHOCOLATE = forgeTag("chocolate");
	public static final TagKey<Item> SKREECHER_SOUL = createTag("skreecher_soul");
	public static final TagKey<Item> CAPSID = createTag("capsid");
	public static final TagKey<Item> ALPHA_YETI_FUR = createTag("alpha_yeti_fur");
	public static final TagKey<Item> CLOTH = createTag("cloth");
	public static final TagKey<Item> CRYPTIC_END_ROD = createTag("cryptic_end_rod");
	public static final TagKey<Item> DRAGON_SCALE = forgeTag("dragon_scale");
	public static final TagKey<Item> ELASTIC_TENDON = createTag("elastic_tendon");
	public static final TagKey<Item> EMU_FEATHER = createTag("emu_feather");
	public static final TagKey<Item> FARSEER_ARM = createTag("farseer_arm");
	public static final TagKey<Item> FORTUNES_FAVOR = createTag("fortunes_favor");
	public static final TagKey<Item> HONEY_CRYSTAL = forgeTag("gems/honey_crystal_shards");
	public static final TagKey<Item> TENTACLE = createTag("tentacle");
	public static final TagKey<Item> MASTICATOR_SCALE = createTag("masticator_scales");
	public static final TagKey<Item> MOSSY_TOOTH = createTag("mossy_tooth");
	public static final TagKey<Item> NAGA_SCALE = createTag("naga_scale");
	public static final TagKey<Item> PHANTOPLASM = createTag("phantoplasm");
	public static final TagKey<Item> ROADRUNNER = createTag("roadrunner_feather");
	public static final TagKey<Item> ROCKY_SHELL = createTag("rocky_shell");
	public static final TagKey<Item> SCULK_VINE = createTag("sculk_vines");
	public static final TagKey<Item> TARANTUAL_HAWK = createTag("tarantula_hawk_wing");
	public static final TagKey<Item> VOID_WORM = createTag("void_worm");
	public static final TagKey<Item> ROTTEN_FLESH = createTag("rotten_flesh");
	public static final TagKey<Item> ANDESITE_ALLOY = forgeTag("ingots/andesite_alloy");
	public static final TagKey<Item> CAST_IRON = forgeTag("ingots/cast_iron");
	public static final TagKey<Item> SOUL_STEEL = forgeTag("ingots/soul_steel");
	public static final TagKey<Item> SHARK_TOOTH = createTag("shark_tooth");
	public static final TagKey<Item> GAZELLE_HORN = createTag("gazelle_horn");
	public static final TagKey<Item> CROCODILE = createTag("crocodile_scute");
	public static final TagKey<Item> KOMODO_SPIT = createTag("komodo_spit");
	public static final TagKey<Item> MIMICREAM = createTag("mimicream");
	public static final TagKey<Item> CENTIPEDE = createTag("centipede_leg");
	public static final TagKey<Item> STRADDLITE = createTag("straddlite");
	public static final TagKey<Item> OOZE = createTag("ooze");
	public static final TagKey<Item> MAGE_FIBER = createTag("magebloom_fiber");
	public static final TagKey<Item> BLAZE_FIBER = createTag("blaze_fiber");
	public static final TagKey<Item> END_FIBER = createTag("end_fiber");
	public static final TagKey<Item> SCULK_BONE = createTag("sculk_bone");
	public static final TagKey<Item> SOUL_CRYSTAL = createTag("soul_crystal");
	public static final TagKey<Item> GOO = createTag("goo");
	public static final TagKey<Item> MOGMOSS = createTag("mogmoss");
	public static final TagKey<Item> DITCHBULB = createTag("ditchbulb");
	public static final TagKey<Item> BRUTE_TUSK = createTag("brute_tusk");
	
	private static TagKey<Item> createTag(String name) {
		return ItemTags.create(new ResourceLocation(SilentCompat.MODID, name));
	}
	
	private static TagKey<Item> forgeTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}
}

