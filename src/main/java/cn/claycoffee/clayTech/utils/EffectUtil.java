package cn.claycoffee.clayTech.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class EffectUtil {
    public static void EffectCheck(@NotNull Player d, @NotNull Player e) {
        ItemStack HandItem = d.getInventory().getItemInMainHand();
        SlimefunItem item = SlimefunItem.getByItem(HandItem);
        if (item != null && item.getResearch() != null && item.getResearch().canUnlock(d)) {
            try {
                if (ObjectUtil.ExistsInList(Lang.readGeneralText("Blind_5_effect"), ItemStackUtil.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));
                }
                if (ObjectUtil.ExistsInList(Lang.readGeneralText("Slowness_5_effect"), ItemStackUtil.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 4));
                }
                if (ObjectUtil.ExistsInList(Lang.readGeneralText("Confusion_5_effect"), ItemStackUtil.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 4));
                }
                if (ObjectUtil.ExistsInList(Lang.readGeneralText("Poison_3_effect"), ItemStackUtil.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 2));
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (e.getInventory().getBoots() != null) {
            SlimefunItem item2 = SlimefunItem.getByItem(e.getInventory().getBoots());
            if (item2 != null && item2.getResearch() != null && item2.getResearch().canUnlock(e)) {
                try {
                    if (ObjectUtil.ExistsInList(Lang.readGeneralText("Anti_Slowness_3_effect"),
                            ItemStackUtil.getLore(e.getInventory().getBoots()))) {
                        d.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
                    }
                } catch (NullPointerException ignored) {
                }
            }
        }
    }
}
