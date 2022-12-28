package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class NeptunesMightTrait extends SimpleTrait {
	public static final Serializer<NeptunesMightTrait> SERIALIZER = new Serializer<NeptunesMightTrait>(new ResourceLocation(SilentCompat.MODID, "neptunes_might"), NeptunesMightTrait::new);

	public NeptunesMightTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Does more damage targets while in water");
        return ret;
    }
}
