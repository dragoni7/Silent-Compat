package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class NocturnalTrait extends SimpleTrait {
	
	public static final Serializer<NocturnalTrait> SERIALIZER = new Serializer<NocturnalTrait>(new ResourceLocation(SilentCompat.MODID, "nocturnal"), NocturnalTrait::new);

	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		Level world = context.getPlayer().getLevel();
		
		long time = world.getDayTime() % 24000;
		if (time > 13000) {
			// 15% more base damage during night
			return baseValue + (baseValue * 0.15F);
		}
		
		return baseValue;
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Deal increased damage at nighttime.");
        return ret;
    }
	
	public NocturnalTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

}
