package slut.bread.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;

public class SLUTModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(SLUTMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CARD_LIST_ZOM = createTag("tag_card_list_zom");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(SLUTMod.MOD_ID, name));
        }
    }
}