package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.EffectResourceLocs;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class UnstableMagicTrait extends SimpleTrait {
	public static final Serializer<UnstableMagicTrait> SERIALIZER = new Serializer<UnstableMagicTrait>(new ResourceLocation(SilentCompat.MODID, "unstable_magic"), UnstableMagicTrait::new);

		public UnstableMagicTrait(ResourceLocation id) {
			super(id, SERIALIZER);
		}
		
		@Override
		public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
			Player player = context.getPlayer();
			RandomSource random = player.getRandom();
			int effect = random.nextIntBetweenInclusive(1, 4);
			
			if (random.nextIntBetweenInclusive(1, 5) % 5 == 0) {
				MobEffect mobEffect = MobEffects.POISON;
				
				switch(effect) {
				case 1: {
					mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.FREEZING);
					break;
				}
				case 2: {
					mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.BLASTING);
					break;
				}
				case 3: {
					mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.SNARED);
					break;
				}
				case 4: {
					mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.GRAVITY);
					break;
				}
				default: {
					mobEffect = MobEffects.POISON;
					break;
				}
				}
				
				if (!target.hasEffect(mobEffect)) {
					target.forceAddEffect(new MobEffectInstance(mobEffect, 60), target);
				}
			}
			
			return super.onAttackEntity(context, target, baseValue);
		}
		
		@Override
	    public Collection<String> getExtraWikiLines() {
	        Collection<String> ret = super.getExtraWikiLines();
	        ret.add("Chance to gain random positive magic effect or apply random negative magic effect to targets");
	        return ret;
	    }

}
