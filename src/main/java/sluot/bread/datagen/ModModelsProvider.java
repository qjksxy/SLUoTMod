package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import sluot.bread.block.ModBlocks;
import sluot.bread.item.ModItems;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // FIXME 没有生成对应的 models/item 文件，目前需要手动添加
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_0);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_2);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SLUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_4, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_5, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_6, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_7, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_8, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZOM_9, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_4, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_5, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_6, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_7, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_8, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOK_9, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_4, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_5, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_6, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_7, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_8, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOCUS_9, Models.GENERATED);
        itemModelGenerator.register(ModItems.JINGSHUILIUYONG, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HUMOZHIZHANG, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SIWANGZHIWU, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AOMO_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_NIGHT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAMENTATION_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEVER_ENDING_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.RONDEAU_DES_MUSIC_DISC, Models.GENERATED);
    }
}
