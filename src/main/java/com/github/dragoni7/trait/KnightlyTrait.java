package com.github.dragoni7.trait;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class KnightlyTrait extends SimpleTrait {
	
	public static final Serializer<KnightlyTrait> SERIALIZER = new Serializer<KnightlyTrait>(new ResourceLocation(SilentCompat.MODID, "knightly"), KnightlyTrait::new);

	public KnightlyTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Does more damage to armored targets");
        return ret;
    }
}
