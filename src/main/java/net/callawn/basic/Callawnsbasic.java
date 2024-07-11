package net.callawn.basic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

import java.io.InputStream;

public class Callawnsbasic implements ModInitializer {

	@Override
	public void onInitialize() {
		// fix paths
		InputStream materials = getClass().getClassLoader().getResourceAsStream("csv/armormaterials.csv");
		InputStream armor_items = getClass().getClassLoader().getResourceAsStream("csv/armoritems.csv");
		ArmorItems.generateItems(materials, armor_items);

		// ModItems.generateItems("..\\src\\main\\resources\\csv\\items.csv");


		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (player.getStackInHand(hand).getItem() == Items.ANVIL) {
				return ActionResult.FAIL;
			}
			if (player.getStackInHand(hand).getItem() == Items.ENDER_EYE) {
				return ActionResult.FAIL;
			}
			return ActionResult.PASS;
		});
	}
}