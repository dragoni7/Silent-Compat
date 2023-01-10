package com.github.dragoni7.silentcompat.event;

import com.github.dragoni7.silentcompat.consts.ModEffectsLocs;
import com.github.dragoni7.silentcompat.consts.TraitConst;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatSoundEvents;
import com.github.dragoni7.silentcompat.networking.Networking;
import com.github.dragoni7.silentcompat.networking.PacketImmuneParticles;
import com.github.dragoni7.silentcompat.networking.PacketJoltChain;
import com.github.dragoni7.silentcompat.networking.PacketJoltParticles;
import com.github.dragoni7.silentcompat.trait.LuckyBreak;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.item.ICoreTool;
import net.silentchaos512.gear.util.GearHelper;
import net.silentchaos512.gear.util.TraitHelper;

@Mod.EventBusSubscriber
public class TraitEventHandler {

	private static final EquipmentSlot[] ARMOR_ONLY = { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
			EquipmentSlot.FEET };

	@SubscribeEvent
	public static void onPlayerHurt(LivingHurtEvent event) {
		LivingEntity attacked = event.getEntity();
		Entity attacker = event.getSource().getDirectEntity();

		if (attacked instanceof Player) {

			ServerPlayer serverPlayer = null;
			if (attacked instanceof ServerPlayer) {
				serverPlayer = (ServerPlayer) attacked;
			}

			if (attacker instanceof LivingEntity) {

				DamageSource source = event.getSource();
				RandomSource random = attacked.getRandom();

				int dodgeCount = 0;
				int dodgeLevel = 0;
				int emuDodgeCount = 0;
				int emuDodgeLevel = 0;
				int purifyingCount = 0;
				int purifyingLevel = 0;

				// Only check armor slots. Traits require full set
				for (EquipmentSlot slot : ARMOR_ONLY) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);
					// Emu dodge
					if (source.isProjectile()) {
						if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.EMU_DODGE.get())) {

							emuDodgeCount++;

							if (emuDodgeLevel < TraitHelper.getTraitLevel(stack, TraitConst.EMU_DODGE.get())) {
								emuDodgeLevel = TraitHelper.getTraitLevel(stack, TraitConst.EMU_DODGE.get());
							}
						}
					}
					// Dodging
					else if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.DODGING.get())
							&& !source.isBypassArmor()) {

						dodgeCount++;

						if (dodgeLevel < TraitHelper.getTraitLevel(stack, TraitConst.DODGING.get())) {
							dodgeLevel = TraitHelper.getTraitLevel(stack, TraitConst.DODGING.get());
						}
					}
					// Purifying
					else if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.PURIFYING.get())) {

						purifyingCount++;

						if (purifyingLevel < TraitHelper.getTraitLevel(stack, TraitConst.PURIFYING.get())) {
							purifyingLevel = TraitHelper.getTraitLevel(stack, TraitConst.PURIFYING.get());
						}
					}
				}

				if (dodgeCount == 4) {
					switch (dodgeLevel) {
					case 1: {
						if (random.nextFloat() < 0.15F) {
							immuneEffects(serverPlayer, attacker);
							event.setCanceled(true);
							break;
						}
					}
					case 2: {
						if (random.nextFloat() < 0.25F) {
							immuneEffects(serverPlayer, attacker);
							event.setCanceled(true);
							break;
						}
					}
					case 3: {
						if (random.nextFloat() < 0.35F) {
							immuneEffects(serverPlayer, attacker);
							event.setCanceled(true);
							break;
						}
					}
					default: {
						return;
					}
					}
				}

				if (emuDodgeCount == 4 && random.nextFloat() < 0.45F) {
					immuneEffects(serverPlayer, attacker);
					event.setCanceled(true);
				}

				if (purifyingCount == 4 && random.nextFloat() < 0.15F) {
					// remove all harmful effects from the entity
					for (MobEffectInstance effect : attacked.getActiveEffects()) {
						if (effect.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
							attacked.removeEffect(effect.getEffect());
						}
					}
				}

				for (EquipmentSlot slot : EquipmentSlot.values()) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);

					// Unstable Magic
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.UNSTABLE_MAGIC.get())) {
						if (random.nextFloat() < 0.45F) {
							int effect = random.nextIntBetweenInclusive(1, 5);
							MobEffect mobEffect = MobEffects.REGENERATION;
							switch (effect) {
							case 1: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.MANAREGEN);
								break;
							}
							case 2: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.SPELLDAMAGE);
								break;
							}
							case 3: {
								mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.RECOVERY);
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
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.LUCKY_BREAK.get())) {
						float luck = ((Player) attacked).getLuck();

						// luck based probability derived from MeetYourFight CocktailCutlass from
						// Lykrast.
						double effectChance = 0.1;

						if (luck >= 0) {
							effectChance = (2 + luck) / (20 + luck);
						} else {
							effectChance = 1 / (10 - luck);
						}

						if (attacked.getRandom().nextDouble() <= effectChance) {
							int i = attacked.getRandom().nextIntBetweenInclusive(0, LuckyBreak.EFFECTS.size() - 1);
							attacked.addEffect(new MobEffectInstance(LuckyBreak.EFFECTS.get(i), 100));
						}
					}

					// Retaliating Blast
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.RETAILIATING_BLAST.get())) {
						if (attacked.getRandom().nextIntBetweenInclusive(1, 4) % 4 == 0) {
							MobEffect blasting = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.BLASTING);
							if (!((LivingEntity) attacker).hasEffect(blasting)) {
								((LivingEntity) attacker).addEffect(new MobEffectInstance(blasting, 80));
							}
						}
					}

					// Fire React
					// Source: TwilightForest
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.FIRE_REACT.get())) {
						if (!attacker.fireImmune()) {
							attacker.setSecondsOnFire(1);
						}
					}

					// Cold
					// Source: TwilightForest
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.COLD.get())) {
						if (attacker.canFreeze()) {
							MobEffect frosted = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.FROSTED);
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
		if (!(attacker instanceof Player))
			return;

		Player player = (Player) attacker;
		ServerPlayer serverPlayer = null;

		if (player instanceof ServerPlayer) {
			serverPlayer = (ServerPlayer) player;
		}

		ItemStack weapon = player.getMainHandItem();

		if (!(weapon.getItem() instanceof ICoreTool))
			return;

		// Abyssal Synergy Trait
		double abyssalSynergy = TraitHelper.getTraitLevel(weapon, TraitConst.ABYSSAL_SYNERGY);
		double height = player.getY();

		if (abyssalSynergy > 0 && height < 0) {
			double depthDamage = ((abyssalSynergy / 10.0D) / 2.0D) * height;
			event.setAmount(Mth.abs((float) depthDamage) + event.getAmount());
		}

		// Knightly Trait
		double knightly = TraitHelper.getTraitLevel(weapon, TraitConst.KNIGHTLY);
		// Source: TwilightForest
		if (knightly > 0) {
			if (attacked.getArmorValue() > 0) {
				if (attacked.getArmorCoverPercentage() > 0) {
					int extraDamage = (int) (2 * attacked.getArmorCoverPercentage());
					event.setAmount(event.getAmount() + extraDamage);
				} else {
					event.setAmount(event.getAmount() + 2);
				}
			}
		}

		// Neptunes Might Trait
		double neptunesMight = TraitHelper.getTraitLevel(weapon, TraitConst.NEPTUNES_MIGHT);
		if (neptunesMight > 0) {
			if (player.isEyeInFluid(FluidTags.WATER)) {
				event.setAmount(event.getAmount() * 1.5F); // Source: TeamMetallurgy Aquaculture
			}
		}

		// Jolt Hit Trait
		double joltHit = TraitHelper.getTraitLevel(weapon, TraitConst.JOLT_HIT);
		if (joltHit > 0 && player.hasEffect(SilentCompatEffects.AMPLIFIED.get())) {

			Mob nearestEntity = attacked.level.getNearestEntity(Mob.class, TargetingConditions.forCombat(), attacked,
					attacked.getX(), attacked.getY(), attacked.getZ(),
					(new AABB(attacked.blockPosition())).inflate(10.0D, 10.0D, 10.0D));

			if (!player.level.isClientSide) {
				attacked.level.playSound(null, attacked.blockPosition(), SilentCompatSoundEvents.ELECTRIC_ZAP.get(), SoundSource.PLAYERS, 0.5f, 1.0f);

				if (serverPlayer != null) {
					Networking.sendToClient(new PacketJoltParticles(attacked.getId()), serverPlayer);
				}

				if (nearestEntity != null && serverPlayer != null) {
					Networking.sendToClient(new PacketJoltChain(attacked.position(), nearestEntity.position()),
							serverPlayer);
				}
			}
			
			event.setAmount((float) (event.getAmount() + (joltHit + 1)));

			if (nearestEntity != null) {
				nearestEntity.hurt(DamageSource.LIGHTNING_BOLT, (float) (joltHit + 2));
			}
			
			player.removeEffect(SilentCompatEffects.AMPLIFIED.get());
		}
	}

	@SubscribeEvent
	public static void onKillEntity(LivingDeathEvent event) {
		
		DamageSource source = event.getSource();
		Entity killer = source.getDirectEntity();
		
		if (killer instanceof Player) {
			Player player = (Player) killer;

			int amplifyingCount = 0;
			MobEffect amplified = SilentCompatEffects.AMPLIFIED.get();
			
			for (EquipmentSlot slot : ARMOR_ONLY) {
				ItemStack stack = player.getItemBySlot(slot);
				// Amplifying
				if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, TraitConst.AMPLIFYING.get())) {
					amplifyingCount++;
				}
			}
			
			// Requires full set
			if (amplifyingCount == 4 && !player.hasEffect(amplified)) {
				player.level.playSound(null, player.blockPosition(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS, 0.6f, 2.6f);
				player.addEffect(new MobEffectInstance(amplified, 120));
			}
		}
	}

	private static void immuneEffects(ServerPlayer player, Entity attacker) {

		if (player != null) {
			Networking.sendToClient(new PacketImmuneParticles(player.getId()), player);
		}

		attacker.level.playSound(null, player.blockPosition(), SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 0.4f, 1.5f);
	}

}
