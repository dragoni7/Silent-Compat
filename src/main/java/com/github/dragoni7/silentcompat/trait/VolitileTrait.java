package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class VolitileTrait extends SimpleTrait {
	
	public static final Serializer<VolitileTrait> SERIALIZER = new Serializer<VolitileTrait>(new ResourceLocation(SilentCompat.MODID, "volitile"), VolitileTrait::new);

	public VolitileTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
    	
    	Player player = context.getPlayer();
    	
        if (player.hasEffect(SilentCompatEffects.DEVOURING.get())) {
        	
        	MobEffect volitileEffect = SilentCompatEffects.VOLITILE.get();
        	
        	if (!target.hasEffect(volitileEffect)) {
        		
            	// get trait level.
            	int level = context.getTraitLevel();
            	
        		target.addEffect(new MobEffectInstance(volitileEffect, 140, level));
        		
        		// consume devouring
        		player.removeEffect(SilentCompatEffects.DEVOURING.get());
        	}
        }
        
        return baseValue;
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Consumes devouring, applying the volitile effect on the target.");
        return ret;
    }

}
