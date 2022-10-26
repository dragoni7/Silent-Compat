package com.github.dragoni7.core;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.api.traits.ITrait;
import net.silentchaos512.gear.util.DataResource;

public class TraitConst {

	public static final class ModTraits {
		public static final DataResource<ITrait> DODGING = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "dodging"));
		public static final DataResource<ITrait> SCULK_AFFINITY = DataResource.trait(new ResourceLocation(SilentCompat.MODID, "sculk_affinity"));
	}
}
