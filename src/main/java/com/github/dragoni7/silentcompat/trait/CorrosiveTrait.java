package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModEffectsLocs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class CorrosiveTrait extends SimpleTrait {
	
	public static final Serializer<CorrosiveTrait> SERIALIZER = new Serializer<CorrosiveTrait>(new ResourceLocation(SilentCompat.MODID, "corrosive"), CorrosiveTrait::new);
	private static MobEffect corrosive = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.CORROSIVE);
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (corrosive != null) {
			if (target.hasEffect(corrosive)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(corrosive, 40));
			}
		}
		else {
			corrosive = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.CORROSIVE);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Briefly applies Corrosion to targets");
        return ret;
    }
	
	public CorrosiveTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
}
