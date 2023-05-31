package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddItemTags extends ItemTagsProvider {
	
	public AddItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, SilentCompat.MODID, helper);
	}

	@Override
	protected void addTags() {
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			addMaterialTags(set);
		}
		
		tag(Tags.Items.RAW_MATERIALS).add(SilentCompatItems.RAW_PLASTEEL.get()).add(SilentCompatItems.RAW_VOIDMETAL.get()).add(SilentCompatItems.RAW_SOLARMETAL.get()).add(SilentCompatItems.RAW_ARCMETAL.get());
		tag(SilentCompatTags.RAW_MATERIAL_PLASTEEL).add(SilentCompatItems.RAW_PLASTEEL.get());
		tag(SilentCompatTags.RAW_MATERIAL_ARCMETAL).add(SilentCompatItems.RAW_ARCMETAL.get());
		tag(SilentCompatTags.RAW_MATERIAL_SOLARMETAL).add(SilentCompatItems.RAW_SOLARMETAL.get());
		tag(SilentCompatTags.RAW_MATERIAL_VOIDMETAL).add(SilentCompatItems.RAW_VOIDMETAL.get());
		
		tag(Tags.Items.ORES).add(SilentCompatItems.ARCMETAL_ORE_ITEM.get()).add(SilentCompatItems.VOIDMETAL_ORE_ITEM.get()).add(SilentCompatItems.SOLARMETAL_ORE_ITEM.get()).add(SilentCompatItems.PLASTEEL_ORE_ITEM.get());
		tag(SilentCompatTags.ARCMETAL_ORES_ITEMS).add(SilentCompatItems.ARCMETAL_ORE_ITEM.get());
		tag(SilentCompatTags.VOIDMETAL_ORES_ITEMS).add(SilentCompatItems.VOIDMETAL_ORE_ITEM.get());
		tag(SilentCompatTags.SOLARMETAL_ORES_ITEMS).add(SilentCompatItems.SOLARMETAL_ORE_ITEM.get());
		tag(SilentCompatTags.PLASTEEL_ORES_ITEMS).add(SilentCompatItems.PLASTEEL_ORE_ITEM.get());
		
		tag(SilentCompatTags.OUTBACK_LEATHER).add(SilentCompatItems.OUTBACK_LEATHER.get());
		
		tag(SilentCompatTags.CRYSTALLINE_ALLOY).add(SilentCompatItems.CRYSTALLINE_ALLOY.get());
		
		tag(SilentCompatTags.ROTTEN_FLESH).add(Items.ROTTEN_FLESH);
		
		// Other mod's items:
		
		// Bumblezone
		tag(SilentCompatTags.BEE_STINGER).addOptional(new ResourceLocation("the_bumblezone:bee_stinger"));
		tag(SilentCompatTags.HONEY_CRYSTAL).addOptional(new ResourceLocation("the_bumblezone:honey_crystal_shards"));
		
		// Savage and Ravage
		tag(SilentCompatTags.BLAST_PROOF_PLATING).addOptional(new ResourceLocation("savage_and_ravage:blast_proof_plating"));
		
		// Twilight Forest
		tag(SilentCompatTags.ALPHA_YETI_FUR).addOptional(new ResourceLocation("twilightforest:alpha_yeti_fur"));
		tag(SilentCompatTags.NAGA_SCALE).addOptional(new ResourceLocation("twilightforest:naga_scale"));
		
		// Alexs Mobs
		tag(SilentCompatTags.SKREECHER_SOUL).addOptional(new ResourceLocation("alexsmobs:skreecher_soul"));
		tag(SilentCompatTags.CAPSID).addOptional(new ResourceLocation("alexsmobs:capsid"));
		tag(SilentCompatTags.ELASTIC_TENDON).addOptional(new ResourceLocation("alexsmobs:elastic_tendon"));
		tag(SilentCompatTags.EMU_FEATHER).addOptional(new ResourceLocation("alexsmobs:emu_feather"));
		tag(SilentCompatTags.FARSEER_ARM).addOptional(new ResourceLocation("alexsmobs:farseer_arm"));
		tag(SilentCompatTags.TENTACLE).addOptional(new ResourceLocation("alexsmobs:lost_tentacle"));
		tag(SilentCompatTags.ROADRUNNER).addOptional(new ResourceLocation("alexsmobs:roadrunner_feather"));
		tag(SilentCompatTags.ROCKY_SHELL).addOptional(new ResourceLocation("alexsmobs:rocky_shell"));
		tag(SilentCompatTags.TARANTUAL_HAWK).addOptional(new ResourceLocation("alexsmobs:tarantula_hawk_wing_fragment"));
		tag(SilentCompatTags.VOID_WORM).addOptional(new ResourceLocation("alexsmobs:void_worm_mandible"));
		tag(SilentCompatTags.SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:shark_tooth"));
		tag(SilentCompatTags.GAZELLE_HORN).addOptional(new ResourceLocation("alexsmobs:gazelle_horn"));
		tag(SilentCompatTags.CROCODILE).addOptional(new ResourceLocation("alexsmobs:crocodile_scute"));
		tag(SilentCompatTags.KOMODO_SPIT).addOptional(new ResourceLocation("alexsmobs:komodo_spit"));
		tag(SilentCompatTags.MIMICREAM).addOptional(new ResourceLocation("alexsmobs:mimicream"));
		tag(SilentCompatTags.CENTIPEDE).addOptional(new ResourceLocation("alexsmobs:centipede_leg"));
		tag(SilentCompatTags.STRADDLITE).addOptional(new ResourceLocation("alexsmobs:straddlite"));
		tag(SilentCompatTags.BEAR_HAIR).addOptional(new ResourceLocation("alexsmobs:bear_fur"));
		tag(SilentCompatTags.SERPENT_TOOTH).addOptional(new ResourceLocation("alexsmobs:bone_serpent_tooth"));
		tag(SilentCompatTags.BLOOD_SAC).addOptional(new ResourceLocation("alexsmobs:blood_sac"));
		tag(SilentCompatTags.HEMOLYMPH_SAC).addOptional(new ResourceLocation("alexsmobs:hemolymph_sac"));
		tag(SilentCompatTags.RACCOON_TAIL).addOptional(new ResourceLocation("alexsmobs:raccoon_tail"));
		tag(SilentCompatTags.ANTLER).addOptional(new ResourceLocation("alexsmobs:moose_antler"));
		tag(SilentCompatTags.SPIKED_SCUTE).addOptional(new ResourceLocation("alexsmobs:spiked_scute"));
		tag(SilentCompatTags.COCKROACH_WING).addOptional(new ResourceLocation("alexsmobs:cockroach_wing"));
		tag(SilentCompatTags.DROPBEAR_CLAW).addOptional(new ResourceLocation("alexsmobs:dropbear_claw"));
		tag(SilentCompatTags.WHALE_TOOTH).addOptional(new ResourceLocation("alexsmobs:cachalot_whale_tooth"));
		tag(SilentCompatTags.SERRATED_SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:serrated_shark_tooth"));
		tag(SilentCompatTags.FROSTSTALKER_HORN).addOptional(new ResourceLocation("alexsmobs:froststalker_horn"));
		tag(SilentCompatTags.BISON_FUR).addOptional(new ResourceLocation("alexsmobs:bison_fur_block"));
		tag(SilentCompatTags.KANGAROO_HIDE).addOptional(new ResourceLocation("alexsmobs:kangaroo_hide"));
		tag(SilentCompatTags.FISH_BONES).addOptional(new ResourceLocation("alexsmobs:fish_bones"));
		
		// Majr Progressive Difficulty
		tag(SilentCompatTags.CLOTH).addOptional(new ResourceLocation("majruszsdifficulty:cloth"));
		
		// BYG
		tag(SilentCompatTags.CRYPTIC_END_ROD).addOptional(new ResourceLocation("byg:cryptic_end_rod"));
		
		// Quark
		tag(SilentCompatTags.DRAGON_SCALE).addOptional(new ResourceLocation("quark:dragon_scale"));
		
		// Meet your Fight
		tag(SilentCompatTags.FORTUNES_FAVOR).addOptional(new ResourceLocation("meetyourfight:fortunes_favor"));
		tag(SilentCompatTags.MOSSY_TOOTH).addOptional(new ResourceLocation("meetyourfight:mossy_tooth"));
		tag(SilentCompatTags.PHANTOPLASM).addOptional(new ResourceLocation("meetyourfight:phantoplasm"));
		
		// Undergarden
		tag(SilentCompatTags.MASTICATOR_SCALE).addOptional(new ResourceLocation("undergarden:masticator_scales"));
		tag(SilentCompatTags.GOO).addOptional(new ResourceLocation("undergarden:goo_block"));
		tag(SilentCompatTags.MOGMOSS).addOptional(new ResourceLocation("undergarden:mogmoss"));
		tag(SilentCompatTags.DITCHBULB).addOptional(new ResourceLocation("undergarden:ditchbulb_paste"));
		tag(SilentCompatTags.BRUTE_TUSK).addOptional(new ResourceLocation("undergarden:brute_tusk"));
		
		// Create
		tag(SilentCompatTags.ANDESITE_ALLOY).addOptional(new ResourceLocation("create:andesite_alloy"));
		
		// Create Deco
		tag(SilentCompatTags.CAST_IRON).addOptional(new ResourceLocation("createdeco:cast_iron_ingot"));
		
		// Spirit
		tag(SilentCompatTags.SOUL_STEEL).addOptional(new ResourceLocation("spirit:soul_steel_ingot"));
		
		// Dreamland
		tag(SilentCompatTags.OOZE).addOptional(new ResourceLocation("dreamland:ooze_block"));
		
		// Ars Nouveau
		tag(SilentCompatTags.MAGE_FIBER).addOptional(new ResourceLocation("ars_nouveau:magebloom_fiber"));
		tag(SilentCompatTags.BLAZE_FIBER).addOptional(new ResourceLocation("ars_nouveau:blaze_fiber"));
		tag(SilentCompatTags.END_FIBER).addOptional(new ResourceLocation("ars_nouveau:end_fiber"));
		tag(SilentCompatTags.ABJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:abjuration_essence"));
		tag(SilentCompatTags.CONJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:conjuration_essence"));
		tag(SilentCompatTags.EARTH_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:earth_essence"));
		
		// Deeper Darker
		tag(SilentCompatTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_vines"));
		tag(SilentCompatTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_tendrils"));
		tag(SilentCompatTags.SCULK_BONE).addOptional(new ResourceLocation("deeperdarker:sculk_bone"));
		tag(SilentCompatTags.SOUL_CRYSTAL).addOptional(new ResourceLocation("deeperdarker:soul_crystal"));
		
		// End's Phantasm
		tag(SilentCompatTags.STELLIUM).addOptional(new ResourceLocation("phantasm:stellium_ingot"));
		tag(SilentCompatTags.VOID_SHARD).addOptional(new ResourceLocation("phantasm:void_crystal_spike_tip"));
		tag(SilentCompatTags.CRYSTAL_SHARD).addOptional(new ResourceLocation("phantasm:crystal_spike_tip"));
		
		// Infernal Expansion
		tag(SilentCompatTags.GLOW_SILK).addOptional(new ResourceLocation("infernalexp:glow_silk"));
		
		// Galosphere
		tag(SilentCompatTags.ALLURITE).addOptional(new ResourceLocation("galosphere:allurite_shard"));
		tag(SilentCompatTags.LUMIERE).addOptional(new ResourceLocation("galosphere:lumiere_shard"));
		
		// Creatures and Beasts
		tag(SilentCompatTags.CINDERSHELL_SHARD).addOptional(new ResourceLocation("cnb:cindershell_shell_shard"));
		tag(SilentCompatTags.YETI_HIDE).addOptional(new ResourceLocation("cnb:yeti_hide"));
		
		// Biome Makeover
		tag(SilentCompatTags.CRUDE_CLADDING).addOptional(new ResourceLocation("biomemakeover:crude_cladding"));
		
		// Cataclysm
		tag(SilentCompatTags.IGNITIUM).addOptional(new ResourceLocation("cataclysm:ignitium_ingot"));
		
		// Mystical Agriculture
		tag(SilentCompatTags.PROSPERITY_SHARD).addOptional(new ResourceLocation("mysticalagriculture:prosperity_shard"));
		
		// Biomancy
		tag(SilentCompatTags.EXOTIC_FLESH).addOptional(new ResourceLocation("biomancy:creator_mix"));
		tag(SilentCompatTags.UNSTABLE_COMPOUND).addOptional(new ResourceLocation("biomancy:unstable_compound"));
		tag(SilentCompatTags.CORROSIVE_ADDITIVE).addOptional(new ResourceLocation("biomancy:corrosive_additive"));
	}
	
	private void addMaterialTags(MaterialSet set) {
		tag(Tags.Items.INGOTS).add(set.ingot.get());
		tag(Tags.Items.NUGGETS).add(set.nugget.get());
		tag(Tags.Items.STORAGE_BLOCKS).add(set.blockItem.get());
		
		tag(set.ingotTag).add(set.ingot.get());
		tag(set.nuggetTag).add(set.nugget.get());
		tag(set.blockItemTag).add(set.blockItem.get());
	}
}

