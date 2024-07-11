package net.callawn.basic.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.random.RandomGenerator;


@Mixin(targets="net/minecraft/entity/mob/PhantomEntity")
public class PhantomMoveControlMixin {

    @Inject(method="tick", at=@At("HEAD"))
    public void change_target_selection(CallbackInfo ci) {
        PhantomEntity phantom = (PhantomEntity)(Object)this;
        PhantomEntityAccessor accessor = (PhantomEntityAccessor)phantom;
        // Get target Position in ref
        BlockPos phantomLocation = phantom.getBlockPos();
        for (int dx = -16; dx <= 16; dx++) {
            for (int dy = -16; dy <= 16; dy++) {
                for (int dz = -16; dz <= 16; dz++) {
                    // get block position and check the state of the block (if it's a light)
                    BlockPos checkPos = phantomLocation.add(dx, dy, dz);
                    BlockState state = phantom.getWorld().getBlockState(checkPos);
                    if (state.getLuminance() > 0.2) {
                        accessor.setTargetPosition(checkPos.toCenterPos());
                        System.out.println("Set target Position to light source");

                        if (checkPos != null) {
                        // Check if it's close to the light source
                          if (phantomLocation.isWithinDistance(checkPos, 2.0)) {
                              // break the block
                              phantom.getWorld().breakBlock(checkPos, true);
                              accessor.setTargetPosition(Vec3d.ZERO);
                           }
                          }
                    }
                }
            }
        }
    }


// Set Target position of Phantom to be a light source
    // Method: PhantomEntity.SwoopMovementGoal.tick
    // set target position to that of the light source
    // remove the target of living entities known as player


//
//    // This is not the desired behavior. I would like to see a circle and swoop on the light sources not attacking players
//    @Inject(method = "tickMovement", at = @At("HEAD"))
//    private void tick(CallbackInfo ci) {
//        PhantomEntity phantom = (PhantomEntity)(Object)this;
//
//        // Get the world the Phantom is in
//        World world = phantom.getWorld();
//
//        // Get the Phantom's current position
//        BlockPos phantomLocation = phantom.getBlockPos();
//
//        // Initialize a variable to keep track of the nearest light source
//        BlockPos nearestLightSource = null;
//        double nearestDistance = Double.MAX_VALUE;
//
//        // Check for light sources within a certain range
//        for (int dx = -16; dx <= 16; dx++) {
//            for (int dy = -16; dy <= 16; dy++) {
//                for (int dz = -16; dz <= 16; dz++) {
//                    BlockPos checkPos = phantomLocation.add(dx, dy, dz);
//                    BlockState state = world.getBlockState(checkPos);
//
//                    // If the block is a light source, check if it's the nearest one
//                    if (state.getLuminance() > 0.2) {
//                        double distance = checkPos.getSquaredDistance(phantomLocation);
//                        if (distance < nearestDistance) {
//                            nearestLightSource = checkPos;
//                            nearestDistance = distance;
//                        }
//                    }
//                }
//            }
//        }
//        if (nearestLightSource != null) {
//            phantom.getMoveControl().moveTo(nearestLightSource.getX(), nearestLightSource.getY(),
//                    nearestLightSource.getZ(), 3.0);
//            if (phantomLocation.isWithinDistance(nearestLightSource, 2.0)) {
//                world.breakBlock(nearestLightSource, true);
//            }
//        }
//    }
}
