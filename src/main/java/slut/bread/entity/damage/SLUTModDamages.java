package slut.bread.entity.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import slut.bread.SLUTMod;

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
