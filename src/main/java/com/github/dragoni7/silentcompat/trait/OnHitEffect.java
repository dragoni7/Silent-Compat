package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class OnHitEffect extends SimpleTrait {
	
	public static final Serializer<OnHitEffect> SERIALIZER = new Serializer<OnHitEffect>(SilentCompat.getId("on_hit_effect"),
			OnHitEffect::new,
			OnHitEffect::readJson,
			OnHitEffect::read,
			OnHitEffect::write);
	
	private MobEffect effect;
	private int duration;
	private int chance;

	public OnHitEffect(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (effect != null && target.getRandom().nextInt(chance) % chance == 0) {
			
			if (target.hasEffect(effect)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(effect, duration, context.getTraitLevel() - 1));
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
    private static void readJson(OnHitEffect trait, JsonObject json) {
    	
        MobEffect mob_effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(GsonHelper.getAsString(json, "effect")));
        
        if (mob_effect != null) {
        	trait.effect = mob_effect;
        }
        
        trait.duration = GsonHelper.getAsInt(json, "duration", 0);
        trait.chance = GsonHelper.getAsInt(json, "chance", 0);
    }
    
    private static void read(OnHitEffect trait, FriendlyByteBuf buffer) {
    	
    	MobEffect mob_effect = ForgeRegistries.MOB_EFFECTS.getValue(buffer.readResourceLocation());
    	
        if (mob_effect == null) {
        	mob_effect = MobEffects.MOVEMENT_SLOWDOWN;
        }
        
        trait.effect = mob_effect;
    	
        trait.duration = buffer.readVarInt();
    	trait.chance = buffer.readVarInt();
    }
    
    private static void write(OnHitEffect trait, FriendlyByteBuf buffer) {
    	
    	buffer.writeResourceLocation(fromEffect(trait.effect));
    	buffer.writeVarInt(trait.duration);
    	buffer.writeVarInt(trait.chance);
    }
    
    private static ResourceLocation fromEffect(MobEffect effect) {
    	ResourceLocation key = ForgeRegistries.MOB_EFFECTS.getKey(effect);
    	return key != null ? key : ForgeRegistries.MOB_EFFECTS.getKey(MobEffects.MOVEMENT_SLOWDOWN); // fall back
    }
    
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        
        if (effect != null) {
        	ret.add(chance + "% chance to apply effect on hit.");
        }
        
        return ret;
    }

}
