package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import sluot.bread.item.ModItems;
import sluot.bread.util.ModTags;

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
        FabricTagProvider<Item>.FabricTagBuilder card_tag = getOrCreateTagBuilder(ModTags.Items.CARD_LIST);
        for (Item item : ModItems.CARD_ITEMS_ZOM) {
            card_tag.add(item);
        }
        for (Item item : ModItems.CARD_ITEMS_BOOK) {
            card_tag.add(item);
        }
        for (Item item : ModItems.CARD_ITEMS_FOCUS) {
            card_tag.add(item);
        }
        FabricTagProvider<Item>.FabricTagBuilder zom_card_tag = getOrCreateTagBuilder(ModTags.Items.CARD_LIST_ZOM);
        for (Item item : ModItems.CARD_ITEMS_ZOM) {
            zom_card_tag.add(item);
        }
        FabricTagProvider<Item>.FabricTagBuilder book_card_tag = getOrCreateTagBuilder(ModTags.Items.CARD_LIST_BOOK);
        for (Item item : ModItems.CARD_ITEMS_BOOK) {
            book_card_tag.add(item);
        }
        FabricTagProvider<Item>.FabricTagBuilder focus_card_tag = getOrCreateTagBuilder(ModTags.Items.CARD_LIST_FOCUS);
        for (Item item : ModItems.CARD_ITEMS_FOCUS) {
            focus_card_tag.add(item);
        }
        // 唱片标签
        FabricTagProvider<Item>.FabricTagBuilder disc_tag = getOrCreateTagBuilder(ItemTags.MUSIC_DISCS);
        for (Item item : ModItems.MUSIC_DISC_ITEMS) {
            disc_tag.add(item);
        }
    }
}
