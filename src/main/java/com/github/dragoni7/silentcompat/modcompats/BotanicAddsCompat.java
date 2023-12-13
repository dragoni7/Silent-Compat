package com.github.dragoni7.silentcompat.modcompats;

public class BotanicAddsCompat {
	
	/*public static void SpawnManaBurst(LivingEntity entity) {
        Player player = (Player) entity;
        if(!entity.getLevel().isClientSide() && !player.isSpectator()) {
            if (!player.getMainHandItem().isEmpty()) {
                ItemStack gearItemStack = player.getMainHandItem();

                if (player.getAttackStrengthScale(0F) == 1) {
                	ManaBurst burst = getGaiaBurst((ServerPlayer) player, ItemsBA.MANA_STEALER_SWORD.getDefaultInstance());
                    player.getLevel().addFreshEntity(burst.entity());
                    gearItemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    player.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), BotaniaSounds.terraBlade, SoundSource.PLAYERS, 1F, 1F);
                }
            }
        }
	}
	
	private static ManaBurst getGaiaBurst(ServerPlayer player, ItemStack stack) {
		ManaBurstEntity burst = new ManaBurstEntity(player);
		
		float motionModifier = 7F;
		
		burst.setColor(0xA03537);
		burst.setMana(200);
		burst.setStartingMana(200);
		burst.setMinManaLoss(200 / 4);
		burst.setManaLossPerTick(1F);
		burst.setGravity(0F);
		burst.setDeltaMovement(burst.getDeltaMovement().scale(motionModifier));
		
		ItemStack lens = stack.copy();
		lens.getOrCreateTagElement("Owner").putUUID("Id", player.getUUID());
		burst.setSourceLens(lens);
		
		return burst;
	}
*/
}
