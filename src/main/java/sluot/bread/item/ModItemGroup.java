package sluot.bread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
                    icon(() -> new ItemStack(ModItems.SLUT)).entries((displayContext, entries) -> {
                        // 在此处将物品添加到物品组
                        entries.add(ModItems.ZOM_1);
                        entries.add(ModItems.ZOM_2);
                        entries.add(ModItems.ZOM_3);
                        entries.add(ModItems.ZOM_4);
                        entries.add(ModItems.ZOM_5);
                        entries.add(ModItems.ZOM_6);
                        entries.add(ModItems.ZOM_7);
                        entries.add(ModItems.ZOM_8);
                        entries.add(ModItems.ZOM_9);
                        entries.add(ModItems.SLUT);
                        entries.add(ModBlocks.CARD_CASE_0);
                        entries.add(ModBlocks.CARD_CASE_1);
                        entries.add(ModBlocks.CARD_CASE_2);
                        entries.add(ModItems.SIWANGZHIWU);
                        entries.add(ModItems.JINGSHUILIUYONG);
                        entries.add(ModItems.HUMOZHIZHANG);
                        entries.add(ModItems.AOMO_MUSIC_DISC);
                        entries.add(ModItems.WHITE_NIGHT_MUSIC_DISC);
                        entries.add(ModItems.LAMENTATION_MUSIC_DISC);
                        entries.add(ModItems.NEVER_ENDING_MUSIC_DISC);
                        entries.add(ModItems.RONDEAU_DES_MUSIC_DISC);
                    }).build());

}
