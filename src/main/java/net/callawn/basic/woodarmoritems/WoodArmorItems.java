package net.callawn.basic.woodarmoritems;

import net.callawn.basic.woodarmormaterials.WoodArmorMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodArmorItems {


    // Generate the material
    public static final Item OAK_BOOTS = new ArmorItem(WoodArmorMaterials.OAK_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item OAK_LEGGINGS = new ArmorItem(WoodArmorMaterials.OAK_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item OAK_CHESTPLATE = new ArmorItem(WoodArmorMaterials.OAK_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item OAK_HELMET = new ArmorItem(WoodArmorMaterials.OAK_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item SPRUCE_BOOTS = new ArmorItem(WoodArmorMaterials.SPRUCE_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item SPRUCE_LEGGINGS = new ArmorItem(WoodArmorMaterials.SPRUCE_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item SPRUCE_CHESTPLATE = new ArmorItem(WoodArmorMaterials.SPRUCE_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item SPRUCE_HELMET = new ArmorItem(WoodArmorMaterials.SPRUCE_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item BIRCH_BOOTS = new ArmorItem(WoodArmorMaterials.BIRCH_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item BIRCH_LEGGINGS = new ArmorItem(WoodArmorMaterials.BIRCH_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item BIRCH_CHESTPLATE = new ArmorItem(WoodArmorMaterials.BIRCH_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item BIRCH_HELMET = new ArmorItem(WoodArmorMaterials.BIRCH_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item JUNGLE_BOOTS = new ArmorItem(WoodArmorMaterials.JUNGLE_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item JUNGLE_LEGGINGS = new ArmorItem(WoodArmorMaterials.JUNGLE_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item JUNGLE_CHESTPLATE = new ArmorItem(WoodArmorMaterials.JUNGLE_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item JUNGLE_HELMET = new ArmorItem(WoodArmorMaterials.JUNGLE_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item ACACIA_BOOTS = new ArmorItem(WoodArmorMaterials.ACACIA_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item ACACIA_LEGGINGS = new ArmorItem(WoodArmorMaterials.ACACIA_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item ACACIA_CHESTPLATE = new ArmorItem(WoodArmorMaterials.ACACIA_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item ACACIA_HELMET = new ArmorItem(WoodArmorMaterials.ACACIA_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item DARK_OAK_BOOTS = new ArmorItem(WoodArmorMaterials.DARK_OAK_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item DARK_OAK_LEGGINGS = new ArmorItem(WoodArmorMaterials.DARK_OAK_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item DARK_OAK_CHESTPLATE = new ArmorItem(WoodArmorMaterials.DARK_OAK_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item DARK_OAK_HELMET = new ArmorItem(WoodArmorMaterials.DARK_OAK_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item BAMBOO_BOOTS = new ArmorItem(WoodArmorMaterials.BAMBOO_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item BAMBOO_LEGGINGS = new ArmorItem(WoodArmorMaterials.BAMBOO_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item BAMBOO_CHESTPLATE = new ArmorItem(WoodArmorMaterials.BAMBOO_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item BAMBOO_HELMET = new ArmorItem(WoodArmorMaterials.BAMBOO_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item MANGROVE_BOOTS = new ArmorItem(WoodArmorMaterials.MANGROVE_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item MANGROVE_LEGGINGS = new ArmorItem(WoodArmorMaterials.MANGROVE_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item MANGROVE_CHESTPLATE = new ArmorItem(WoodArmorMaterials.MANGROVE_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item MANGROVE_HELMET = new ArmorItem(WoodArmorMaterials.MANGROVE_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item CHERRY_BOOTS = new ArmorItem(WoodArmorMaterials.CHERRY_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item CHERRY_LEGGINGS = new ArmorItem(WoodArmorMaterials.CHERRY_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item CHERRY_CHESTPLATE = new ArmorItem(WoodArmorMaterials.CHERRY_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item CHERRY_HELMET = new ArmorItem(WoodArmorMaterials.CHERRY_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item CRIMSON_BOOTS = new ArmorItem(WoodArmorMaterials.CRIMSON_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item CRIMSON_LEGGINGS = new ArmorItem(WoodArmorMaterials.CRIMSON_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item CRIMSON_CHESTPLATE = new ArmorItem(WoodArmorMaterials.CRIMSON_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item CRIMSON_HELMET = new ArmorItem(WoodArmorMaterials.CRIMSON_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item WARPED_BOOTS = new ArmorItem(WoodArmorMaterials.WARPED_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item WARPED_LEGGINGS = new ArmorItem(WoodArmorMaterials.WARPED_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item WARPED_CHESTPLATE = new ArmorItem(WoodArmorMaterials.WARPED_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item WARPED_HELMET = new ArmorItem(WoodArmorMaterials.WARPED_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    public static final Item CHORUS_BOOTS = new ArmorItem(WoodArmorMaterials.CHORUS_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());
    public static final Item CHORUS_LEGGINGS = new ArmorItem(WoodArmorMaterials.CHORUS_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item CHORUS_CHESTPLATE = new ArmorItem(WoodArmorMaterials.CHORUS_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item CHORUS_HELMET = new ArmorItem(WoodArmorMaterials.CHORUS_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());

    // Generate group location for all items
    public static final ItemGroup WOOD_ARMOR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(OAK_BOOTS))
            .displayName(Text.translatable("Callawn's Wood Armor"))
            .entries((context, entries) -> {
                entries.add(OAK_BOOTS);
                entries.add(OAK_LEGGINGS);
                entries.add(OAK_CHESTPLATE);
                entries.add(OAK_HELMET);
                entries.add(SPRUCE_BOOTS);
                entries.add(SPRUCE_LEGGINGS);
                entries.add(SPRUCE_CHESTPLATE);
                entries.add(SPRUCE_HELMET);
                entries.add(BIRCH_BOOTS);
                entries.add(BIRCH_LEGGINGS);
                entries.add(BIRCH_CHESTPLATE);
                entries.add(BIRCH_HELMET);
                entries.add(JUNGLE_BOOTS);
                entries.add(JUNGLE_LEGGINGS);
                entries.add(JUNGLE_CHESTPLATE);
                entries.add(JUNGLE_HELMET);
                entries.add(ACACIA_BOOTS);
                entries.add(ACACIA_LEGGINGS);
                entries.add(ACACIA_CHESTPLATE);
                entries.add(ACACIA_HELMET);
                entries.add(BAMBOO_BOOTS);
                entries.add(BAMBOO_LEGGINGS);
                entries.add(BAMBOO_CHESTPLATE);
                entries.add(BAMBOO_HELMET);
                entries.add(DARK_OAK_BOOTS);
                entries.add(DARK_OAK_LEGGINGS);
                entries.add(DARK_OAK_CHESTPLATE);
                entries.add(DARK_OAK_HELMET);
                entries.add(MANGROVE_BOOTS);
                entries.add(MANGROVE_LEGGINGS);
                entries.add(MANGROVE_CHESTPLATE);
                entries.add(MANGROVE_HELMET);
                entries.add(CHERRY_BOOTS);
                entries.add(CHERRY_LEGGINGS);
                entries.add(CHERRY_CHESTPLATE);
                entries.add(CHERRY_HELMET);
                entries.add(CRIMSON_BOOTS);
                entries.add(CRIMSON_LEGGINGS);
                entries.add(CRIMSON_CHESTPLATE);
                entries.add(CRIMSON_HELMET);
                entries.add(WARPED_BOOTS);
                entries.add(WARPED_LEGGINGS);
                entries.add(WARPED_CHESTPLATE);
                entries.add(WARPED_HELMET);
                entries.add(CHORUS_BOOTS);
                entries.add(CHORUS_LEGGINGS);
                entries.add(CHORUS_CHESTPLATE);
                entries.add(CHORUS_HELMET);
            })
            .build();

    public static void registerItems() {
        // register item group for all items to exist in
        Registry.register(Registries.ITEM_GROUP, Identifier.of("callawnsbasic", "wood_armor_group"), WOOD_ARMOR_GROUP);
        // add to the item registry
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "oak_boots"), OAK_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "oak_leggings"), OAK_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "oak_chestplate"), OAK_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "oak_helmet"), OAK_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "spruce_boots"), SPRUCE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "spruce_leggings"), SPRUCE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "spruce_chestplate"), SPRUCE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "spruce_helmet"), SPRUCE_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "birch_boots"), BIRCH_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "birch_leggings"), BIRCH_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "birch_chestplate"), BIRCH_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "birch_helmet"), BIRCH_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "jungle_boots"), JUNGLE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "jungle_leggings"), JUNGLE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "jungle_chestplate"), JUNGLE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "jungle_helmet"), JUNGLE_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "acacia_boots"), ACACIA_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "acacia_leggings"), ACACIA_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "acacia_chestplate"), ACACIA_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "acacia_helmet"), ACACIA_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "dark_oak_boots"), DARK_OAK_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "dark_oak_leggings"), DARK_OAK_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "dark_oak_chestplate"), DARK_OAK_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "dark_oak_helmet"), DARK_OAK_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "bamboo_boots"), BAMBOO_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "bamboo_leggings"), BAMBOO_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "bamboo_chestplate"), BAMBOO_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "bamboo_helmet"), BAMBOO_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "mangrove_boots"), MANGROVE_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "mangrove_leggings"), MANGROVE_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "mangrove_chestplate"), MANGROVE_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "mangrove_helmet"), MANGROVE_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "cherry_boots"), CHERRY_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "cherry_leggings"), CHERRY_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "cherry_chestplate"), CHERRY_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "cherry_helmet"), CHERRY_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "crimson_boots"), CRIMSON_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "crimson_leggings"), CRIMSON_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "crimson_chestplate"), CRIMSON_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "crimson_helmet"), CRIMSON_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "warped_boots"), WARPED_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "warped_leggings"), WARPED_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "warped_chestplate"), WARPED_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "warped_helmet"), WARPED_HELMET);

        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "chorus_boots"), CHORUS_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "chorus_leggings"), CHORUS_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "chorus_chestplate"), CHORUS_CHESTPLATE);
        Registry.register(Registries.ITEM, Identifier.of("callawnsbasic", "chorus_helmet"), CHORUS_HELMET);
    }

}
