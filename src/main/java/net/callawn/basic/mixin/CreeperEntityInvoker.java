package net.callawn.basic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(targets="net/minecraft/entity/mob/CreeperEntity")
public interface CreeperEntityInvoker {
    @Invoker("spawnEffectsCloud")
    void invokeSpawnEffectsCloud();
}
