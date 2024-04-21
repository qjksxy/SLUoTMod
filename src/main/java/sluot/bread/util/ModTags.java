package sluot.bread.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import sluot.bread.SLUoTMod;

/**
 * 为物品和方块添加标签，在代码中通过指定一个标签来指定一系列物品或方块。
 * 步骤：
 * 1. 在对应的类中创建 psf TagKey<> 常量
 * 2. 在 data/slut_mod/tags/ 中创建对应的 json 文件
 */
public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(SLUoTMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CARD_LIST = createTag("tag_card_list");
        public static final TagKey<Item> CARD_LIST_ZOM = createTag("tag_card_list_zom");
        public static final TagKey<Item> CARD_LIST_BOOK = createTag("tag_card_list_book");
        public static final TagKey<Item> CARD_LIST_FOCUS = createTag("tag_card_list_focus");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(SLUoTMod.MOD_ID, name));
        }
    }
}