package net.callawn.basic.mixin;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.*;
import net.minecraft.structure.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.OceanMonumentStructure;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.List;
import static com.mojang.text2speech.Narrator.LOGGER;

@Mixin(value=StructureStart.class)
public class RemoveVillages {

    @Shadow public static final StructureStart DEFAULT = new StructureStart(null, new ChunkPos(0, 0), 0, new StructurePiecesList(List.of()));
    @Inject(method="fromNbt", at=@At("HEAD"), cancellable = true)
    private static void remove(StructureContext context, NbtCompound nbt, long seed, CallbackInfoReturnable<StructureStart> cir) {
        String string = nbt.getString("id");
        if ("INVALID".equals(string)) {
            cir.setReturnValue(DEFAULT);
        } else {
            Registry<Structure> registry = context.registryManager().get(RegistryKeys.STRUCTURE);
            Structure structure = registry.get(Identifier.of(string));
            if (structure == null || structure == registry.get(Identifier.of("village_desert")) ||
                    structure == registry.get(Identifier.of("village_plains")) ||
                    structure == registry.get(Identifier.of("village_snowy")) ||
                    structure == registry.get(Identifier.of("village_savanna")) ||
                    structure == registry.get(Identifier.of("village_taiga"))) {
                LOGGER.error("Unknown stucture id: {}", string);
                cir.setReturnValue(null);
            } else {
                ChunkPos chunkPos = new ChunkPos(nbt.getInt("ChunkX"), nbt.getInt("ChunkZ"));
                int i = nbt.getInt("references");
                NbtList nbtList = nbt.getList("Children", NbtElement.COMPOUND_TYPE);

                try {
                    StructurePiecesList structurePiecesList = StructurePiecesList.fromNbt(nbtList, context);
                    if (structure instanceof OceanMonumentStructure) {
                        structurePiecesList = OceanMonumentStructure.modifyPiecesOnRead(chunkPos, seed, structurePiecesList);
                    }

                    cir.setReturnValue(new StructureStart(structure, chunkPos, i, structurePiecesList));
                } catch (Exception var11) {
                    LOGGER.error("Failed Start with id {}", string, var11);
                    cir.setReturnValue(null);
                }
            }
        }
    }
}
