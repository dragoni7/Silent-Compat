package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class EnderFluTrait extends SimpleTrait {
	
	public static final Serializer<EnderFluTrait> SERIALIZER = new Serializer<EnderFluTrait>(new ResourceLocation(SilentCompat.MODID, "enderflu"), EnderFluTrait::new);
	private static final MobEffect ENDER_FLU = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("alexsmobs", "ender_flu"));
	
	public EnderFluTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (ENDER_FLU != null) {
			if (target.hasEffect(ENDER_FLU)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(ENDER_FLU, 180));
			}
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
