package net.callawn.basic;

import net.callawn.basic.woodarmoritems.WoodArmorItems;
import net.fabricmc.api.ModInitializer;


public class Callawnsbasic implements ModInitializer {

	@Override
	public void onInitialize() {
		WoodArmorItems.registerItems();

	}
}