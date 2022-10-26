package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.ModKeys;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class FeatherWeightTrait extends SimpleTrait {

	public static final Serializer<FeatherWeightTrait> SERIALIZER = new Serializer<FeatherWeightTrait>(new ResourceLocation(SilentCompat.MODID, "featherweight"), FeatherWeightTrait::new);
	private static MobEffect featherweight = null;
	
	public FeatherWeightTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public void onGearCrafted(TraitActionContext context) {
		featherweight = ForgeRegistries.MOB_EFFECTS.getValue(ModKeys.FEATHERWEIGHT);
    }
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (featherweight != null) {
			if (target.hasEffect(featherweight)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(featherweight, 60));
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Targets take additional knockback when hit");
        return ret;
    }
}
