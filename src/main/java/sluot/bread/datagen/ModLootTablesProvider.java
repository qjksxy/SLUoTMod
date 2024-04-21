package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import sluot.bread.block.ModBlocks;
import sluot.bread.util.ModTags;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {


    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        LootPool.Builder card_case_0_rolls = LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f));
        LootPool.Builder card_case_1_rolls = LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f));
        LootPool.Builder card_case_2_zom_rolls = LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f));
        LootPool.Builder card_case_2_book_rolls = LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f));
        LootPool.Builder card_case_2_focus_rolls = LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0f));

        card_case_0_rolls.with(TagEntry.expandBuilder(ModTags.Items.CARD_LIST));
        card_case_1_rolls.with(TagEntry.expandBuilder(ModTags.Items.CARD_LIST));
        card_case_2_zom_rolls.with(TagEntry.expandBuilder(ModTags.Items.CARD_LIST_ZOM));
        card_case_2_book_rolls.with(TagEntry.expandBuilder(ModTags.Items.CARD_LIST_BOOK));
        card_case_2_focus_rolls.with(TagEntry.expandBuilder(ModTags.Items.CARD_LIST_FOCUS));

        LootTable.Builder card_case_0_pool = LootTable.builder().pool(card_case_0_rolls);
        LootTable.Builder card_case_1_pool = LootTable.builder().pool(card_case_1_rolls);
        LootTable.Builder card_case_2_zom_pool = LootTable.builder().pool(card_case_2_zom_rolls);
        LootTable.Builder card_case_2_book_pool = LootTable.builder().pool(card_case_2_book_rolls);
        LootTable.Builder card_case_2_focus_pool = LootTable.builder().pool(card_case_2_focus_rolls);

        addDrop(ModBlocks.CARD_CASE_0, card_case_0_pool);
        addDrop(ModBlocks.CARD_CASE_1, card_case_1_pool);
        addDrop(ModBlocks.CARD_CASE_2_ZOM, card_case_2_zom_pool);
        addDrop(ModBlocks.CARD_CASE_2_BOOK, card_case_2_book_pool);
        addDrop(ModBlocks.CARD_CASE_2_FOCUS, card_case_2_focus_pool);

    }
}
