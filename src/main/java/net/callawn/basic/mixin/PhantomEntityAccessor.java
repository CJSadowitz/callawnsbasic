package net.callawn.basic.mixin;

import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value= PhantomEntity.class)
public interface PhantomEntityAccessor {
    @Accessor("targetPosition")
    Vec3d getTargetPosition();

    @Mutable
    @Accessor("targetPosition")
    void setTargetPosition(Vec3d value);


}
