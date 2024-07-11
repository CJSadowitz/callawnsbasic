package net.callawn.basic;

import java.io.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;
import net.minecraft.util.Util;
import java.util.*;
import java.util.function.Supplier;


public class ArmorMaterials {
    // Create the Armor Material with its parameters
    static ArrayList<String> materials = new ArrayList<>();
    static ArrayList<Integer> armor = new ArrayList<>();
    static ArrayList<Integer> enchantability = new ArrayList<>();
    static ArrayList<String> equipSound = new ArrayList<>();
    static ArrayList<Float> toughness = new ArrayList<>();
    static ArrayList<Float> knock_back = new ArrayList<>();
    static ArrayList<String> ingredient = new ArrayList<>();
    static ArrayList<String> namespace = new ArrayList<>();
    static ArrayList<RegistryEntry<ArmorMaterial>> finalArmorMaterials = new ArrayList<>();

    public static void getMaterials(InputStream path) {
        // Get and register materials from csv
        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(path));
            String line;
            int line_counter = 0;
            while ((line = file.readLine()) != null) {
                if (line_counter == 0)
                {
                    // skip the first line describing the csv file
                    line_counter++;
                    continue;
                }
                int comma_counter = 0;
                StringBuilder material = new StringBuilder(100);
                StringBuilder armor_one = new StringBuilder(100);
                StringBuilder armor_two = new StringBuilder(100);
                StringBuilder armor_three = new StringBuilder(100);
                StringBuilder armor_four = new StringBuilder(100);
                StringBuilder armor_five = new StringBuilder(100);
                StringBuilder enchant_str = new StringBuilder(100);
                StringBuilder sound_str = new StringBuilder(100);
                StringBuilder toughness_str = new StringBuilder(100);
                StringBuilder knock_str = new StringBuilder(100);
                StringBuilder ingredient_str = new StringBuilder(100);
                StringBuilder namespace_str = new StringBuilder(100);

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        comma_counter++;
                        continue;
                    }
                    if (comma_counter == 0) {
                        material.append(line.charAt(i));
                    } else if (comma_counter > 0 && comma_counter < 6 && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        if (comma_counter == 1) {
                            armor_one.append(line.charAt(i));
                        } else if (comma_counter == 2) {
                            armor_two.append(line.charAt(i));
                        } else if (comma_counter == 3) {
                            armor_three.append(line.charAt(i));
                        } else if (comma_counter == 4) {
                            armor_four.append(line.charAt(i));
                        } else {
                            armor_five.append(line.charAt(i));
                        }
                    } else if (comma_counter == 6 && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        enchant_str.append(line.charAt(i));
                    } else if (comma_counter == 7 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        sound_str.append(line.charAt(i));
                    } else if (comma_counter == 8 && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        toughness_str.append(line.charAt(i));
                    } else if (comma_counter == 9 && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        knock_str.append(line.charAt(i));
                    } else if (comma_counter == 10 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        ingredient_str.append(line.charAt(i));
                    } else if (comma_counter == 11 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        namespace_str.append(line.charAt(i));
                    }
                }
                // Change the armor_strings into integers
                try {
                    materials.add(material.toString());
                    armor.add(Integer.parseInt(armor_one.toString()));
                    armor.add(Integer.parseInt(armor_two.toString()));
                    armor.add(Integer.parseInt(armor_three.toString()));
                    armor.add(Integer.parseInt(armor_four.toString()));
                    armor.add(Integer.parseInt(armor_five.toString()));
                    toughness.add(Float.parseFloat(toughness_str.toString()));
                    knock_back.add(Float.parseFloat(knock_str.toString()));
                    enchantability.add(Integer.parseInt(enchant_str.toString()));
                    equipSound.add(sound_str.toString());
                    ingredient.add(ingredient_str.toString());
                    namespace.add(namespace_str.toString());
                }
                catch (NumberFormatException error) {
                    System.out.println("WoodArmorMaterials: getMaterials: Data parse error: " + error);
                }
                catch (NullPointerException error) {
                    System.out.println("WoodArmorMaterials: getMaterials: Nullptr error: " + error);
                }
                catch (InvalidIdentifierException error) {
                    System.out.println("WoodArmorMaterials: getMaterials: Wrong Character " + error);
                }
            }
            file.close();
        } catch (IOException error) {
            System.out.println("File reader error ARMORMATERIALS.CSV, " + error);
            System.out.println(System.getProperty("user.dir"));
        }
    }
    public static void register_all_materials()
    {
        // Iterate through the list and register every item
        for (int i = 0; i < toughness.size(); i++)
        {
            final int finalI = i;
            String id = materials.get(i);
            EnumMap<ArmorItem.Type, Integer> armorMap =
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, armor.get(finalI));
                map.put(ArmorItem.Type.LEGGINGS, armor.get(finalI + 1));
                map.put(ArmorItem.Type.CHESTPLATE, armor.get(finalI + 2));
                map.put(ArmorItem.Type.HELMET, armor.get(finalI + 3));
                map.put(ArmorItem.Type.BODY, armor.get(finalI + 4));
            });
            int enchant = enchantability.get(i);
            RegistryEntry<SoundEvent> equip = getSound(equipSound.get(i));

            String itemName = ingredient.get(i);
            // Find the correct item for the ingredient
            Registry<Item> itemRegistry = Registries.ITEM;
            Item item = itemRegistry.get(Identifier.of(namespace.get(i), itemName));
            Supplier<Ingredient> repairIngredient = () -> Ingredient.ofItems(item);
            
            float tough = toughness.get(i);
            float knock = knock_back.get(i);
            String name_space = namespace.get(i);
            try
            {
                finalArmorMaterials.add(register_material(id, armorMap, enchant, equip, tough, knock, repairIngredient,
                        List.of(new ArmorMaterial.Layer(Identifier.of(name_space, id)))));
            }
            catch (Exception error)
            {
                System.out.println("Armor Material Registration: " + error);
            }
        }
    }

    private static RegistryEntry<SoundEvent> getSound(String input)
    {
        if (Objects.equals(input, "leather")) {
            return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
        } else if (Objects.equals(input, "iron")) {
            return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
        } else if (Objects.equals(input, "chain")) {
            return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
        } else if (Objects.equals(input, "gold")) {
            return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
        } else if (Objects.equals(input, "diamond")) {
            return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
        }
        return SoundEvents.AMBIENT_CAVE;
    }

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
