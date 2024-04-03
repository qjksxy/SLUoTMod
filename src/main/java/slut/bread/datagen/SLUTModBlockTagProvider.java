package slut.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import slut.bread.block.SLUTModBlocks;
import slut.bread.item.SLUTModItems;

import java.util.concurrent.CompletableFuture;

public class SLUTModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SLUTModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // 在标签中添加原版物品：.forceAddTag()
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(SLUTModBlocks.CARD_CASE_0)
                .add(SLUTModBlocks.CARD_CASE_1)
                .add(SLUTModBlocks.CARD_CASE_2);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(SLUTModBlocks.CARD_CASE_0)
                .add(SLUTModBlocks.CARD_CASE_1)
                .add(SLUTModBlocks.CARD_CASE_2);
    }
}
