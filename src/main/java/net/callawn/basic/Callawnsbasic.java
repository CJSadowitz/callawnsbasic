package net.callawn.basic;

import net.fabricmc.api.ModInitializer;


public class Callawnsbasic implements ModInitializer {

	@Override
	public void onInitialize() {
		// fix paths
		WoodArmorItems.generateItems("C:\\Users\\sadow\\OneDrive\\Documents\\Minecraft Mods\\callawnsbasic-template-1.21\\src\\main\\java\\net\\callawn\\basic\\armormaterials.csv",
				"C:\\Users\\sadow\\OneDrive\\Documents\\Minecraft Mods\\callawnsbasic-template-1.21\\src\\main\\java\\net\\callawn\\basic\\armoritems.csv");

	}
}