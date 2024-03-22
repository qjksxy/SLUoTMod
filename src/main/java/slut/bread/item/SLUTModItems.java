package slut.bread.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;


/**
 * 在此类中定义所有的物品（Items）<br>
 * 添加物品步骤：<br><b>注意：避免 name 以及相关文件名大写</b><br>
 * 1. 在下处创建 public static final Item 对象<br>
 * 2. 在类 SLUTModItemGroup 中，将物品添加到合适的物品组中<br>
 * 3. 在 resources/.../lang 中，添加对应语言文件<br>
 * 4. 在 resources/.../models/item 中，创建说明文件<br>
 * 5. 在 resources/.../textures/item 中，创建材质图片
 */
public class SLUTModItems {
    // 在 SLUTMod.onInitialize() 方法中调用以加载此类
    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModItems.class.getName());
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(SLUTMod.MOD_ID, name), item);
    }

    // 黄水晶 万能的黄水晶，只能通过创造模式获得，可以用来合成其他材料
    public static final Item CITRINE = registerItem("item_citrine",
            new Item(new FabricItemSettings()));
    // SLUT 徽章
    public static final Item SLUT = registerItem("item_slut",
            new Item(new FabricItemSettings()));
}
