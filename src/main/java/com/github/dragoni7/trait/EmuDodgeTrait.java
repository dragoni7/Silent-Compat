package com.github.dragoni7.trait;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class EmuDodgeTrait extends SimpleTrait {
	public static final Serializer<EmuDodgeTrait> SERIALIZER = new Serializer<EmuDodgeTrait>(new ResourceLocation(SilentCompat.MODID, "emu_dodge"), EmuDodgeTrait::new);

	public EmuDodgeTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Grants a chance to avoid projectile damage. Requires full set");
        return ret;
    }
}
