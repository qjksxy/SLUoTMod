package slut.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;
import slut.bread.item.SLUTModItems;
import slut.bread.util.SLUTModTags;

import java.util.concurrent.CompletableFuture;

public class SLUTModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public SLUTModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    public SLUTModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SLUTModTags.Items.CARD_LIST_ZOM)
                .add(SLUTModItems.ZOM_1)
                .add(SLUTModItems.ZOM_2)
                .add(SLUTModItems.ZOM_3)
                .add(SLUTModItems.ZOM_4)
                .add(SLUTModItems.ZOM_5)
                .add(SLUTModItems.ZOM_6)
                .add(SLUTModItems.ZOM_7)
                .add(SLUTModItems.ZOM_8)
                .add(SLUTModItems.ZOM_9);

    }
}
