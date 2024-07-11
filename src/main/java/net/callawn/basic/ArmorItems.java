package net.callawn.basic;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArmorItems {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> nameSpaces = new ArrayList<>();
    static ArrayList<String> materials = new ArrayList<>();
    static ArrayList<String> groups = new ArrayList<>();
    static ArrayList<String> ingredients = new ArrayList<>();

    private static void getArmorItems(String path)
    {
        System.out.println(System.getProperty("user.dir") + " ArmorItems Fun...");
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line;
            int line_counter = 0;

            while ((line = file.readLine()) != null) {
                // Skip the first line of the CSV
                if (line_counter == 0) {
                    line_counter++;
                    continue;
                }
                StringBuilder armorType = new StringBuilder();
                StringBuilder nameSpace = new StringBuilder();
                StringBuilder material = new StringBuilder();
                StringBuilder group = new StringBuilder();
                StringBuilder ingredient = new StringBuilder();

                int comma_counter = 0;

                // parse through the line information
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        comma_counter++;
                        continue;
                    }
                    if (comma_counter == 0) {
                        armorType.append(line.charAt(i));
                    } else if (comma_counter == 1 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        nameSpace.append(line.charAt(i));
                    } else if (comma_counter == 2 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        material.append(line.charAt(i));
                    } else if (comma_counter == 3) {
                        group.append(line.charAt(i));
                    } else if (comma_counter == 4 && (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) == '_')) {
                        ingredient.append(line.charAt(i));
                    }
                }
                names.add(armorType.toString());
                nameSpaces.add(nameSpace.toString());
                materials.add(material.toString());
                groups.add(group.toString());
                ingredients.add(ingredient.toString());
            }
        }
        catch (IOException error) {
            System.out.println("File reader error armoritems.csv, " + error);
        }
    }

    public static void register() {
        // Always be an item. Need to register four items per name: boots, chestplate, helmet, leggings
        for (int i = 0; i < names.size(); i++) {
            String nameSpace = nameSpaces.get(i);
            RegistryEntry<ArmorMaterial> theArmorMaterial = ArmorMaterials.finalArmorMaterials.get(i);
            for(int j = 0; j < 4; j++) {
                if (j == 0) {
                    String itemName = names.get(i) + "_boots";
                    // Make and register item at the same time
                    try {
                        Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.BOOTS, new Item.Settings()));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else if (j == 1) {
                    String itemName = names.get(i) + "_leggings";
                    try {
                        Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.LEGGINGS, new Item.Settings()));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else if (j == 2) {
                    String itemName = names.get(i) + "_chestplate";
                    try {
                        Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else {
                    String itemName = names.get(i) + "_helmet";
                    try {
                        Registry.register(Registries.ITEM,
                              Identifier.of(nameSpace, itemName),
                              new ArmorItem(theArmorMaterial, ArmorItem.Type.HELMET, new Item.Settings()));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }
            }
        }
    }

    public static void generateItems(String materials, String armorItems)
    {
        ArmorMaterials.getMaterials(materials);
        ArmorMaterials.register_all_materials();

        getArmorItems(armorItems);
        register();
    }

//    // Generate group location for all items
//    public static final ItemGroup WOOD_ARMOR_GROUP = FabricItemGroup.builder()
//            .icon(() -> new ItemStack(OAK_BOOTS))
//            .displayName(Text.translatable("Callawn's Wood Armor"))
//            .entries((context, entries) -> {
//                entries.add(OAK_BOOTS);
//            })
//            .build();
//
//    public static void registerItems() {
//        // register item group for all items to exist in
//        Registry.register(Registries.ITEM_GROUP, Identifier.of("callawnsbasic", "wood_armor_group"), WOOD_ARMOR_GROUP);
//
//    }

}
