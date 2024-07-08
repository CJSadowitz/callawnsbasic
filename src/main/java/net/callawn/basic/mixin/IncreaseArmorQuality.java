package net.callawn.basic.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.entity.mob.MobEntity.getEquipmentForSlot;

@Mixin(targets="net/minecraft/entity/mob/MobEntity")
public abstract class IncreaseArmorQuality {

    @Inject(method="initEquipment", at=@At("TAIL"))
    public void increase_quality(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {

        MobEntity mob_entity = (MobEntity)(Object)this;

        if (random.nextFloat() < localDifficulty.getClampedLocalDifficulty()) {

            for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    ItemStack itemStack = mob_entity.getEquippedStack(equipmentSlot);
                    if (itemStack.isEmpty()) {
                        Item item = getEquipmentForSlot(equipmentSlot, 4);
                        if (item != null) {
                            mob_entity.equipStack(equipmentSlot, new ItemStack(item));
                        }
                    }
                }
            }
        }
    }
}
