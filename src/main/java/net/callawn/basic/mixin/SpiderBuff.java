package net.callawn.basic.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value=SpiderEntity.class)
public class SpiderBuff {

    @Inject(method="initialize", at=@At("RETURN"), cancellable = true)
    public void spider_jockey_and_potion_effects(ServerWorldAccess world,
                                                 LocalDifficulty difficulty,
                                                 SpawnReason spawnReason,
                                                 EntityData entityData,
                                                 CallbackInfoReturnable<EntityData> cir){

        SpiderEntity spider = (SpiderEntity)(Object)this;

        if (difficulty.getLocalDifficulty() >= 10) {
            SkeletonEntity skeletonEntity = EntityType.SKELETON.create(spider.getWorld());
            if (skeletonEntity != null) {
                skeletonEntity.refreshPositionAndAngles(spider.getX(), spider.getY(), spider.getZ(), spider.getYaw(), 0.0F);
                skeletonEntity.initialize(world, difficulty, spawnReason, null);
                skeletonEntity.startRiding(spider);
            }
        }
        else if (difficulty.getLocalDifficulty() >= 15) {
            SkeletonEntity skeletonEntity = EntityType.SKELETON.create(spider.getWorld());
            if (skeletonEntity != null) {
                skeletonEntity.refreshPositionAndAngles(spider.getX(), spider.getY(), spider.getZ(), spider.getYaw(), 0.0F);
                skeletonEntity.initialize(world, difficulty, spawnReason, null);
                skeletonEntity.startRiding(spider);
            }
        }
        entityData = new SpiderEntity.SpiderData();
        Random random = world.getRandom();
        ((SpiderEntity.SpiderData)entityData).setEffect(random);
        if (entityData instanceof SpiderEntity.SpiderData spiderData) {
            RegistryEntry<StatusEffect> registryEntry = spiderData.effect;
            if (registryEntry != null) {
                spider.addStatusEffect(new StatusEffectInstance(registryEntry, -1));
            }
        }
        cir.setReturnValue(entityData);
    }
}
