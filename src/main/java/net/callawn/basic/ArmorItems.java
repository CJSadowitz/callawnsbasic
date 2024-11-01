package net.callawn.basic;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArmorItems {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> nameSpaces = new ArrayList<>();
    static ArrayList<String> materials = new ArrayList<>();
    static ArrayList<String> groups = new ArrayList<>();
    static ArrayList<String> ingredients = new ArrayList<>();

    static ArrayList<Item> everyItem = new ArrayList<>();

    private static void getArmorItems(InputStream stream)
    {
        try
        {
            BufferedReader file = new BufferedReader(new InputStreamReader(stream));
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
                        everyItem.add(Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.BOOTS, new Item.Settings())));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else if (j == 1) {
                    String itemName = names.get(i) + "_leggings";
                    try {
                        everyItem.add(Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.LEGGINGS, new Item.Settings())));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else if (j == 2) {
                    String itemName = names.get(i) + "_chestplate";
                    try {
                        everyItem.add(Registry.register(Registries.ITEM,
                                Identifier.of(nameSpace, itemName),
                                new ArmorItem(theArmorMaterial, ArmorItem.Type.CHESTPLATE, new Item.Settings())));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }else {
                    String itemName = names.get(i) + "_helmet";
                    try {
                        everyItem.add(Registry.register(Registries.ITEM,
                              Identifier.of(nameSpace, itemName),
                              new ArmorItem(theArmorMaterial, ArmorItem.Type.HELMET, new Item.Settings())));
                    }
                    catch (NullPointerException error) {
                        System.out.println("WoodArmoritems: register: nullptr error: " + error);
                    }
                }
            }
        }
        RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("callawnsbasic", "item_group"));
        ItemGroup ARMOR_GROUP = FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.DIAMOND))
                .displayName(Text.translatable("itemGroup.callawnsarmor"))
                .entries((context, entries) -> {
                    for (Item item : everyItem) {
                        entries.add(item);
                    }
                })
                .build();
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, ARMOR_GROUP);
    }
    public static void generateJSONFiles() {
        String path_template = "..\\src\\main\\resources\\assets\\callawnsbasic\\models\\item\\";
        // loop through every item: check if corresponding json file exists if not create one
        for(Item item : everyItem) {
            // Starting on the 36 index, grab character until it hits an '
            StringBuilder file_name = new StringBuilder();
            String item_name = item.getName().toString();
            for(int j = 0; j < item_name.length(); j++) {
                if (j >= 36 && item_name.charAt(j) == '\'') {
                    break;
                }
                if (j >= 36) {
                    file_name.append(item_name.charAt(j));
                }
            }
            Path file_path = Paths.get(path_template + file_name + ".json");
            if (!Files.exists(file_path)) {
                // Add the json file to the directory
                String json = "{\n\"parent\": \"item/generated\",\n\"textures\":{\n\"layer0\": \"callawnsbasic:item/"+file_name+"\"\n}\n}";
                try {
                    Files.write(file_path, json.getBytes());
                } catch (IOException error) {
                    System.out.println("Failed to add texture json file " + file_name);
                }
                System.out.println("We added a file " + file_name);
            }

        }
    }

    public static void generateItems(InputStream materials, InputStream armorItems)
    {
        ArmorMaterials.getMaterials(materials);
        ArmorMaterials.register_all_materials();

        getArmorItems(armorItems);
        register();
        generateJSONFiles();
    }
}
