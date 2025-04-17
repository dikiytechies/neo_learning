package com.example.examplemod;

import com.example.examplemod.init.EffectsInit;
import com.example.examplemod.init.ItemsInit;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

@Mod(ExampleMod.MODID)
public class ExampleMod
{
    public static final String MODID = "examplemod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        initVanillaRegistries(modEventBus);
        modEventBus.addListener(this::addCreative);
    }
    private static void initVanillaRegistries(IEventBus modEventBus) {
        EffectsInit.EFFECTS.register(modEventBus);
        ItemsInit.ITEMS.register(modEventBus);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ItemsInit.EFFECTIVE_SWORD);
        }
    }
}
