package slut.bread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;

public class SLUTModItemGroup {
    public static void registerClass() {
        SLUTMod.LOGGER.debug("Registering mod item group for" + SLUTMod.MOD_ID);
    }

    public static final ItemGroup SLUT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SLUTMod.MOD_ID, "slut_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.slutmod.slut_group")).
                    icon(() -> new ItemStack(SLUTModItems.CITRINE)).entries((displayContext, entries) -> {
                        // 在下处列出需要添加到此物品栏内的物品
                        entries.add(SLUTModItems.CITRINE);
                    }).build());

}
