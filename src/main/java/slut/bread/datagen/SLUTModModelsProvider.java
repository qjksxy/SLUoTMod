package slut.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import slut.bread.block.SLUTModBlocks;
import slut.bread.item.SLUTModItems;

public class SLUTModModelsProvider extends FabricModelProvider {
    public SLUTModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // FIXME 没有生成对应的 models/item 文件，目前需要手动添加
        blockStateModelGenerator.registerSimpleCubeAll(SLUTModBlocks.CARD_CASE_0);
        blockStateModelGenerator.registerSimpleCubeAll(SLUTModBlocks.CARD_CASE_1);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SLUTModItems.SLUT, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_1, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_2, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_3, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_4, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_5, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_6, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_7, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_8, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.ZOM_9, Models.GENERATED);
        itemModelGenerator.register(SLUTModItems.JINGSHUILIUYONG, Models.HANDHELD);
        itemModelGenerator.register(SLUTModItems.HUMOZHIZHANG, Models.HANDHELD);
        itemModelGenerator.register(SLUTModItems.SIWANGZHIWU, Models.HANDHELD);
    }
}
