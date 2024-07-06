package net.callawn.basic;

import net.fabricmc.api.ModInitializer;


public class Callawnsbasic implements ModInitializer {

	@Override
	public void onInitialize() {
		WoodArmorItems.generateItems("armormaterials.csv", "armoritems.csv");

	}
}