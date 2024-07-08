package net.callawn.basic.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets="net/minecraft/entity/mob/CreeperEntity")
public class CreeperBuff {

    @Shadow
    private int explosionRadius;

    @Inject(method="explode()V", at=@At("HEAD"))
    public void increase_explosion_range(CallbackInfo ci) {

        CreeperEntity creeper = (CreeperEntity)(Object)this;

        if (!creeper.getWorld().isClient) {
            float f = creeper.shouldRenderOverlay() ? 2.0F : 1.0F;
            ((LivingEntityAccessors)this).setDead(true);
            creeper.getWorld().createExplosion(creeper, creeper.getX(), creeper.getY(), creeper.getZ(), (float)explosionRadius * f * 4, World.ExplosionSourceType.MOB);
            ((CreeperEntityInvoker)this).invokeSpawnEffectsCloud();
            creeper.discard();
        }
        return;
    }
}

