package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class DodgingTrait extends SimpleTrait {
	
	public static final Serializer<DodgingTrait> SERIALIZER = new Serializer<DodgingTrait>(new ResourceLocation(SilentCompat.MODID, "dodging"), DodgingTrait::new);

	public DodgingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Grants a chance to avoid damage");
        return ret;
    }
}
