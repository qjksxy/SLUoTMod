package slut.bread;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slut.bread.block.SLUTModBlocks;
import slut.bread.entity.effect.SLUTModStatusEffects;
import slut.bread.item.SLUTModItemGroup;
import slut.bread.item.SLUTModItems;

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
		SLUTModItems.registerClass();
		SLUTModItemGroup.registerClass();
		SLUTModBlocks.registerClass();
		SLUTModStatusEffects.registerClass();
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			// 手动的旁观者检查是必要的，因为 AttackEntityCallback 会在旁观者检查之前应用
			if (!player.isSpectator() && player.getMainHandStack().getItem() == SLUTModItems.SIWANGZHIWU) {
				// 当玩家生命值大于 10 时，玩家攻击后会损失一点生命值，使伤害 + 2
				// 当玩家生命值不大于 10 时，玩家攻击后会回复两点生命值
				DamageSource damageSource = new DamageSource(RegistryEntry.of(new DamageType("迷思", 1.0f)));
				if (player.getHealth() > 10f) {
					player.damage(damageSource, 1.0F);
					entity.damage(damageSource, 2.0f);
				} else {
					player.heal(2.0f);
				}
			}
			return ActionResult.PASS;
		});
	}
}