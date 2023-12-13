package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatSoundEvents;
import com.github.dragoni7.silentcompat.networking.Networking;
import com.github.dragoni7.silentcompat.networking.PacketJoltChain;
import com.github.dragoni7.silentcompat.networking.PacketJoltParticles;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class JoltHitTrait extends SimpleTrait {
	
	public static final Serializer<JoltHitTrait> SERIALIZER = new Serializer<JoltHitTrait>(new ResourceLocation(SilentCompat.MODID, "jolt_hit"), JoltHitTrait::new);
	
	public JoltHitTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
    @Override
    public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
    	
    	Player player = context.getPlayer();
    	
        if (player.hasEffect(SilentCompatEffects.AMPLIFIED.get())) {
        	
        	// get trait level.
        	int joltHit = context.getTraitLevel();
        	
        	// get nearest target to target for jolt chain.
        	Mob nearestEntity = target.level().getNearestEntity(Mob.class, TargetingConditions.forCombat(), target,
        			target.getX(), target.getY(), target.getZ(),
					(new AABB(target.blockPosition())).inflate(10.0D, 10.0D, 10.0D));
        	
        	if (!player.level().isClientSide) {
        		target.level().playSound(null, target.blockPosition(), SilentCompatSoundEvents.ELECTRIC_ZAP.get(), SoundSource.PLAYERS, 0.5f, 1.0f);

				if (player instanceof ServerPlayer) {
					Networking.sendToClient(new PacketJoltParticles(target.getId()), (ServerPlayer) player);
					
					if (nearestEntity != null) {
						Networking.sendToClient(new PacketJoltChain(target.position(), nearestEntity.position()), (ServerPlayer) player);
					}
				}
			}

			if (nearestEntity != null) {
				nearestEntity.hurt(nearestEntity.damageSources().lightningBolt(), joltHit + (baseValue / 2f));
			}
			
			player.removeEffect(SilentCompatEffects.AMPLIFIED.get());
			
			
			// bonus damage: base + trait level + (base damage / 4).
			return (baseValue + joltHit + (baseValue / 4f));
        }
        
        return baseValue;
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Consumes amplified, dealing bonus damage and chaining to a nearby entity.");
        return ret;
    }
}
