package slut.bread.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import slut.bread.SLUTMod;

/**
 * 自定义伤害类型<br>
 * 步骤：<br>
 * 1. 在本类中创建 psf RegistryKey<> 常量<br>
 * 2. 在 resources/data/.../damage_type 中创建对应的 json 文件<br>
 * 3. 在需要 DamageSource 的地方调用 getDamageSource() 方法<br>
 */
public class SLUTModDamages {
    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModDamages.class.getName());
    }

    public static DamageSource getDamageSource(World world, RegistryKey<DamageType> damageTypeRegistryKey) {
        return new DamageSource(world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(damageTypeRegistryKey));
    }


    public static final RegistryKey<DamageType> HUMO = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(SLUTMod.MOD_ID, "humo"));
    public static final RegistryKey<DamageType> JINGSHUI = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(SLUTMod.MOD_ID, "jingshui"));
    public static final RegistryKey<DamageType> SIWANG = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(SLUTMod.MOD_ID, "siwang"));
}
