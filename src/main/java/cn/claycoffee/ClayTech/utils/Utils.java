package cn.claycoffee.ClayTech.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static boolean ExistInList(int a, List<Integer> b) {
        for (int i : b) {
            if (i == a) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistInList(int a, int[] b) {
        for (int i : b) {
            if (i == a) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistInList(Object a, List<Object> b) {
        for (Object o : b) {
            if (o.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistInList(String a, List<String> b) {
        for (String s : b) {
            if (s.equals(a)) {
                return true;
            }
        }
        return false;
    }


    @Nonnull
    public static List<String> getLore(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return new ArrayList<>();
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return new ArrayList<>();
        }

        List<String> lore = meta.getLore();
        if (lore == null) {
            return new ArrayList<>();
        }

        return lore;
    }

    @Nullable
    public static ItemStack setLoreList(ItemStack itemStack, List<String> lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemStack copy = itemStack.clone();

        ItemMeta meta = copy.getItemMeta();
        if (meta == null) {
            return null;
        }

        meta.setLore(lore);
        copy.setItemMeta(meta);
        return copy;
    }

    public static ItemStack setLoreList(ItemStack itemStack, String[] lore) {
        return setLoreList(itemStack, new ArrayList<>(List.of(lore)));
    }

    public static List<String> getLoreList(ItemStack itemStack) {
        return getLore(itemStack);
    }

    public static void setLore(ItemStack itemStack, List<String> lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return;
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return;
        }

        meta.setLore(lore);
        itemStack.setItemMeta(meta);
    }

    public static ItemStack addLore(ItemStack itemStack, String lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return null;
        }

        List<String> loreList = meta.getLore();
        if (loreList == null) {
            loreList = new ArrayList<>();
        }

        loreList.add(lore);
        meta.setLore(loreList);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack addLore(ItemStack itemStack, List<String> lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return null;
        }

        List<String> loreList = meta.getLore();
        if (loreList == null) {
            loreList = new ArrayList<>();
        }

        loreList.addAll(lore);
        meta.setLore(loreList);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
