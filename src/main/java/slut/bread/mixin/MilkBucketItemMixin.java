package slut.bread.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slut.bread.entity.effect.SLUTModStatusEffects;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {
    @Inject(at = @At("HEAD"), method = "finishUsing", cancellable = true)
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        MilkBucketItem milkBucketItem = (MilkBucketItem) (Object) this;
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(milkBucketItem));
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
        }
        if (!world.isClient) {
            if (user.hasStatusEffect(SLUTModStatusEffects.SIWANG)) {
                StatusEffectInstance siwangEffect = user.getStatusEffect(SLUTModStatusEffects.SIWANG);
                user.clearStatusEffects();
                user.addStatusEffect(siwangEffect);
            } else {
                user.clearStatusEffects();
            }

        }
        if (stack.isEmpty()) {
            cir.setReturnValue(new ItemStack(Items.BUCKET));
        }
        cir.setReturnValue(stack);
    }

}
