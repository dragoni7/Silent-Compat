package com.github.dragoni7.silentcompat.core;

import java.util.ArrayList;
import java.util.Arrays;

import com.github.dragoni7.silentcompat.core.TraitConst.ModTraits;
import com.github.dragoni7.silentcompat.trait.LuckyBreak;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
	
	private static final ArrayList<EquipmentSlot> ARMOR_ONLY = new ArrayList<EquipmentSlot>(Arrays.asList(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET));
	
	@SubscribeEvent
	public static void onPlayerHurt(LivingHurtEvent event) {
		LivingEntity attacked = event.getEntity();
		Entity attacker = event.getSource().getDirectEntity();
		
		if (attacked instanceof Player) {
			if (attacker instanceof LivingEntity) {
				
				DamageSource source = event.getSource();
				RandomSource random = attacked.getRandom();
				
				int dodgeCount = 0;
				int dodgeLevel = 0;
				int emuDodgeCount = 0;
				int emuDodgeLevel = 0;
				
				// Only check armor slots. Traits require full set
				for (EquipmentSlot slot : ARMOR_ONLY) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);
					
					// Emu dodge
					if (source.isProjectile()) {
						if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.EMU_DODGE.get())) {
							
							emuDodgeCount++;
							
							if (emuDodgeLevel < TraitHelper.getTraitLevel(stack, ModTraits.EMU_DODGE.get())) {
								emuDodgeLevel = TraitHelper.getTraitLevel(stack, ModTraits.EMU_DODGE.get());
							}
						}
					}
					// Dodging
					else if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.DODGING.get()) && source == DamageSource.GENERIC) {
						
						dodgeCount++;
						
						if (dodgeLevel < TraitHelper.getTraitLevel(stack, ModTraits.DODGING.get())) {
							dodgeLevel = TraitHelper.getTraitLevel(stack, ModTraits.DODGING.get());
						}
					}
				}
				
				if (dodgeCount == 4) {
					switch(dodgeLevel) {
					case 1: {
						if (random.nextFloat() < 0.15F) {
							event.setCanceled(true);
							break;
						}
					}
					case 2: {
						if (random.nextFloat() < 0.25F) {
							event.setCanceled(true);
							break;
						}
					}
					case 3: {
						if (random.nextFloat() < 0.35F) {
							event.setCanceled(true);
							break;
						}
					}
					default: {
							return;
						}
					}
				}
				
				if (emuDodgeCount == 4) {
					if (random.nextFloat() < 0.45F) {
						event.setCanceled(true);
					}
				}
				
				for (EquipmentSlot slot: EquipmentSlot.values()) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);
					
					// Unstable Magic
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.UNSTABLE_MAGIC.get())) {
						if (random.nextFloat() < 0.45F) {
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
								attacked.forceAddEffect(new MobEffectInstance(mobEffect, 40), attacked);
							}
						}
					}
					
					// Lucky Break
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.LUCKY_BREAK.get())) {
						float luck = ((Player) attacked).getLuck();
						
						// luck based probability derived from MeetYourFight CocktailCutlass from Lykrast.
						double effectChance = 0.1;
						
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
					
					// Fire React
					// Source: TwilightForest
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.FIRE_REACT.get())) {
						if (!attacker.fireImmune()) {
							attacker.setSecondsOnFire(1);
						}
					}
					
					// Cold
					// Source: TwilightForest
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.COLD.get())) {
						if (attacker.canFreeze()) {
							MobEffect frosted = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.FROSTED);
							if (!((LivingEntity) attacker).hasEffect(frosted)) {
								((LivingEntity) attacker).addEffect(new MobEffectInstance(frosted, 20));
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
		
		// Abyssal Synergy Trait
		double abyssalSynergy = TraitHelper.getTraitLevel(weapon, TraitConst.ModTraits.ABYSSAL_SYNERGY);
		double height = attacker.getY();

		if (abyssalSynergy > 0 && height < 0) {
			double depthDamage = ((abyssalSynergy / 10.0D) / 2.0D) * height;
			event.setAmount(Mth.abs((float) depthDamage) + event.getAmount());
		}
		
		// Knightly Trait
		double knightly = TraitHelper.getTraitLevel(weapon, TraitConst.ModTraits.KNIGHTLY);
		// Source: TwilightForest
		if (knightly > 0) {
			if (attacked.getArmorValue() > 0) {
				if (attacked.getArmorCoverPercentage() > 0) {
					int extraDamage = (int) (2 * attacked.getArmorCoverPercentage());
					event.setAmount(event.getAmount() + extraDamage);
				}
				else {
					event.setAmount(event.getAmount() + 2);
				}
			}
		}
		
		// Neptunes Might Trait
		double neptunesMight = TraitHelper.getTraitLevel(weapon, TraitConst.ModTraits.NEPTUNES_MIGHT);
		if (neptunesMight > 0) {
			if (attacker.isEyeInFluid(FluidTags.WATER)) {
				event.setAmount(event.getAmount() * 1.5F); // Source: TeamMetallurgy Aquaculture
			}
		}
	}

}
