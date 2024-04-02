package slut.bread.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import slut.bread.entity.damage.SLUTModDamages;

/**
 * 死亡之舞武器的技能效果
 * 纳努克的瞥视：造成每秒一点的流血伤害；仅可通过使用死亡之舞击杀生物去除
 */
public class SiWangEffect extends StatusEffect{
    protected SiWangEffect() {
        super(StatusEffectCategory.HARMFUL, 7561558);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity playerEntity) {
            World world = entity.getWorld();
            DamageSource damageSource = SLUTModDamages.getDamageSource(world, SLUTModDamages.SIWANG);
            playerEntity.damage(damageSource, 1.0f);
        }
    }
}
