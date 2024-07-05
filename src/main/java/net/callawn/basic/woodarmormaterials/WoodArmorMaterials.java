package net.callawn.basic.woodarmormaterials;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class WoodArmorMaterials {
    // Create the Armor Material with its parameters
    // Register the OAK material
    public static final RegistryEntry<ArmorMaterial> OAK_MATERIAL = register_material(
            "oak_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_OAK_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "oak_material")))
    );
    public static final RegistryEntry<ArmorMaterial> SPRUCE_MATERIAL = register_material(
            "spruce_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_SPRUCE_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "spruce_material")))
    );
    public static final RegistryEntry<ArmorMaterial> BIRCH_MATERIAL = register_material(
            "birch_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_BIRCH_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "birch_material")))
    );
    public static final RegistryEntry<ArmorMaterial> JUNGLE_MATERIAL = register_material(
            "jungle_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_JUNGLE_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "jungle_material")))
    );
    public static final RegistryEntry<ArmorMaterial> ACACIA_MATERIAL = register_material(
            "acacia_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_ACACIA_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "acacia_material")))
    );
    public static final RegistryEntry<ArmorMaterial> DARK_OAK_MATERIAL = register_material(
            "dark_oak_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_DARK_OAK_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "dark_oak_material")))
    );
    public static final RegistryEntry<ArmorMaterial> BAMBOO_MATERIAL = register_material(
            "bamboo_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_BAMBOO_BLOCK),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "bamboo_material")))
    );
    public static final RegistryEntry<ArmorMaterial> MANGROVE_MATERIAL = register_material(
            "mangrove_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_MANGROVE_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "mangrove_material")))
    );
    public static final RegistryEntry<ArmorMaterial> CHERRY_MATERIAL = register_material(
            "cherry_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_CHERRY_LOG),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "cherry_material")))
    );
    public static final RegistryEntry<ArmorMaterial> CRIMSON_MATERIAL = register_material(
            "crimson_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_CRIMSON_STEM),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "crimson_material")))
    );
    public static final RegistryEntry<ArmorMaterial> WARPED_MATERIAL = register_material(
            "warped_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.STRIPPED_WARPED_STEM),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "warped_material")))
    );
    public static final RegistryEntry<ArmorMaterial> CHORUS_MATERIAL = register_material(
            "chorus_material",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 2);
            }),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            () -> Ingredient.ofItems(Items.CHORUS_FRUIT),
            List.of(new ArmorMaterial.Layer(Identifier.of("callawnsbasic", "chorus_material")))
    );





    // Does the heavy lifting for me
    private static RegistryEntry<ArmorMaterial> register_material(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.ofVanilla(id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}
