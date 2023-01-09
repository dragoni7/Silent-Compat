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

public class EnderFluTrait extends SimpleTrait {
	
	public static final Serializer<EnderFluTrait> SERIALIZER = new Serializer<EnderFluTrait>(new ResourceLocation(SilentCompat.MODID, "enderflu"), EnderFluTrait::new);
	private static MobEffect ender_flu = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.ENDER_FLU);
	
	public EnderFluTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (ender_flu != null) {
			if (target.hasEffect(ender_flu)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(ender_flu, 180));
			}
		}
		else {
			ender_flu = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.ENDER_FLU);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Infects the target with Ender Flu");
        return ret;
    }
}
