package com.github.dragoni7.core;

import com.github.dragoni7.core.TraitConst.ModTraits;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silentchaos512.gear.util.GearHelper;
import net.silentchaos512.gear.util.TraitHelper;

@Mod.EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
	public static void onPlayerHurt(LivingHurtEvent event) {
		Entity target = event.getEntity();
		if (target instanceof Player) {
			if (event.getSource().getDirectEntity() instanceof LivingEntity) {
				for (EquipmentSlot slot: EquipmentSlot.values()) {
					ItemStack stack = event.getEntity().getItemBySlot(slot);
					if (GearHelper.isGear(stack) && TraitHelper.hasTrait(stack, ModTraits.DODGING.get())) {
						int level = TraitHelper.getTraitLevel(stack, ModTraits.DODGING.get());
						switch(level) {
						case 1: {
							if (target.getLevel().getRandom().nextInt(20) % 20 == 0) {
								event.setCanceled(true);
								target.playSound(SoundEvents.RABBIT_AMBIENT);
							}
						}
						case 2: {
							if (target.getLevel().getRandom().nextInt(15) % 15 == 0) {
								event.setCanceled(true);
								target.playSound(SoundEvents.RABBIT_AMBIENT);
							}
						}
						case 3: {
							if (target.getLevel().getRandom().nextInt(10) % 10 == 0) {
								event.setCanceled(true);
								target.playSound(SoundEvents.RABBIT_AMBIENT);
							}
						}
						default: {
							return;
						}
						}
					}
				}
			}
		}
	}

}
