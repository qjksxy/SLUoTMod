package slut.bread.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;
import slut.bread.block.SLUTModBlocks;

public class SLUTModStatusEffects {
    public static StatusEffect SIWANG = registerStatusEffect("effect_siwang", new SiWangEffect());


    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SLUTMod.MOD_ID, name), effect);
    }


    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModStatusEffects.class.getName());
    }

}
