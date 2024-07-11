package net.callawn.basic.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.block.BlockState;

@Mixin(value= LivingEntity.class)
public class MobTargets {
    @Inject(method="canTarget(Lnet/minecraft/entity/LivingEntity;)Z", at=@At("RETURN"), cancellable = true)
    public void add_light(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity obj = (LivingEntity)(Object)this;

        boolean source = (!(target instanceof PlayerEntity) || obj.getWorld().getDifficulty() != Difficulty.PEACEFUL) && target.canTakeDamage();
        // Get a chunk around the entity, if there is a light, attack it
        BlockPos entityPos = obj.getBlockPos();
        for (int dx = -16; dx <= 16; dx++) {
            for (int dy = -16; dy <= 16; dy++) {
                for (int dz = -16; dz <= 16; dz++) {
                BlockState checkPos = obj.getWorld().getBlockState(entityPos.add(dx, dy, dz));
                if ((obj.getWorld().getBlockState(obj.getBlockPos()).getLuminance() > checkPos.getLuminance())) {
                    cir.setReturnValue(true);
                    }
                }
            }
        }
        cir.setReturnValue(source);
    }
}
