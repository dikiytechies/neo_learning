package com.example.examplemod.init;


import com.example.examplemod.ExampleMod;
import com.example.examplemod.potion.PushEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectsInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ExampleMod.MODID);

    public static final Holder<MobEffect> PUSH = EFFECTS.register("push",
            () -> new PushEffect(MobEffectCategory.NEUTRAL, 0x227de6));
}
