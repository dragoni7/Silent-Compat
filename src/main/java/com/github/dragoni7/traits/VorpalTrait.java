package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class VorpalTrait extends SimpleTrait {
public static final Serializer<VorpalTrait> SERIALIZER = new Serializer<VorpalTrait>(new ResourceLocation(SilentCompat.MODID, "vorpal"), VorpalTrait::new);
	
	public VorpalTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (target.getHealth() > 200) {
			// 10% more base damage on entities
			return baseValue + (baseValue * 0.10F);
		}
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Deal more damage to targets with over 200 hearts");
        return ret;
    }

}
