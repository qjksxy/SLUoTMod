package slut.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import slut.bread.item.ModItems;
import slut.bread.util.SLUTModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SLUTModTags.Items.CARD_LIST_ZOM)
                .add(ModItems.ZOM_1)
                .add(ModItems.ZOM_2)
                .add(ModItems.ZOM_3)
                .add(ModItems.ZOM_4)
                .add(ModItems.ZOM_5)
                .add(ModItems.ZOM_6)
                .add(ModItems.ZOM_7)
                .add(ModItems.ZOM_8)
                .add(ModItems.ZOM_9);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.AOMO_MUSIC_DISC)
                .add(ModItems.WHITE_NIGHT_MUSIC_DISC)
                .add(ModItems.LAMENTATION_MUSIC_DISC)
                .add(ModItems.NEVER_ENDING_MUSIC_DISC)
                .add(ModItems.RONDEAU_DES_MUSIC_DISC);
    }
}
