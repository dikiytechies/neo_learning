package com.example.examplemod.item;

import com.example.examplemod.init.EffectsInit;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import java.util.Arrays;

public class EffectiveSwordItem extends SwordItem {
    public EffectiveSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!player.isShiftKeyDown()) {
            player.addEffect(new MobEffectInstance(EffectsInit.PUSH, 40, 5, false, false, true));
        } else {
            Holder<MobEffect>[] effects = Arrays.stream(MobEffects.class.getFields()).map(field -> {
                        try {
                            Object value = field.get(null);
                            if (value instanceof Holder<?>) {
                                return (Holder<MobEffect>) value;
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return null;
            }).filter(holder -> holder != null).toArray(Holder[]::new);
            for (Holder<MobEffect> effect : effects) {
                player.addEffect(new MobEffectInstance(effect, 100, 1));
            }
        }
        return InteractionResult.SUCCESS;
    }
}
