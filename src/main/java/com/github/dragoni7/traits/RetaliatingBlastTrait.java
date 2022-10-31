package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.EffectResourceLocs;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class RetaliatingBlastTrait extends SimpleTrait {
	public static final Serializer<RetaliatingBlastTrait> SERIALIZER = new Serializer<RetaliatingBlastTrait>(new ResourceLocation(SilentCompat.MODID, "retaliating_blast"), RetaliatingBlastTrait::new);
	private static MobEffect blasting = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.BLASTING);
	
	public RetaliatingBlastTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (context.getPlayer().getRandom().nextIntBetweenInclusive(1, 6) % 6 == 0) {
			if (blasting != null) {
				if (!target.hasEffect(blasting)) {
					target.addEffect(new MobEffectInstance(blasting, 80));
				}
			}
			else {
				blasting = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.BLASTING);
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Attacks have a chance to apply a delayed explosion on the target");
        return ret;
    }
}
