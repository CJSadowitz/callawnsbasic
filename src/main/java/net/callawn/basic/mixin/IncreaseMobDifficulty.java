package net.callawn.basic.mixin;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value=LocalDifficulty.class)
public abstract class IncreaseMobDifficulty {
    @Shadow public abstract float getLocalDifficulty();
    // Local difficult now scales ridiculously
    @Inject(method="getClampedLocalDifficulty", at=@At("RETURN"), cancellable = true)
    public void uncapDifficulty(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(getLocalDifficulty() * 8.0f);
    }
    @Inject(method="setLocalDifficulty", at=@At("HEAD"), cancellable = true)
    public void increaseLocalDifficulty(Difficulty difficulty, long timeOfDay, long inhabitedTime, float moonSize, CallbackInfoReturnable<Float> cir) {
        if (difficulty == Difficulty.PEACEFUL) {
            cir.setReturnValue(0.0F);
        } else {
            boolean bl = difficulty == Difficulty.HARD;
            float f = 0.75F;
            float g = MathHelper.clamp(((float)timeOfDay + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.75F;
            f += g;
            float h = 2.0F;
            h += MathHelper.clamp((float)inhabitedTime / 36000.0F, 0.0F, 10.0F) * (bl ? 1.0F : 0.25F);
            h += MathHelper.clamp(moonSize * 4.0F, 0.0F, g);

            f += h;
            cir.setReturnValue( (float)difficulty.getId() * f);
        }
        cir.cancel();
    }
}


