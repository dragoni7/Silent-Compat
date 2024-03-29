package com.github.dragoni7.silentcompat.modcompats;

import mythicbotany.register.ModItems;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import vazkii.botania.common.entity.ManaBurstEntity;
import vazkii.botania.common.handler.BotaniaSounds;
import vazkii.botania.common.item.equipment.tool.terrasteel.TerraBladeItem;

public class MythicBotanyCompat {
	
	public static void SpawnManaBurst(LivingEntity entity) {
        Player player = (Player) entity;
        if(!entity.getLevel().isClientSide() && !player.isSpectator()) {
            if (!player.getMainHandItem().isEmpty()) {
                ItemStack gearItemStack = player.getMainHandItem();

                if (player.getAttackStrengthScale(0F) == 1) {
                	ManaBurstEntity burst = getAlfBurst(player, ModItems.alfsteelSword.getDefaultInstance());
                    player.getLevel().addFreshEntity(burst);
                    gearItemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    player.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), BotaniaSounds.terraBlade, SoundSource.PLAYERS, 1F, 1F);
                }
            }
        }
	}
	
	private static ManaBurstEntity getAlfBurst(Player player, ItemStack stack) {
        ManaBurstEntity burst = TerraBladeItem.getBurst(player, stack);
        burst.setColor(0xF79100);
        burst.setMana(200);
        burst.setStartingMana(200);
        burst.setMinManaLoss(20);
        burst.setManaLossPerTick(2.0F);
        return burst;
	}

}
