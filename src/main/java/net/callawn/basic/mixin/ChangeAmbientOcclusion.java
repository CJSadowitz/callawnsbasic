package net.callawn.basic.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets="net/minecraft/block/AbstractBlock")
public class ChangeAmbientOcclusion {
    @Inject(method="getAmbientOcclusionLightLevel",at=@At("RETURN"), cancellable = true)
    public void lowerLightLevel(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(state.isFullCube(world, pos) ? 0.1F : 1.0F);
    }
}
