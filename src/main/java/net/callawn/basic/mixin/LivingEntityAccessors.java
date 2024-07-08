package net.callawn.basic.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;


@Mixin(targets="net/minecraft/entity/LivingEntity")
public interface LivingEntityAccessors {
    @Accessor("dead")
    void setDead(boolean dead);
}
