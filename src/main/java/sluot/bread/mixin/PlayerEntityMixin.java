package sluot.bread.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sluot.bread.entity.effect.ModStatusEffects;
import sluot.bread.item.ModItems;
import sluot.bread.util.WeaponItem;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "applyDamage", cancellable = true)
    protected void applyDamage(DamageSource source, float amount, CallbackInfo ci) {
        PlayerEntity playerEntity = (PlayerEntity) (Object) this;
        ItemStack itemStack = playerEntity.getEquippedStack(EquipmentSlot.MAINHAND);
        Item item = itemStack.getItem();
        // 只有其他生物造成的伤害才会触发，摔落伤害、岩浆伤害等不会触发
        boolean attackByLivingEntity = source.getAttacker() instanceof LivingEntity;
        WeaponItem weapon = WeaponItem.getModWeapon(item);
        if (weapon.weaponName.equals(WeaponItem.SIWANG) && attackByLivingEntity) {
            playerEntity.damage(source, Math.min(amount, 1.0f));
            int duration = 5;
            if (playerEntity.hasStatusEffect(ModStatusEffects.SIWANG)) {
                StatusEffectInstance statusEffect = playerEntity.getStatusEffect(ModStatusEffects.SIWANG);
                assert statusEffect != null;
                duration += statusEffect.getDuration();
            }
            duration = (int) (duration + amount * 20 * (1.1 - weapon.rank * 0.1));
            playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SIWANG, duration, 1));
            ci.cancel();
        }
    }
}