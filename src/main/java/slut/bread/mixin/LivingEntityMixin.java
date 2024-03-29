package slut.bread.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slut.bread.SLUTModClient;
import slut.bread.item.SLUTModItems;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource damageSource, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = damageSource.getAttacker();
        // 检查是否为玩家击杀生物
        if (entity instanceof PlayerEntity playerEntity) {
            SLUTModClient.hello("PlayerEntity:" + playerEntity.getEntityName());
            Item item = playerEntity.getEquippedStack(EquipmentSlot.MAINHAND).getItem();
            if(item == SLUTModItems.SiWangZhiWu) {
                if (!playerEntity.hasStatusEffect(StatusEffects.WITHER)) {
                    return;
                }
                int duration = 0;
                StatusEffectInstance statusEffect = playerEntity.getStatusEffect(StatusEffects.WITHER);
                assert statusEffect != null;
                duration = statusEffect.getDuration();
                // 至多免除 30 秒的凋零伤害, 不会持续恢复生命
                // 毁灭是壮烈的一瞬，倘若卑劣求存，此生便太过漫长
                if(duration < 600) {
                    playerEntity.removeStatusEffect(StatusEffects.WITHER);
                } else {
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, (duration - 600), 1));
                }
            }
        }
    }
}
