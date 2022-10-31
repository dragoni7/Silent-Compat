package com.github.dragoni7.core;

import com.github.dragoni7.core.TraitConst.ModTraits;
import com.github.dragoni7.traits.LuckyBreak;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.item.ICoreTool;
import net.silentchaos512.gear.util.GearHelper;
import net.silentchaos512.gear.util.TraitHelper;

@Mod.EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
	public static void onPlayerHurt(LivingHurtEvent event) {
		LivingEntity attacked = event.getEntity();
		Entity attacker = event.getSource().getDirectEntity();
		
		if (attacked instanceof Player) {
			if (attacker instanceof LivingEntity) {
				for (EquipmentSlot slot: EquipmentSlot.values()) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);
					
					// dodging trait
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.DODGING.get())) {
						int level = TraitHelper.getTraitLevel(stack, ModTraits.DODGING.get());
							switch(level) {
							case 1: {
								if (attacked.getLevel().getRandom().nextInt(20) % 20 == 0) {
									event.setCanceled(true);
									attacked.playSound(SoundEvents.RABBIT_AMBIENT);
								}
							}
							case 2: {
								if (attacked.getLevel().getRandom().nextInt(15) % 15 == 0) {
									event.setCanceled(true);
									attacked.playSound(SoundEvents.RABBIT_AMBIENT);
								}
							}
							case 3: {
								if (attacked.getLevel().getRandom().nextInt(10) % 10 == 0) {
									event.setCanceled(true);
									attacked.playSound(SoundEvents.RABBIT_AMBIENT);
								}
							}
							default: {
							return;
							}
						}
					}
					
					// Mana Regen
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.MANA_REGEN.get())) {
						if (attacked.getRandom().nextIntBetweenInclusive(1, 3) % 3 == 0) {
							MobEffect mana_regen = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.MANAREGEN);
							if (!attacked.hasEffect(mana_regen)) {
								attacked.forceAddEffect(new MobEffectInstance(mana_regen, 80), attacked);
							}
						}
					}
					
					// Unstable Magic
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.UNSTABLE_MAGIC.get())) {
						RandomSource random = attacked.getRandom();
						if (random.nextIntBetweenInclusive(1, 4) % 4 == 0) {
							int effect = random.nextIntBetweenInclusive(1, 5);
							MobEffect mobEffect = MobEffects.REGENERATION;
							switch (effect) {
							case 1: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.MANAREGEN);
								break;
							}
							case 2: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.SPELLDAMAGE);
								break;
							}
							case 3: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.RECOVERY);
								break;
							}
							case 4: {
								mobEffect = MobEffects.MOVEMENT_SPEED;
								break;
							}
							case 5: {
								mobEffect = MobEffects.DAMAGE_RESISTANCE;
								break;
							}
							}
							
							if (!attacked.hasEffect(mobEffect)) {
								attacked.forceAddEffect(new MobEffectInstance(mobEffect, 80), attacked);
							}
						}
					}
					
					// Lucky Break
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.LUCKY_BREAK.get())) {
						float luck = ((Player) attacked).getLuck();
						
						// luck based probability derived from MeetYourFight CocktailCutlass from Lykrast.
						double effectChance = 1/10;
						
						if (luck >= 0) {
							effectChance = (2 + luck) / (20 + luck);
						}
						else {
							effectChance = 1/(10 - luck);
						}
						
						if (attacked.getRandom().nextDouble() <= effectChance) {
							int i = attacked.getRandom().nextIntBetweenInclusive(0, LuckyBreak.EFFECTS.size() - 1);
							attacked.addEffect(new MobEffectInstance(LuckyBreak.EFFECTS.get(i), 100));
						}
					}
					
					// Retaliating Blast
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.RETAILIATING_BLAST.get())) {
						if (attacked.getRandom().nextIntBetweenInclusive(1, 4) % 4 == 0) {
							MobEffect blasting = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.BLASTING);
							if (!((LivingEntity) attacker).hasEffect(blasting)) {
								((LivingEntity) attacker).addEffect(new MobEffectInstance(blasting, 80));
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void onAttackEntity(LivingHurtEvent event) {
		LivingEntity attacked = event.getEntity();
		DamageSource source = event.getSource();
		
		if (source == null || !"player".equals(source.msgId))
			return;
		
		Entity attacker = source.getEntity();
		if(!(attacker instanceof Player))
			return;
		
		Player player = (Player) attacker;
		ItemStack weapon = player.getMainHandItem();
		
		if (!(weapon.getItem() instanceof ICoreTool))
			return;
		
		// abyssal synergy trait
		double traitLevel = TraitHelper.getTraitLevel(weapon, TraitConst.ModTraits.ABYSSAL_SYNERGY);
		double height = attacker.getY();

		if (height < 0) {
			double depthDamage = ((traitLevel / 10.0D) / 2.0D) * height;
			event.setAmount(Mth.abs((float) depthDamage) + event.getAmount());
		}
	}

}
