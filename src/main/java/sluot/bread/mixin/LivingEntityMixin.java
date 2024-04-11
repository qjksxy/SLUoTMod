package sluot.bread.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sluot.bread.entity.effect.ModStatusEffects;
import sluot.bread.item.ModItems;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource damageSource, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = damageSource.getAttacker();
        // 检查是否为玩家击杀生物
        if (entity instanceof PlayerEntity playerEntity) {
            Item item = playerEntity.getEquippedStack(EquipmentSlot.MAINHAND).getItem();
            int rank = 0;
            if (item == ModItems.SIWANGZHIWU[0]) {
                rank = 1;
            } else if (item == ModItems.SIWANGZHIWU[1]) {
                rank = 2;
            } else if (item == ModItems.SIWANGZHIWU[2]) {
                rank = 3;
            } else if (item == ModItems.SIWANGZHIWU[3]) {
                rank = 4;
            } else if (item == ModItems.SIWANGZHIWU[4]) {
                rank = 5;
            }
            if(rank > 0) {
                if (!playerEntity.hasStatusEffect(ModStatusEffects.SIWANG)) {
                    return;
                }
                int duration;
                StatusEffectInstance statusEffect = playerEntity.getStatusEffect(ModStatusEffects.SIWANG);
                assert statusEffect != null;
                duration = statusEffect.getDuration();
                // 至多免除 rank * 8 秒的凋零伤害, 不会持续恢复生命
                int r_time = rank * 8 * 20;
                if(duration < r_time) {
                    playerEntity.removeStatusEffect(ModStatusEffects.SIWANG);
                } else {
                    playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SIWANG, (duration - r_time), 1));
                }
            }
        }
    }
}
