package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.ModEffectsLocs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class GooeyTrait extends SimpleTrait {
	public static final Serializer<GooeyTrait> SERIALIZER = new Serializer<GooeyTrait>(new ResourceLocation(SilentCompat.MODID, "gooey"), GooeyTrait::new);
	private static MobEffect gooey = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.GOOEY);
	
	public GooeyTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (context.getPlayer().getRandom().nextIntBetweenInclusive(1, 4) % 4 == 0) {
			if (gooey != null) {
				if (!target.hasEffect(gooey)) {
					target.forceAddEffect(new MobEffectInstance(gooey, 40), target);
				}
			}
			else {
				gooey = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.GOOEY);
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Attacks have a chance to apply scintling goo under the target's feet");
        return ret;
    }
}
