package net.callawn.basic.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.CreeperIgniteGoal;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= CreeperIgniteGoal.class)
public abstract class CreeperRangeBuff {
    @Final @Shadow private CreeperEntity creeper;

    @Inject(method="canStart", at=@At("RETURN"), cancellable = true)
    public void increase_range(CallbackInfoReturnable<Boolean> cir){
        LivingEntity livingEntity = creeper.getTarget();
        cir.setReturnValue(creeper.getFuseSpeed() > 0 || livingEntity != null && creeper.squaredDistanceTo(livingEntity) < 50.0);
    }
}
