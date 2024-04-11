package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import sluot.bread.item.ModItems;
import sluot.bread.util.SLUTModTags;

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
        Item[] card_items = {
                ModItems.ZOM_1, ModItems.ZOM_2, ModItems.ZOM_3,
                ModItems.ZOM_4, ModItems.ZOM_5, ModItems.ZOM_6,
                ModItems.ZOM_7, ModItems.ZOM_8, ModItems.ZOM_9,
                ModItems.BOOK_1, ModItems.BOOK_2, ModItems.BOOK_3,
                ModItems.BOOK_4, ModItems.BOOK_5, ModItems.BOOK_6,
                ModItems.BOOK_7, ModItems.BOOK_8, ModItems.BOOK_9,
                ModItems.FOCUS_1, ModItems.FOCUS_2, ModItems.FOCUS_3,
                ModItems.FOCUS_4, ModItems.FOCUS_5, ModItems.FOCUS_6,
                ModItems.FOCUS_7, ModItems.FOCUS_8, ModItems.FOCUS_9
        };
        FabricTagProvider<Item>.FabricTagBuilder card_tag = getOrCreateTagBuilder(SLUTModTags.Items.CARD_LIST);
        for (Item item : card_items) {
            card_tag.add(item);
        }
        Item[] disc_items = {
                ModItems.AOMO_MUSIC_DISC, ModItems.WHITE_NIGHT_MUSIC_DISC,
                ModItems.LAMENTATION_MUSIC_DISC, ModItems.NEVER_ENDING_MUSIC_DISC,
                ModItems.RONDEAU_DES_MUSIC_DISC
        };
        FabricTagProvider<Item>.FabricTagBuilder disc_tag = getOrCreateTagBuilder(ItemTags.MUSIC_DISCS);
        for (Item item : disc_items) {
            disc_tag.add(item);
        }
    }
}
