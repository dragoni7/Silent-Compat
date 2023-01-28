package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class RestorationTrait extends SimpleTrait {
	
	public static final Serializer<RestorationTrait> SERIALIZER = new Serializer<RestorationTrait>(new ResourceLocation(SilentCompat.MODID, "restoration"), RestorationTrait::new);

	public RestorationTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Getting a kill has a chance to grant the restoration effect. Requires full set");
        return ret;
    }

}
