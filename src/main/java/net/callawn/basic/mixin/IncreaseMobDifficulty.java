package net.callawn.basic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets="net/minecraft/world/LocalDifficulty")
public abstract class IncreaseMobDifficulty {
    @Shadow public abstract float getLocalDifficulty();

    // Local difficult now scales ridiculously
    @Inject(method="getClampedLocalDifficulty", at=@At("RETURN"), cancellable = true)
    public void uncapDifficulty(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(getLocalDifficulty() * 2.0f);
    }
}


