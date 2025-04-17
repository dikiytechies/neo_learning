package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.EffectiveSwordItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MODID);

    public static final DeferredItem<Item> EFFECTIVE_SWORD = ITEMS.register("effective_sword",
            () -> new EffectiveSwordItem(ToolMaterial.DIAMOND, 2.8f, -2.4f,
                    new Item.Properties().durability(200).rarity(Rarity.UNCOMMON)
                            .setId(ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,"effective_sword")))));
}
