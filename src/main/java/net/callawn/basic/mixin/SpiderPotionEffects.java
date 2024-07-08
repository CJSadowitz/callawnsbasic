package net.callawn.basic.mixin;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets="net/minecraft/entity/mob/SpiderEntity$SpiderData")
public class SpiderPotionEffects {
    @Inject(method="setEffect", at=@At("TAIL"))
    public void potioneffects(Random random, CallbackInfo ci) {
        SpiderEntity.SpiderData data = (SpiderEntity.SpiderData)(Object)this;
        data.effect = StatusEffects.SPEED;
    }
}
