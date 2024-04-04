package slut.bread;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slut.bread.block.ModBlocks;
import slut.bread.entity.damage.ModDamages;
import slut.bread.entity.effect.ModStatusEffects;
import slut.bread.item.ModItemGroup;
import slut.bread.item.ModItems;
import slut.bread.sounds.ModSounds;

public class SLUTMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	// 模组 ID
    public static final String MOD_ID = "slut_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerClass();
		ModItemGroup.registerClass();
		ModBlocks.registerClass();
		ModStatusEffects.registerClass();
		ModSounds.registerClass();
		ModDamages.registerClass();
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			// 手动的旁观者检查是必要的，因为 AttackEntityCallback 会在旁观者检查之前应用
			if (!player.isSpectator() && player.getMainHandStack().getItem() == ModItems.JINGSHUILIUYONG) {
				// 当玩家生命值大于 12 时，玩家攻击后会损失 1 点生命值，使伤害 + 3
				// 当玩家生命值不大于 12 时，玩家攻击后会回复 3 点生命值
				DamageSource damageSource = ModDamages.getDamageSource(world, ModDamages.JINGSHUI);
				if (player.getHealth() > 12f) {
					player.damage(damageSource, 1.0F);
					entity.damage(damageSource, 3.0f);
				} else {
					player.heal(3.0f);
				}
			}
			return ActionResult.PASS;
		});
	}
}