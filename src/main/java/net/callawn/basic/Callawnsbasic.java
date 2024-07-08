package net.callawn.basic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class Callawnsbasic implements ModInitializer {

	@Override
	public void onInitialize() {
		// fix paths
		WoodArmorItems.generateItems("..\\src\\main\\java\\net\\callawn\\basic\\armormaterials.csv",
				"..\\src\\main\\java\\net\\callawn\\basic\\armoritems.csv");
		// Remove the placement of anvil
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (player.getStackInHand(hand).getItem() == Items.ANVIL) {
				return ActionResult.FAIL;
			}
			return ActionResult.PASS;
		});
	}
}