package com.github.dragoni7.core;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.api.traits.ITrait;
import net.silentchaos512.gear.util.DataResource;

public class TraitConst {

	public static final class ModTraits {
		public static final DataResource<ITrait> DODGING = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "dodging"));
		public static final DataResource<ITrait> ABYSSAL_SYNERGY = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "abyssal_synergy"));
		public static final DataResource<ITrait> UNSTABLE_MAGIC = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "unstable_magic"));
		public static final DataResource<ITrait> LUCKY_BREAK = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "lucky_break"));
		public static final DataResource<ITrait> RETAILIATING_BLAST = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "retaliating_blast"));
		public static final DataResource<ITrait> KNIGHTLY = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "knightly"));
		public static final DataResource<ITrait> FIRE_REACT = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "fire_react"));
		public static final DataResource<ITrait> NEPTUNES_MIGHT = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "neptunes_might"));
		public static final DataResource<ITrait> COLD = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "cold"));
		public static final DataResource<ITrait> EMU_DODGE = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "emu_dodge"));
	}
}
