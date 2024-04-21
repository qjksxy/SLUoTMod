package sluot.bread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import sluot.bread.block.ModBlocks;
import sluot.bread.item.ModItems;
import sluot.bread.util.ModTags;

import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLUT)
                .input(Items.IRON_INGOT)
                .input(Items.EGG)
                .input(Blocks.CHERRY_LOG)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder humoRecipe = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HUMO_ITEMS.get(0));
        ShapelessRecipeJsonBuilder jingshuiRecipe = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JINGSHUI_ITEMS.get(0));
        ShapelessRecipeJsonBuilder siwangRecipe = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SIWANG_ITEMS.get(0));
        for (int i = 0; i < 9; i++) {
            humoRecipe.input(ModItems.CARD_ITEMS_FOCUS.get(i));
            jingshuiRecipe.input(ModItems.CARD_ITEMS_BOOK.get(i));
            siwangRecipe.input(ModItems.CARD_ITEMS_ZOM.get(i));
        }

        humoRecipe.criterion(FabricRecipeProvider.hasItem(ModItems.CARD_ITEMS_FOCUS.get(0)),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CARD_ITEMS_FOCUS.get(0)))
                .offerTo(exporter);
        jingshuiRecipe.criterion(FabricRecipeProvider.hasItem(ModItems.CARD_ITEMS_BOOK.get(0)),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CARD_ITEMS_BOOK.get(0)))
                .offerTo(exporter);
        siwangRecipe.criterion(FabricRecipeProvider.hasItem(ModItems.CARD_ITEMS_ZOM.get(0)),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CARD_ITEMS_ZOM.get(0)))
                .offerTo(exporter);


        // 武器精炼配方
        for (int i = 1; i < 5; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HUMO_ITEMS.get(i))
                    .input(ModItems.HUMO_ITEMS.get(0))
                    .input(ModItems.HUMO_ITEMS.get(i - 1))
                    .criterion(FabricRecipeProvider.hasItem(ModItems.HUMO_ITEMS.get(i - 1)),
                            FabricRecipeProvider.conditionsFromItem(ModItems.HUMO_ITEMS.get(i - 1)))
                    .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JINGSHUI_ITEMS.get(i))
                    .input(ModItems.JINGSHUI_ITEMS.get(0))
                    .input(ModItems.JINGSHUI_ITEMS.get(i - 1))
                    .criterion(FabricRecipeProvider.hasItem(ModItems.JINGSHUI_ITEMS.get(i - 1)),
                            FabricRecipeProvider.conditionsFromItem(ModItems.JINGSHUI_ITEMS.get(i - 1)))
                    .offerTo(exporter);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SIWANG_ITEMS.get(i))
                    .input(ModItems.SIWANG_ITEMS.get(0))
                    .input(ModItems.SIWANG_ITEMS.get(i - 1))
                    .criterion(FabricRecipeProvider.hasItem(ModItems.SIWANG_ITEMS.get(i - 1)),
                            FabricRecipeProvider.conditionsFromItem(ModItems.SIWANG_ITEMS.get(i - 1)))
                    .offerTo(exporter);

        }

        // 牌盒的合成配方
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CARD_CASE_0)
                .pattern("WWW")
                .pattern("WRW")
                .input('W', Blocks.COPPER_BLOCK)
                .input('R', ModItems.SLUT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SLUT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SLUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CARD_CASE_1)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WRW")
                .input('X', ModTags.Items.CARD_LIST)
                .input('W', Blocks.COPPER_BLOCK)
                .input('R', ModItems.SLUT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SLUT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SLUT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CARD_CASE_2_BOOK)
                .pattern("XXX")
                .pattern("WWW")
                .pattern("WRW")
                .input('X', ModTags.Items.CARD_LIST_BOOK)
                .input('W', Blocks.COPPER_BLOCK)
                .input('R', ModItems.SLUT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SLUT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SLUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CARD_CASE_2_FOCUS)
                .pattern("XXX")
                .pattern("WWW")
                .pattern("WRW")
                .input('X', ModTags.Items.CARD_LIST_FOCUS)
                .input('W', Blocks.COPPER_BLOCK)
                .input('R', ModItems.SLUT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SLUT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SLUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CARD_CASE_2_ZOM)
                .pattern("XXX")
                .pattern("WWW")
                .pattern("WRW")
                .input('X', ModTags.Items.CARD_LIST_ZOM)
                .input('W', Blocks.COPPER_BLOCK)
                .input('R', ModItems.SLUT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SLUT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SLUT))
                .offerTo(exporter);
    }
}
