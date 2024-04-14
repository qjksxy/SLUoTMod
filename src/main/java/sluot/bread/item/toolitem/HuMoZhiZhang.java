package sluot.bread.item.toolitem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import sluot.bread.entity.damage.ModDamages;
import sluot.bread.sounds.ModSounds;

public class HuMoZhiZhang extends SwordItem {
    public int rank = 0;
    public HuMoZhiZhang(int rank, ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.rank = rank;
    }

    // 护摩之杖右键使用时，玩家会受到 6 点穿透伤害
    // 同时获得持续 300 + 100 * rank 游戏刻（20s），1 级力量状态效果（近战伤害+3）
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d userPos = user.getPos();
        world.playSound(null, userPos.x, userPos.y, userPos.z, ModSounds.TEST, SoundCategory.VOICE, 1f, 1f);
        DamageSource damageSource = ModDamages.getDamageSource(world, ModDamages.HUMO);
        user.damage(damageSource, 6.0f);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300 + 100 * rank, 0));
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    // 使用护摩之杖攻击后，若玩家处于力量状态下，会获得以下状态效果：
    // 生命恢复 1 级 50 * rank 刻: 每秒恢复 0.2 生命值
    // 生命提升 1 级 50 * rank 刻: 增加 4 点生命上限
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity user = (PlayerEntity) attacker;
        int duration = 50 * rank;
        int duration_absorption = 0;
        if (user.hasStatusEffect(StatusEffects.STRENGTH)) {
            if (user.hasStatusEffect(StatusEffects.ABSORPTION)) {
                StatusEffectInstance statusEffect = user.getStatusEffect(StatusEffects.ABSORPTION);
                assert statusEffect != null;
                duration_absorption += statusEffect.getDuration();
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration + duration_absorption, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, duration, 0));
        }
        return super.postHit(stack, target, attacker);
    }
}
