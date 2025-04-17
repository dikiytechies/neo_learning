package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.EffectsInit;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class GameplayEventHandler {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void explodeArrow(ProjectileImpactEvent event) {
        Projectile projectile = event.getProjectile();
        if (projectile instanceof Arrow && !projectile.level().isClientSide()) {
            projectile.level().explode(projectile, projectile.getX(), projectile.getY(), projectile.getZ(), 2.0f, Level.ExplosionInteraction.TNT);
            projectile.remove(Entity.RemovalReason.DISCARDED);
        }
    }
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void push(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof LocalPlayer player) {
            if (player.hasEffect(EffectsInit.PUSH)) {
                player.setDeltaMovement(player.getViewVector(1).normalize().multiply((player.getEffect(EffectsInit.PUSH).getAmplifier() + 1) / 10.0, (player.getEffect(EffectsInit.PUSH).getAmplifier() + 1) / 10.0, (player.getEffect(EffectsInit.PUSH).getAmplifier() + 1) / 10.0));
            }
        }
    }
}
