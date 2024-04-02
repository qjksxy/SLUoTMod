package slut.bread.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;

/**
 * 在此类中定义所有方块（Blocks）<br>
 * 添加方块步骤：<br><b>注意：避免 name 以及相关文件名大写；方块对应的物品会自动创建，无需再手动添加</b><br>
 * 1. 在本类中创建物品对应的 public static final Block 对象<br>
 * 2. 在类 SLUTModItemGroup 中，将方块添加到合适的物品组<br>
 * 3. 在 resources/.../lang/ 下的 json 文件中，添加方块的游戏内名称<br>
 * 4. 在 resources/.../models/ 下的 block/ 和 item/ 中，创建说明文件<br>
 * 5. 在 resources/.../textures/block/ 中，创建材质图片<br>
 * 6. 在 resources/.../blockstates/ 中，创建方块状态说明文件<br>
 * 7. 在 resources/.../data/slut_mod/loot_tables/blocks/ 中，创建战利品表
 */
public class SLUTModBlocks {
    /* 在下方添加 Block 对象
     * 以方块 CARD_CASE_0 为例：
     * registerBlock 方法的参数 name 为方块 ID。如无特殊说明，所有与方块相关的文件名均与 ID 相同。
     * 为了方便与物品区分，方块 ID 名应添加 block_ 前缀，变量名不需要添加此前缀。
     * Block 类的构造方法需要传入一个 FabricBlockSettings 对象，该对象有两种构造方法：
     * - 1. copyOf(): 通过复制已有的方块属性创建 FabricBlockSettings 对象。
     * - 2. create(): 创建一个 FabricBlockSettings 对象，手动设置方块的各种属性。
     * 常用属性包括：
     * - 1. mapColor(): 指定物品在游戏内地图上渲染时显示的颜色
     * - 2. instrument(): 当物品放置在音符盒下时，音符盒播放的乐器类型
     * - 3. requiresTool(): 破坏物品时是否需要特殊工具，参数为两个浮点数，分别为手持正确工具时和其他情况的硬度
     * - 4. noCollision(): 设置物品无碰撞体积
     * 方块设置为使用特殊工具才能挖掘时，需要编辑 resources/.../data/minecraft/ 和 -/mineable/ 下的 json 文件
     */
    public static final Block CARD_CASE_0 = registerBlock("block_card_case_0",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block CARD_CASE_1 = registerBlock("block_card_case_1",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    /*
     ***** 下列方法的用途和实现无需关心 *****
     */

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(SLUTMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SLUTMod.MOD_ID, name), block);
    }
    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModBlocks.class.getName());
    }


}
