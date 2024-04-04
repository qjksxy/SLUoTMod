package sluot.bread.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sluot.bread.SLUoTMod;

public class ModStatusEffects {
    public static StatusEffect SIWANG = registerStatusEffect("effect_siwang", new SiWangEffect());


    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SLUoTMod.MOD_ID, name), effect);
    }


    public static void registerClass() {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "-Registering class: " + ModStatusEffects.class.getName());
    }

}
