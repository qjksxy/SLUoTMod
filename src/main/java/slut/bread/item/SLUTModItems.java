package slut.bread.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;


// 在此类中定义所有的物品（Items）
public class SLUTModItems {
    // 在 SLUTMod.onInitialize() 方法中调用以加载此类
    public static void registerClass() {
        SLUTMod.LOGGER.debug("Registering mod items for" + SLUTMod.MOD_ID);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(SLUTMod.MOD_ID, name), item);
    }

    // 在下处添加物品
    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()));
}
