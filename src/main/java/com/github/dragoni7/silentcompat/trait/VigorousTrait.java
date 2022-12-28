package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class VigorousTrait extends SimpleTrait {

	public static final Serializer<VigorousTrait> SERIALIZER = new Serializer<VigorousTrait>(new ResourceLocation(SilentCompat.MODID, "vigorous"), VigorousTrait::new);
	public VigorousTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (context.getPlayer().getHealth() >= context.getPlayer().getMaxHealth()) {
			// 10% more damage at full HP
			return super.onAttackEntity(context, target, baseValue + (baseValue * 0.10F));
		}
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Deal more damage while at full health");
        return ret;
    }
}
