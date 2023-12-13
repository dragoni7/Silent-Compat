package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.lib.util.NameUtils;

public class ItemDropTrait extends SimpleTrait {

	public static final Serializer<ItemDropTrait> SERIALIZER = new Serializer<ItemDropTrait>(
			SilentCompat.getId("item_drop"), ItemDropTrait::new, ItemDropTrait::readJson, ItemDropTrait::read,
			ItemDropTrait::write);

	private Item dropItem;
	private int chance;

	public ItemDropTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

	@Override
	public float onDurabilityDamage(TraitActionContext context, int damageTaken) {
		Player player = context.getPlayer();
		
		if (player != null) {
			Level level = player.level();
			if (level.getRandom().nextInt(chance) % chance == 0) {
				if (!level.isClientSide) {
					Vec3 pos = player.position();
					RandomSource random = level.getRandom();
					double d0 = (double) Mth.randomBetween(random, -0.2F, 0.2F);
					double d1 = (double) Mth.randomBetween(random, 0.3F, 0.5F);
					double d2 = (double) Mth.randomBetween(random, -0.2F, 0.2F);
					level.addFreshEntity(
							new ItemEntity(level, pos.x(), pos.y(), pos.z(), new ItemStack(dropItem), d0, d1, d2));
				}
			}
		}
		
		return super.onDurabilityDamage(context, damageTaken);
	}

	private static void readJson(ItemDropTrait trait, JsonObject json) {

		Item dropItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(json, "item")));

		if (dropItem != null) {
			trait.dropItem = dropItem;
		}

		trait.chance = GsonHelper.getAsInt(json, "chance", 0);
	}

	private static void read(ItemDropTrait trait, FriendlyByteBuf buffer) {
		trait.dropItem = ForgeRegistries.ITEMS.getValue(buffer.readResourceLocation());
		trait.chance = buffer.readVarInt();
	}

	private static void write(ItemDropTrait trait, FriendlyByteBuf buffer) {

		buffer.writeResourceLocation(NameUtils.fromItem(trait.dropItem));
		buffer.writeVarInt(trait.chance);
	}

	@Override
	public Collection<String> getExtraWikiLines() {
		Collection<String> ret = super.getExtraWikiLines();

		if (dropItem != null) {
			ret.add("Chance to drop" + NameUtils.fromItem(dropItem) + " on durability loss with 1 out of" + chance
					+ "% chance");
		}

		return ret;
	}
}
