package com.github.dragoni7.silentcompat.modcompats;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.entity.ManaBurstEntity;
import vazkii.botania.common.handler.BotaniaSounds;
import vazkii.botania.common.item.BotaniaItems;
import vazkii.botania.common.item.equipment.tool.terrasteel.TerraBladeItem;

public class BotaniaCompat {
	
	public static void SpawnManaBurst(LivingEntity entity) {
        Player player = (Player) entity;
        if(!entity.getLevel().isClientSide() && !player.isSpectator()) {
            if (!player.getMainHandItem().isEmpty()) {
                ItemStack gearItemStack = player.getMainHandItem();

                if (player.getAttackStrengthScale(0F) == 1) {
                    // The default instance is really our only way, ILensEffect (or any item interface for that matter)
                    // is not really possible with silent gear system because it is tied to the tool and not the trait
                    // (at least for now...)
                	ManaBurstEntity burst = TerraBladeItem.getBurst(player, BotaniaItems.terraSword.getDefaultInstance());
                    player.getLevel().addFreshEntity(burst);

                    gearItemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));

                    player.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), BotaniaSounds.terraBlade, SoundSource.PLAYERS, 1F, 1F);
                }
            }
        }
	}
	
	public static void ManaRepair(ItemStack thisGear, TraitActionContext context, boolean isEquipped, int manaPerDamageTier) {
        Player player = context.getPlayer();
        Level world = player.getLevel();
        
        int manaToUse = 20 + (manaPerDamageTier * context.getTraitLevel());
        
        if (!world.isClientSide() && player instanceof Player && isEquipped) {
            if (thisGear.getDamageValue() > 0) {
                if (ManaItemHandler.instance().requestManaExactForTool(thisGear, player, manaToUse, true)) {
                    thisGear.setDamageValue(thisGear.getDamageValue() - 1);
                }
            }
        }
	}

}
