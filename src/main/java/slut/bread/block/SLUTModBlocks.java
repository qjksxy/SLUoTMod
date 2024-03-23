package slut.bread.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;

public class SLUTModBlocks {
    public static final Block CARD_CASE_0 = registerBlock("block_card_case_0",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(SLUTMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SLUTMod.MOD_ID, name), block);
    }
    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModBlocks.class.getName());
    }


}
