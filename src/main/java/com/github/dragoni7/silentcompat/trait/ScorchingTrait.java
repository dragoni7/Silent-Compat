package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class ScorchingTrait extends SimpleTrait {
	
	public static final Serializer<ScorchingTrait> SERIALIZER = new Serializer<ScorchingTrait>(new ResourceLocation(SilentCompat.MODID, "scorching"), ScorchingTrait::new);

	public ScorchingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {

		Player player = context.getPlayer();

		if (player.hasEffect(SilentCompatEffects.RESTORATION.get())) {

			// get trait level.
			int scorching = context.getTraitLevel();
			
			if (!target.fireImmune() && !target.hasEffect(SilentCompatEffects.SCORCH.get())) {
				target.addEffect(new MobEffectInstance(SilentCompatEffects.SCORCH.get(), 140, scorching));
				player.removeEffect(SilentCompatEffects.RESTORATION.get());
			}
		}

		return baseValue;
	}

	@Override
	public Collection<String> getExtraWikiLines() {
		Collection<String> ret = super.getExtraWikiLines();
		ret.add("Consumes restoration, applying the scorch effect to the target hit.");
		return ret;
	}

}
