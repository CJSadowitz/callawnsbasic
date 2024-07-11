package net.callawn.basic.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value=ZombieEntity.class)
public class ZombieBuff {

    @Inject(method="createZombieAttributes", at=@At("RETURN"), remap = false, cancellable = true)
    private static void buffSpeed(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.setReturnValue(HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 70.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ARMOR, 4.0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS));
    }

    @Inject(method="initEquipment", at=@At("TAIL"))
    public void spawnWeaponBuff(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {

        ZombieEntity zombie = (ZombieEntity)(Object)this;
        if (localDifficulty.getClampedLocalDifficulty() <= 10.0) {
            zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        }
        else {
            zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
            zombie.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.DIAMOND_SWORD));
        }
    }
}
