package sluot.bread;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class SLUoTModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

    }

    /**
     * 此方法用于在游戏内的聊天框输出信息，可用于调试代码
     * @param string 输出的信息
     */
    public static void hello(String string) {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "_SLUTModClient: " + string);
        // 获取MinecraftClient实例
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            // 获取玩家实体
            ClientPlayerEntity player = client.player;
            if (player != null) {
                // 向控制台输出消息
                client.player.sendMessage(Text.literal("SLUT:" + string), false);

            }
        }
    }
}
