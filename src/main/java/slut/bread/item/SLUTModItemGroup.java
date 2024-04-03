package slut.bread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;
import slut.bread.block.SLUTModBlocks;

/**
 * 物品组类
 * 所有需要添加到物品组中的物品都在此类中添加。
 */
public class SLUTModItemGroup {
    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModItemGroup.class.getName());
    }

    // 创建物品组，使用物品 SLUTModItems.SLUT 作为图标
    public static final ItemGroup SLUT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SLUTMod.MOD_ID, "slut_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.slut_mod.slut_group")).
                    icon(() -> new ItemStack(SLUTModItems.SLUT)).entries((displayContext, entries) -> {
                        // 在此处将物品添加到物品组
                        entries.add(SLUTModItems.ZOM_1);
                        entries.add(SLUTModItems.ZOM_2);
                        entries.add(SLUTModItems.ZOM_3);
                        entries.add(SLUTModItems.ZOM_4);
                        entries.add(SLUTModItems.ZOM_5);
                        entries.add(SLUTModItems.ZOM_6);
                        entries.add(SLUTModItems.ZOM_7);
                        entries.add(SLUTModItems.ZOM_8);
                        entries.add(SLUTModItems.ZOM_9);
                        entries.add(SLUTModItems.SLUT);
                        entries.add(SLUTModBlocks.CARD_CASE_0);
                        entries.add(SLUTModBlocks.CARD_CASE_1);
                        entries.add(SLUTModBlocks.CARD_CASE_2);
                        entries.add(SLUTModItems.SIWANGZHIWU);
                        entries.add(SLUTModItems.JINGSHUILIUYONG);
                        entries.add(SLUTModItems.HUMOZHIZHANG);
                        entries.add(SLUTModItems.AOMO_MUSIC_DISC);
                        entries.add(SLUTModItems.WHITE_NIGHT_MUSIC_DISC);
                        entries.add(SLUTModItems.LAMENTATION_MUSIC_DISC);
                        entries.add(SLUTModItems.NEVER_ENDING_MUSIC_DISC);
                        entries.add(SLUTModItems.RONDEAU_DES_MUSIC_DISC);
                    }).build());

}
