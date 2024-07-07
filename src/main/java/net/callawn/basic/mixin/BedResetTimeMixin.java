package net.callawn.basic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets= "net/minecraft/entity/player/PlayerEntity")
public class BedResetTimeMixin {
    //change can reset time by sleeping and just set it to false :)
    @Inject(method = "canResetTimeBySleeping", at = @At("HEAD"), cancellable = true)
    private void removeSleeping(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}