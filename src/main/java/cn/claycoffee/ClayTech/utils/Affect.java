package cn.claycoffee.ClayTech.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Affect {
    public static void AffectCheck(Player d, Player e) {
        ItemStack HandItem = d.getInventory().getItemInMainHand();
        SlimefunItem item = SlimefunItem.getByItem(HandItem);
        if (item != null && item.getResearch() != null && item.getResearch().canUnlock(d)) {
            try {
                if (Utils.ExistInList(Lang.readGeneralText("Blind_5_effect"), Utils.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 4));
                }
                if (Utils.ExistInList(Lang.readGeneralText("Slowness_5_effect"), Utils.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 4));
                }
                if (Utils.ExistInList(Lang.readGeneralText("Confusion_5_effect"), Utils.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 4));
                }
                if (Utils.ExistInList(Lang.readGeneralText("Poison_3_effect"), Utils.getLore(HandItem))) {
                    e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 2));
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (e.getInventory().getBoots() != null) {
            SlimefunItem item2 = SlimefunItem.getByItem(e.getInventory().getBoots());
            if (item2 != null && item2.getResearch() != null && item2.getResearch().canUnlock(e)) {
                try {
                    if (Utils.ExistInList(Lang.readGeneralText("Anti_Slowness_3_effect"),
                            Utils.getLore(e.getInventory().getBoots()))) {
                        d.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
                    }
                } catch (NullPointerException ignored) {
                }
            }
        }
    }
}
