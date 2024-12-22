package cn.claycoffee.ClayTech.utils;

import cn.claycoffee.ClayTech.ClayTech;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

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

    public static boolean readPlayerMetadataBoolean(Player player, String key) {
        return player.getMetadata(key).get(0).asBoolean();
    }

    public static int readPlayerMetadataInt(Player player, String key) {
        return player.getMetadata(key).get(0).asInt();
    }

    public static long readPlayerMetadataLong(Player player, String key) {
        return player.getMetadata(key).get(0).asLong();
    }

    public static double readPlayerMetadataDouble(Player player, String key) {
        return player.getMetadata(key).get(0).asDouble();
    }

    public static String readPlayerMetadataString(Player player, String key) {
        return player.getMetadata(key).get(0).asString();
    }

    public static byte readPlayerMetadataByte(Player player, String key) {
        return player.getMetadata(key).get(0).asByte();
    }

    public static float readPlayerMetadataFloat(Player player, String key) {
        return player.getMetadata(key).get(0).asFloat();
    }

    public static short readPlayerMetadataShort(Player player, String key) {
        return player.getMetadata(key).get(0).asShort();
    }

    public static MetadataValue getMetadata(Block block, String key) {
        return block.getMetadata(key).get(0);
    }

    public static MetadataValue getBlockMetadata(Block block, String key) {
        return getMetadata(block, key);
    }

    public static void setMetaData(Block block, String key, MetadataValue value) {
        block.setMetadata(key, value);
    }

    public static void setMetaData(Block block, String key, Object value) {
        setMetaData(block, key, new FixedMetadataValue(ClayTech.getInstance(), value));
    }

    public static void setBlockMetaData(Block block, String key, MetadataValue value) {
        setMetaData(block, key, value);
    }

    public static void setBlockMetaData(Block block, String key, Object value) {
        setMetaData(block, key, value);
    }
}
