package sluot.bread.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import sluot.bread.SLUoTMod;

public class ModSounds {

    public static final SoundEvent TEST = registerSoundEvents("sound_test");
    public static final SoundEvent AOMO = registerSoundEvents("sound_aomo");
    public static final SoundEvent WHITE_NIGHT = registerSoundEvents("sound_white_night");
    public static final SoundEvent LAMENTATION = registerSoundEvents("sound_lamentation");
    public static final SoundEvent NEVER_ENDING = registerSoundEvents("sound_never_ending");
    public static final SoundEvent RONDEAU_DES = registerSoundEvents("sound_rondeau_des");


    public static SoundEvent registerSoundEvents(String name) {
        Identifier identifier = new Identifier(SLUoTMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerClass() {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "-Registering class: " + ModSounds.class.getName());
    }



}
