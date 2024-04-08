package sluot.bread;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sluot.bread.block.ModBlocks;
import sluot.bread.entity.damage.ModDamages;
import sluot.bread.entity.effect.ModStatusEffects;
import sluot.bread.item.ModItemGroup;
import sluot.bread.item.ModItems;
import sluot.bread.sounds.ModSounds;

public class SLUoTMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	// 模组 ID
    public static final String MOD_ID = "sluot_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void jingshui(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
		if (player.isSpectator()) {
			return;
		}
		Item item = player.getMainHandStack().getItem();
		int rank = 0;
		if (item == ModItems.JINGSHUILIUYONG) {
			rank = 1;
		} else if (item == ModItems.JINGSHUILIUYONG_2) {
			rank = 2;
		} else if (item == ModItems.JINGSHUILIUYONG_3) {
			rank = 3;
		} else if (item == ModItems.JINGSHUILIUYONG_4) {
			rank = 4;
		} else if (item == ModItems.JINGSHUILIUYONG_5) {
			rank = 5;
		}
		// 手动的旁观者检查是必要的，因为 AttackEntityCallback 会在旁观者检查之前应用
		if (rank != 0) {
			// 当玩家生命值大于 12 时，玩家攻击后会损失 1 点生命值，使伤害 + 3
			// 当玩家生命值不大于 12 时，玩家攻击后会回复 3 点生命值
			DamageSource damageSource = ModDamages.getDamageSource(world, ModDamages.JINGSHUI);
			if (player.getHealth() > 12f) {
				player.damage(damageSource, 1.0F);
				entity.damage(damageSource, 2.0f + rank);
			} else {
				player.heal(2.0f + rank);
			}
		}
	}

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
			jingshui(player, world, hand, entity, hitResult);
			return ActionResult.PASS;
		});
	}
}