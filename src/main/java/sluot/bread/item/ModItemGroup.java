package sluot.bread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sluot.bread.SLUoTMod;
import sluot.bread.block.ModBlocks;

/**
 * 物品组类
 * 所有需要添加到物品组中的物品都在此类中添加。
 */
public class ModItemGroup {
    public static void registerClass() {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "-Registering class: " + ModItemGroup.class.getName());
    }

    // 创建物品组，使用物品 SLUTModItems.SLUT 作为图标
    public static final ItemGroup SLUT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SLUoTMod.MOD_ID, "sluot_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.sluot_mod.sluot_group")).
                    icon(() -> new ItemStack(ModItems.SLUOT)).entries((displayContext, entries) -> {
                        // 在此处将物品添加到物品组
                        entries.add(ModItems.SLUOT);
                        entries.add(ModBlocks.CARD_CASE_0);
                        entries.add(ModBlocks.CARD_CASE_1);
                        entries.add(ModBlocks.CARD_CASE_2_ZOM);
                        entries.add(ModBlocks.CARD_CASE_2_BOOK);
                        entries.add(ModBlocks.CARD_CASE_2_FOCUS);
                        entries.add(ModItems.SIWANG_ITEMS.get(0));
                        entries.add(ModItems.JINGSHUI_ITEMS.get(0));
                        entries.add(ModItems.HUMO_ITEMS.get(0));
                        for (Item item : ModItems.MUSIC_DISC_ITEMS) {
                            entries.add(item);
                        }
                        for (Item item : ModItems.CARD_ITEMS_ZOM) {
                            entries.add(item);
                        }
                        for (Item item : ModItems.CARD_ITEMS_BOOK) {
                            entries.add(item);
                        }
                        for (Item item : ModItems.CARD_ITEMS_FOCUS) {
                            entries.add(item);
                        }
                    }).build());

}
