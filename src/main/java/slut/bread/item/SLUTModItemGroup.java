package slut.bread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;

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
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.slutmod.slut_group")).
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
                        entries.add(SLUTModItems.CITRINE);
                        entries.add(SLUTModItems.SLUT);
                    }).build());

}
