package net.callawn.basic.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(targets="net/minecraft/entity/mob/PhantomEntity")
public abstract class PhantomMoveControlMixin {


    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        PhantomEntity phantom = (PhantomEntity)(Object)this;

        // Get the world the Phantom is in
        World world = phantom.getWorld();

        // Get the Phantom's current position
        BlockPos phantomLocation = phantom.getBlockPos();

        // Initialize a variable to keep track of the nearest light source
        BlockPos nearestLightSource = null;
        double nearestDistance = Double.MAX_VALUE;

        // Check for light sources within a certain range
        for (int dx = -16; dx <= 16; dx++) {
            for (int dy = -16; dy <= 16; dy++) {
                for (int dz = -16; dz <= 16; dz++) {
                    BlockPos checkPos = phantomLocation.add(dx, dy, dz);
                    BlockState state = world.getBlockState(checkPos);

                    // If the block is a light source, check if it's the nearest one
                    if (state.getLuminance() > 0.2) {
                        double distance = checkPos.getSquaredDistance(phantomLocation);
                        if (distance < nearestDistance) {
                            nearestLightSource = checkPos;
                            nearestDistance = distance;
                        }
                    }
                }
            }
        }
        if (nearestLightSource != null) {
            phantom.getMoveControl().moveTo(nearestLightSource.getX(), nearestLightSource.getY(),
                    nearestLightSource.getZ(), 1.0);
            if (phantomLocation.isWithinDistance(nearestLightSource, 2.0)) {
                world.breakBlock(nearestLightSource, true);
            }
        }
    }
}
