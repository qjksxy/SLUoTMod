package slut.bread.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import slut.bread.SLUTMod;
import slut.bread.item.SLUTModItemGroup;

public class SLUTModSounds {

    public static final SoundEvent TEST = registerSoundEvents("sound_test");
    public static final SoundEvent AOMO = registerSoundEvents("sound_aomo");


    public static SoundEvent registerSoundEvents(String name) {
        Identifier identifier = new Identifier(SLUTMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerClass() {
        SLUTMod.LOGGER.debug(SLUTMod.MOD_ID + "-Registering class: " + SLUTModSounds.class.getName());
    }



}
