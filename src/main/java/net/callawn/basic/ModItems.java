package net.callawn.basic;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ModItems {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> nameSpaces = new ArrayList<>();

    public static void getItems(String path) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line;
            int line_counter = 0;
            while((line = file.readLine()) != null) {
                // skip the first line
                if (line_counter == 0) {
                    line_counter++;
                    continue;
                }
                StringBuilder name = new StringBuilder();
                StringBuilder nameSpace = new StringBuilder();
                int comma_counter = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        comma_counter++;
                    }
                    if (comma_counter == 0 && ((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') || line.charAt(i) == '_')) {
                        name.append(line.charAt(i));
                    }
                    else if (comma_counter == 1 && ((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') || line.charAt(i) == '_')) {
                        nameSpace.append(line.charAt(i));
                    }
                }
                names.add(name.toString());
                nameSpaces.add(nameSpace.toString());
            }
        }
        catch (IOException error) {
            System.out.println("Items: File not found: " + error);
        }
    }
    public static void register() {
        for(int i = 0; i < names.size(); i++) {
            Registry.register(Registries.ITEM, Identifier.of(nameSpaces.get(i), names.get(i)), new Item(new Item.Settings()));
        }
    }

    public static void generateItems(String path) {
        getItems(path);
        register();
    }
}
