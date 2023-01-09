package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class ChocolateChipping extends SimpleTrait {
	
	public static final Serializer<ChocolateChipping> SERIALIZER = new Serializer<ChocolateChipping>(new ResourceLocation(SilentCompat.MODID, "chocolate_chipping"), ChocolateChipping::new);

	public ChocolateChipping(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public float onDurabilityDamage(TraitActionContext context, int damageTaken) {
		Player player = context.getPlayer();
		Level level = player.getLevel();
		if (level.getRandom().nextInt(15) % 15 == 0) {
			if (!level.isClientSide) {
				Vec3 pos = player.position();
				RandomSource random = level.getRandom();
				double d0 = (double)Mth.randomBetween(random, -0.2F, 0.2F);
		        double d1 = (double)Mth.randomBetween(random, 0.3F, 0.5F);
		        double d2 = (double)Mth.randomBetween(random, -0.2F, 0.2F);
				level.addFreshEntity(new ItemEntity(level, pos.x(), pos.y(), pos.z(), new ItemStack(SilentCompatItems.CHOCOLATECHIP.get()), d0, d1, d2));
			}
		}
        return super.onDurabilityDamage(context, damageTaken);
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Chance to drop chocolate chips on durability loss");
        return ret;
    }

}
