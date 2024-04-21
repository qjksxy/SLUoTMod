package sluot.bread.item.toolitem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
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
    // 同时获得持续时间 20s(40s) 的 I 级力量状态效果（近战伤害+3）
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d userPos = user.getPos();
        world.playSound(null, userPos.x, userPos.y, userPos.z, ModSounds.TEST, SoundCategory.VOICE, 1f, 1f);
        DamageSource damageSource = ModDamages.getDamageSource(world, ModDamages.HUMO);
        user.damage(damageSource, 6.0f);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300 + 100 * rank, 1));
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    // 使用护摩之杖攻击后，若玩家处于力量状态下，则使能持续时间为 4s(8s) 的如下状态：
    // 1. 获得状态：生命提升 I 级（生命上限提升 4 点），持续时间可叠加；
    // 2. 刷新状态：伤害吸收 I 级（增加 4 点额外生命）；
    // 3. 获得状态：抗性提升 II 级（伤害减免 40%），不可叠加
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity user = (PlayerEntity) attacker;
        int duration = 60 + 20 * rank;
        // 1. 获得状态：生命提升 I 级，可叠加；
        int duration_health_boost = 0;
        if (user.hasStatusEffect(StatusEffects.HEALTH_BOOST)) {
            StatusEffectInstance statusEffect = user.getStatusEffect(StatusEffects.HEALTH_BOOST);
            assert statusEffect != null;
            duration_health_boost += statusEffect.getDuration();
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, duration + duration_health_boost, 0));
        // 2. 刷新状态：伤害吸收 I 级
        if (user.hasStatusEffect(StatusEffects.ABSORPTION)) {
            user.removeStatusEffect(StatusEffects.ABSORPTION);
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, 0));
        // 3. 获得状态：抗性提升 II 级，不可叠加
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, duration, 1));

        return super.postHit(stack, target, attacker);
    }
}
