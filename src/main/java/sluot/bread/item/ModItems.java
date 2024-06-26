package sluot.bread.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import sluot.bread.SLUoTMod;
import sluot.bread.item.toolitem.HuMoZhiZhang;
import sluot.bread.sounds.ModSounds;

import java.util.ArrayList;
import java.util.List;


/**
 * 在此类中定义所有的物品（Items）<br>
 * 添加物品步骤：<br><b>注意：避免 name 以及相关文件名大写</b><br>
 * 1. 在本类中创建物品对应的 public static final Item 对象<br>
 * 2. 在类 item/ModItemGroup 中，将物品添加到合适的物品组<br>
 * 3. 在 resources/.../lang/ 下的 json 文件中，添加物品的游戏内名称<br>
 * 4. 在 resources/.../textures/item/ 中，创建材质图片<br>
 * 5. 在类 datagen/ModModelsProvider 中，将物品添加到 generateItemModels 方法中
 */
public class ModItems {
    // 黄水晶 测试用
    public static final Item CITRINE = registerItem("item_citrine",
            new Item(new FabricItemSettings()));
    // SLUoT 徽章
    public static final Item SLUOT = registerItem("item_sluot",
            new Item(new FabricItemSettings()));

    public static final List<Item> SIWANG_ITEMS = new ArrayList<>(List.of(
            registerItem("item_siwangzhiwu_1", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON))),
            registerItem("item_siwangzhiwu_2", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_siwangzhiwu_3", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_siwangzhiwu_4", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_siwangzhiwu_5", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.EPIC)))
    ));
    public static final List<Item> JINGSHUI_ITEMS = new ArrayList<>(List.of(
            registerItem("item_jingshuiliuyong_1", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON))),
            registerItem("item_jingshuiliuyong_2", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_jingshuiliuyong_3", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_jingshuiliuyong_4", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_jingshuiliuyong_5", new SwordItem(ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.EPIC)))
    ));
    public static final List<Item> HUMO_ITEMS = new ArrayList<>(List.of(
            registerItem("item_humozhizhang_1", new HuMoZhiZhang(1, ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON))),
            registerItem("item_humozhizhang_2", new HuMoZhiZhang(2, ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_humozhizhang_3", new HuMoZhiZhang(3, ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_humozhizhang_4", new HuMoZhiZhang(4, ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.RARE))),
            registerItem("item_humozhizhang_5", new HuMoZhiZhang(5, ToolMaterials.IRON, 3, -2.4f,
                    new FabricItemSettings().rarity(Rarity.EPIC)))
    ));

    // 唱片
    public static final List<Item> MUSIC_DISC_ITEMS = new ArrayList<>(List.of(
            registerItem("item_music_disc_aomo", new MusicDiscItem(7, ModSounds.AOMO,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 161)),
            registerItem("item_music_disc_white_night", new MusicDiscItem(7, ModSounds.WHITE_NIGHT,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 138)),
            registerItem("item_music_disc_lamentation", new MusicDiscItem(7, ModSounds.LAMENTATION,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 229)),
            registerItem("item_music_disc_never_ending", new MusicDiscItem(7, ModSounds.NEVER_ENDING,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 171)),
            registerItem("item_music_disc_rondeau_des", new MusicDiscItem(7, ModSounds.RONDEAU_DES,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 233))
    ));
    // 卡牌系列
    public static final List<Item> CARD_ITEMS_ZOM = new ArrayList<>(List.of(
            registerItem("item_zom_1", new Item(new FabricItemSettings())),
            registerItem("item_zom_2", new Item(new FabricItemSettings())),
            registerItem("item_zom_3", new Item(new FabricItemSettings())),
            registerItem("item_zom_4", new Item(new FabricItemSettings())),
            registerItem("item_zom_5", new Item(new FabricItemSettings())),
            registerItem("item_zom_6", new Item(new FabricItemSettings())),
            registerItem("item_zom_7", new Item(new FabricItemSettings())),
            registerItem("item_zom_8", new Item(new FabricItemSettings())),
            registerItem("item_zom_9", new Item(new FabricItemSettings()))
    ));
    public static final List<Item> CARD_ITEMS_BOOK = new ArrayList<>(List.of(
            registerItem("item_book_1", new Item(new FabricItemSettings())),
            registerItem("item_book_2", new Item(new FabricItemSettings())),
            registerItem("item_book_3", new Item(new FabricItemSettings())),
            registerItem("item_book_4", new Item(new FabricItemSettings())),
            registerItem("item_book_5", new Item(new FabricItemSettings())),
            registerItem("item_book_6", new Item(new FabricItemSettings())),
            registerItem("item_book_7", new Item(new FabricItemSettings())),
            registerItem("item_book_8", new Item(new FabricItemSettings())),
            registerItem("item_book_9", new Item(new FabricItemSettings()))
    ));
    public static final List<Item> CARD_ITEMS_FOCUS = new ArrayList<>(List.of(
            registerItem("item_focus_1", new Item(new FabricItemSettings())),
            registerItem("item_focus_2", new Item(new FabricItemSettings())),
            registerItem("item_focus_3", new Item(new FabricItemSettings())),
            registerItem("item_focus_4", new Item(new FabricItemSettings())),
            registerItem("item_focus_5", new Item(new FabricItemSettings())),
            registerItem("item_focus_6", new Item(new FabricItemSettings())),
            registerItem("item_focus_7", new Item(new FabricItemSettings())),
            registerItem("item_focus_8", new Item(new FabricItemSettings())),
            registerItem("item_focus_9", new Item(new FabricItemSettings()))
    ));
    /*
     ***** 下列方法的用途和实现无需关心 *****
     */
    public static void registerClass() {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "-Registering class: " + ModItems.class.getName());
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(SLUoTMod.MOD_ID, name), item);
    }
}
