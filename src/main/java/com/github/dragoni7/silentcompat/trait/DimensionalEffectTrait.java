package com.github.dragoni7.silentcompat.trait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nullable;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.item.ICoreArmor;
import net.silentchaos512.gear.api.item.ICoreItem;
import net.silentchaos512.gear.api.traits.ITraitSerializer;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.TraitHelper;
import net.silentchaos512.lib.util.TimeUtils;
import net.silentchaos512.utils.EnumUtils;

/*
 * Original Author: SilentChaos
 * 
 * Edit of the WielderEffectTrait class to include a check for dimension.
 *
 */

public class DimensionalEffectTrait extends SimpleTrait {
	
    public static final ITraitSerializer<DimensionalEffectTrait> SERIALIZER = new Serializer<>(
    		new ResourceLocation(SilentCompat.MODID, "dimensional_effect"),
            DimensionalEffectTrait::new,
            DimensionalEffectTrait::deserializeJson,
            DimensionalEffectTrait::readFromNetwork,
            DimensionalEffectTrait::writeToNetwork
    );
    
    protected final Map<String, List<PotionData>> potions = new HashMap<>();
    
	public DimensionalEffectTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
    protected DimensionalEffectTrait(ResourceLocation id, ITraitSerializer<? extends DimensionalEffectTrait> serializer) {
        super(id, serializer);
    }
	
    @Override
    public void onUpdate(TraitActionContext context, boolean isEquipped) {
    	
        if (!isEquipped || context.getPlayer() == null || context.getPlayer().tickCount % 10 != 0) return;
        
        GearType gearType = ((ICoreItem) context.getGear().getItem()).getGearType();

        for (Map.Entry<String, List<PotionData>> entry : potions.entrySet()) {
            String type = entry.getKey();
            List<PotionData> list = entry.getValue();
            applyEffects(context, gearType, type, list);
        }
    }

    protected void applyEffects(TraitActionContext context, GearType gearType, String type, Iterable<PotionData> effects) {
        Player player = context.getPlayer();
        assert player != null; // checked in onUpdate

        if (gearType.matches(type) || "all".equals(type)) {
            int setPieceCount = getSetPieceCount(type, player);
            boolean hasFullSet = !"armor".equals(type) || setPieceCount >= 4;

            for (PotionData potionData : effects) {
                MobEffectInstance effect = potionData.getEffect(context.getTraitLevel(), setPieceCount, hasFullSet);
                
                // only apply effect in dimension
                if (effect != null && player.level().dimension().location().equals(potionData.getDimensionId())) {
                    player.addEffect(effect);
                }
            }
        }
    }

    protected int getSetPieceCount(String type, Player player) {
        if (!"armor".equals(type)) return 1;

        int count = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.getItem() instanceof ICoreArmor && TraitHelper.hasTrait(stack, this)) {
                ++count;
            }
        }
        return count;
    }

    static void deserializeJson(DimensionalEffectTrait trait, JsonObject json) {
        if (!json.has("potion_effects")) {
            throw new JsonParseException("Dimensional effect trait '" + trait.getId() + "' is missing 'potion_effects' object");
        }

        // Parse potion effects array
        JsonObject jsonEffects = json.getAsJsonObject("potion_effects");
        for (Map.Entry<String, JsonElement> entry : jsonEffects.entrySet()) {
            // Key (gear type)
            String key = entry.getKey();
            // Array of PotionData objects
            JsonElement element = entry.getValue();

            if (!element.isJsonArray()) {
                throw new JsonParseException("Expected array, found " + element.getClass().getSimpleName());
            }

            JsonArray array = element.getAsJsonArray();
            List<PotionData> list = new ArrayList<>();
            for (JsonElement elem : array) {
                if (!elem.isJsonObject()) {
                    throw new JsonParseException("Expected object, found " + elem.getClass().getSimpleName());
                }
                list.add(PotionData.from(elem.getAsJsonObject()));
            }

            if (!list.isEmpty()) {
                trait.potions.put(key, list);
            }
        }
    }

    static void readFromNetwork(DimensionalEffectTrait trait, FriendlyByteBuf buffer) {
        trait.potions.clear();
        
        int gearTypeCount = buffer.readByte();

        for (int typeIndex = 0; typeIndex < gearTypeCount; ++typeIndex) {
            List<PotionData> list = new ArrayList<>();
            String gearType = buffer.readUtf();
            int potionDataCount = buffer.readByte();

            for (int potionIndex = 0; potionIndex < potionDataCount; ++potionIndex) {
                list.add(PotionData.read(buffer));
            }

            trait.potions.put(gearType, list);
        }
    }

    static void writeToNetwork(DimensionalEffectTrait trait, FriendlyByteBuf buffer) {
        buffer.writeByte(trait.potions.size());
        for (Map.Entry<String, List<PotionData>> entry : trait.potions.entrySet()) {
            buffer.writeUtf(entry.getKey());
            buffer.writeByte(entry.getValue().size());

            for (PotionData potionData : entry.getValue()) {
                potionData.write(buffer);
            }
        }
    }

    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("While in ");
        this.potions.forEach((type, list) -> {
            ret.add("  - " + type);
            list.forEach(mod -> {
                ret.add("    - " + mod.getWikiLine());
            });
        });
        return ret;
    }

    public static class PotionData {
        private LevelType type;
        private ResourceLocation effectId;
        private ResourceLocation dimensionId;
        private int duration;
        private int[] levels;

        @Deprecated
        public static PotionData of(boolean requiresFullSet, MobEffect effect, int... levels) {
            return of(requiresFullSet ? LevelType.FULL_SET_ONLY : LevelType.PIECE_COUNT, effect, levels);
        }

        public static PotionData of(LevelType type, MobEffect effect, int... levels) {
            PotionData ret = new PotionData();
            ret.type = type;
            ret.effectId = Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(effect));
            ret.duration = TimeUtils.ticksFromSeconds(getDefaultDuration(ret.effectId));
            ret.levels = levels.clone();
            return ret;
        }

        public JsonObject serialize() {
            JsonObject json = new JsonObject();
            json.addProperty("type", this.type.getName());
            json.addProperty("effect", this.effectId.toString());

            JsonArray levelsArray = new JsonArray();
            Arrays.stream(this.levels).forEach(levelsArray::add);
            json.add("level", levelsArray);
            return json;
        }

        static PotionData from(JsonObject json) {
            PotionData ret = new PotionData();
            ret.type = deserializeType(json);
            // Effect ID, get actual potion only when needed
            ret.effectId = new ResourceLocation(GsonHelper.getAsString(json, "effect", "unknown"));
            // Effects duration in seconds.
            float durationInSeconds = GsonHelper.getAsFloat(json, "duration", getDefaultDuration(ret.effectId));
            ret.duration = TimeUtils.ticksFromSeconds(durationInSeconds);
            // Dimension for applying effect in
            ret.dimensionId = new ResourceLocation(GsonHelper.getAsString(json, "dimension", "unknown"));

            // Level int or array
            JsonElement elementLevel = json.get("level");
            if (elementLevel == null) {
                throw new JsonParseException("level element not found, should be either int or array");
            }
            if (elementLevel.isJsonPrimitive()) {
                // Single level
                ret.levels = new int[]{GsonHelper.getAsInt(json, "level", 1)};
            } else if (elementLevel.isJsonArray()) {
                // Levels by piece count
                JsonArray array = elementLevel.getAsJsonArray();
                ret.levels = new int[array.size()];
                for (int i = 0; i < ret.levels.length; ++i) {
                    ret.levels[i] = array.get(i).getAsInt();
                }
            } else {
                throw new JsonParseException("Expected level to be int or array, was " + elementLevel.getClass().getSimpleName());
            }

            return ret;
        }

        private static LevelType deserializeType(JsonObject json) {
            if (json.has("type")) {
                return EnumUtils.byName(GsonHelper.getAsString(json, "type"), LevelType.FULL_SET_ONLY);
            } else if (json.has("full_set")) {
                return GsonHelper.getAsBoolean(json, "full_set") ? LevelType.FULL_SET_ONLY : LevelType.PIECE_COUNT;
            }
            return LevelType.TRAIT_LEVEL;
        }

        static PotionData read(FriendlyByteBuf buffer) {
            PotionData ret = new PotionData();
            ret.type = buffer.readEnum(LevelType.class);
            ret.effectId = buffer.readResourceLocation();
            ret.dimensionId = buffer.readResourceLocation();
            ret.duration = buffer.readVarInt();
            ret.levels = buffer.readVarIntArray();
            return ret;
        }

        void write(FriendlyByteBuf buffer) {
            buffer.writeEnum(type);
            buffer.writeResourceLocation(effectId);
            buffer.writeResourceLocation(dimensionId);
            buffer.writeVarInt(duration);
            buffer.writeVarIntArray(levels);
        }

        private static float getDefaultDuration(ResourceLocation effectId) {
            // Duration in seconds. The .9 should prevent flickering.
            return new ResourceLocation("night_vision").equals(effectId) ? 15.9f : 1.9f;
        }

        @Nullable
        MobEffectInstance getEffect(int traitLevel, int pieceCount, boolean hasFullSet) {
            if (this.type == LevelType.FULL_SET_ONLY && !hasFullSet) return null;

            MobEffect potion = ForgeRegistries.MOB_EFFECTS.getValue(effectId);
            if (potion == null) return null;

            int effectLevel = getEffectLevel(traitLevel, pieceCount, hasFullSet);
            if (effectLevel < 1) return null;

            return new MobEffectInstance(potion, duration, effectLevel - 1, true, false);
        }
        
        ResourceLocation getDimensionId() {
        	return dimensionId;
        }
        
        int getEffectLevel(int traitLevel, int pieceCount, boolean hasFullSet) {
            switch (this.type) {
                case TRAIT_LEVEL:
                    return this.levels[Mth.clamp(traitLevel - 1, 0, this.levels.length - 1)];
                case PIECE_COUNT:
                    return this.levels[Mth.clamp(pieceCount - 1, 0, this.levels.length - 1)];
                case FULL_SET_ONLY:
                    return this.levels[0];
                default:
                    throw new IllegalArgumentException("Unknown level type for wielder effect trait: " + this.type);
            }
        }

        public String getWikiLine() {
            String[] levelsText = new String[levels.length];
            for (int i = 0; i < levels.length; ++i) {
                levelsText[i] = Integer.toString(levels[i]);
            }

            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(effectId);
            String effectName;
            if (effect != null) {
                effectName = effect.getDisplayName().getString();
            } else {
                effectName = effectId.toString();
            }
            
            String dimensionName = dimensionId.toString().split(":")[1].replaceAll("_", " ") + ": ";

            return makeWikiText(effectName, dimensionName, levelsText, type.wikiText);
        }
    }
    
    public enum LevelType {
        TRAIT_LEVEL("by trait level"),
        PIECE_COUNT("by armor piece count"),
        FULL_SET_ONLY("requires full set of armor");

        final String wikiText;

        LevelType(String wikiText) {
            this.wikiText = wikiText;
        }

        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
    
    protected static String makeWikiText(String effectName, String dimensionName, String levelsText[], String type) {
    	return String.format("%s: [%s] (%s)", dimensionName, effectName, String.join(", ", levelsText), type);
    }
}
