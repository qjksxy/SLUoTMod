package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_2_ZOM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_2_BOOK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARD_CASE_2_FOCUS);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SLUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        for (Item item : ModItems.JINGSHUI_ITEMS) {
            itemModelGenerator.register(item, Models.HANDHELD);
        }
        for (Item item : ModItems.HUMO_ITEMS) {
            itemModelGenerator.register(item, Models.HANDHELD);
        }
        for (Item item : ModItems.SIWANG_ITEMS) {
            itemModelGenerator.register(item, Models.HANDHELD);
        }
        for (Item item : ModItems.MUSIC_DISC_ITEMS) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
        for (Item item : ModItems.CARD_ITEMS_BOOK) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
        for (Item item : ModItems.CARD_ITEMS_ZOM) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
        for (Item item : ModItems.CARD_ITEMS_FOCUS) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
