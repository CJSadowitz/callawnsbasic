package net.callawn.basic.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.entity.mob.MobEntity.getEquipmentForSlot;

@Mixin(value=MobEntity.class)
public abstract class MobBuffs {

    @Inject(method="initEquipment", at=@At("TAIL"))
    public void increase_quality(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {

        MobEntity mob_entity = (MobEntity)(Object)this;

        if (random.nextFloat() < localDifficulty.getClampedLocalDifficulty()) {

            for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    ItemStack itemStack = mob_entity.getEquippedStack(equipmentSlot);
                    if (itemStack.isEmpty()) {
                        if (localDifficulty.getLocalDifficulty() >= 5) {
                            Item item = getEquipmentForSlot(equipmentSlot, 2);
                            if (item != null) {
                                mob_entity.equipStack(equipmentSlot, new ItemStack(item));
                            }
                        }
                        else if (localDifficulty.getLocalDifficulty() >= 10) {
                            Item item = getEquipmentForSlot(equipmentSlot, 3);
                            if (item != null) {
                                mob_entity.equipStack(equipmentSlot, new ItemStack(item));
                            }
                        }
                        else if (localDifficulty.getLocalDifficulty() >= 20) {
                            Item item = getEquipmentForSlot(equipmentSlot, 4);
                            if (item != null) {
                                mob_entity.equipStack(equipmentSlot, new ItemStack(item));
                            }
                        }
                        else {
                            Item item = getEquipmentForSlot(equipmentSlot, 1);
                            if (item != null) {
                                mob_entity.equipStack(equipmentSlot, new ItemStack(item));
                            }
                        }
                    }
                }
            }
        }
    }
    @Inject(method="getLimitPerChunk", at=@At("RETURN"), cancellable = true)
    public void increase_spawns_per_chunk(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(10);
    }
    @Inject(method="canBeLeashed", at=@At("RETURN"), cancellable = true)
    public void all_mobs_leashed(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
