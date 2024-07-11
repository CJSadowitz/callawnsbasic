package net.callawn.basic.mixin;


import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;


@Mixin(value= LivingEntity.class)
public interface LivingEntityAccessors {
    @Accessor("dead")
    void setDead(boolean dead);
}
