package net.callawn.basic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets="net/minecraft/entity/mob/PhantomEntity$FindTargetGoal")
public class FindTargetGoalMixin {
    @Inject(method = "canStart", at = @At("HEAD"), cancellable = true)
    private void canStart(CallbackInfoReturnable<Boolean> cir) {
        // Prevent the phantom from targeting anything needs to be fixed
        cir.setReturnValue(false);
    }
}
