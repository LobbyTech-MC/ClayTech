package cn.claycoffee.clayTech;

import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.nms.ItemNameAdapter;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Final_ROOT
 */
public final class ItemStackUtil {
    public static final ItemStack AIR = new ItemStack(Material.AIR);
    public static final ItemNameAdapter itemNameAdapter = ItemNameAdapter.get();

    /**
     * Clone an #{@link ItemStack}
     *
     * @param item to be cloned
     * @return a cloned #{@link ItemStack}
     */
    public static ItemStack cloneItem(@Nonnull ItemStack item) {
        return item instanceof ItemStackWrapper ? new ItemStack(item) : item.clone();
    }

    public static ItemStack getCleanItem(@Nullable ItemStack item) {
        if (item == null) {
            return new ItemStack(Material.AIR);
        }

        ItemStack cleanItem = new ItemStack(item.getType());
        cleanItem.setAmount(item.getAmount());
        if (item.hasItemMeta()) {
            cleanItem.setItemMeta(item.getItemMeta());
        }

        return cleanItem;
    }

    /**
     * Clone an #{@link ItemStack}
     *
     * @param item   to be cloned
     * @param amount the amount of the result item
     * @return a cloned #{@link ItemStack}
     */
    public static ItemStack cloneItem(@Nonnull ItemStack item, int amount) {
        ItemStack itemStack = item instanceof ItemStackWrapper ? new ItemStack(item) : item.clone();
        itemStack.setAmount(amount);
        return itemStack;
    }

    /**
     * @return Whether the item seems to be null
     */
    public static boolean isItemNull(@Nullable ItemStack item) {
        return item == null || item.getType() == Material.AIR || item.getAmount() == 0;
    }

    /**
     * @return Name of the given #{@link ItemStack}.
     */
    @Nonnull
    public static String getItemName(@Nullable ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return "null";
        }
        item = new ItemStack(item);
        if (item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta.hasDisplayName()) {
                return itemMeta.getDisplayName();
            }
        } else {
            try {
                return itemNameAdapter.getName(item);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                return "unknown";
            }
        }
        return "unknown";
    }

    public static void setItemName(@Nonnull ItemStack item, @Nonnull String itemName) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        item.setItemMeta(itemMeta);
    }

    public static void addLoreToFirst(@Nullable ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
            lore.add(s);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
        } else {
            List<String> newLore = new ArrayList<>(lore.size() + 1);
            newLore.add(s);
            newLore.addAll(lore);
            itemMeta.setLore(newLore);
            item.setItemMeta(itemMeta);
        }
    }

    public static void addLoreToLast(@Nullable ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.add(s);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void addLoreToLast(@Nonnull ItemMeta itemMeta, @Nonnull String s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.add(s);
        itemMeta.setLore(lore);
    }

    public static void addLoresToLast(@Nullable ItemStack item, @Nonnull String... s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.addAll(Arrays.stream(s).toList());
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void addLoresToLast(@Nonnull ItemMeta itemMeta, @Nonnull String... s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.addAll(Arrays.stream(s).toList());
        itemMeta.setLore(lore);
    }

    public static void removeLastLore(@Nullable ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return;
        }
        lore = lore.subList(0, Math.max(lore.size() - 1, 0));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void removeLastLore(@Nonnull ItemMeta itemMeta) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return;
        }
        lore = lore.subList(0, Math.max(lore.size() - 1, 0));
        itemMeta.setLore(lore);
    }

    public static void setLastLore(@Nonnull ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            lore = new ArrayList<>();
            lore.add(s);
        } else {
            lore.set(lore.size() - 1, s);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void setLastLore(@Nonnull ItemMeta itemMeta, @Nonnull String s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            lore = new ArrayList<>();
            lore.add(s);
        } else {
            lore.set(lore.size() - 1, s);
        }
        itemMeta.setLore(lore);
    }

    @Nullable
    public static String getLastLore(@Nonnull ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return null;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return null;
        }
        return lore.get(lore.size() - 1);
    }

    @Nullable
    public static String getLastLore(@Nonnull ItemMeta itemMeta) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return null;
        }
        return lore.get(lore.size() - 1);
    }

    public static void setLore(@Nonnull ItemStack item, @Nonnull String... lore) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(Arrays.stream(lore).toList());
        item.setItemMeta(itemMeta);
    }

    public static void setLore(@Nonnull ItemStack item, @Nonnull List<String> lore) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void replaceLore(@Nonnull ItemStack item, int loreOffset, @Nonnull String... lore) {
        if (loreOffset < 0) {
            ItemStackUtil.setLore(item, lore);
            return;
        }
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> oldLore = itemMeta.getLore();
        if (oldLore == null) {
            oldLore = new ArrayList<>();
        }
        while (oldLore.size() < loreOffset) {
            oldLore.add("");
        }
        for (int i = 0; i < lore.length; i++) {
            if (oldLore.size() <= loreOffset + i) {
                oldLore.add(loreOffset + i, lore[i]);
            } else {
                oldLore.set(loreOffset + i, lore[i]);
            }
        }
        itemMeta.setLore(oldLore);
        item.setItemMeta(itemMeta);
    }

    public static void replaceLore(@Nonnull ItemStack item, int loreOffset, @Nonnull List<String> lore) {
        if (loreOffset < 0) {
            ItemStackUtil.setLore(item, lore);
            return;
        }
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> oldLore = itemMeta.getLore();
        if (oldLore == null) {
            oldLore = new ArrayList<>();
        }
        while (oldLore.size() < loreOffset) {
            oldLore.add("");
        }
        for (int i = 0; i < lore.size(); i++) {
            if (oldLore.size() <= loreOffset + i) {
                oldLore.add(loreOffset + i, lore.get(i));
            } else {
                oldLore.set(loreOffset + i, lore.get(i));
            }
        }
        itemMeta.setLore(oldLore);
        item.setItemMeta(itemMeta);
    }

    public static void addItemFlag(@Nonnull ItemStack item, @Nonnull ItemFlag itemFlag) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(itemFlag);
        item.setItemMeta(itemMeta);
    }

    public static void addNBT(@Nonnull ItemStack item, @Nonnull NamespacedKey namespacedKey, @Nonnull String value) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (!persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) {
            persistentDataContainer.set(namespacedKey, PersistentDataType.STRING, value);
            item.setItemMeta(itemMeta);
        }
    }

    public static void setNBT(@Nonnull ItemStack item, @Nonnull NamespacedKey namespacedKey, @Nonnull String value) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(namespacedKey, PersistentDataType.STRING, value);
        item.setItemMeta(itemMeta);
    }

    public static void clearNBT(@Nonnull ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        for (NamespacedKey namespacedKey : persistentDataContainer.getKeys()) {
            persistentDataContainer.remove(namespacedKey);
        }
        itemStack.setItemMeta(itemMeta);
    }

    @Nullable
    public static ItemStack cloneWithoutNBT(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        if (!itemStack.hasItemMeta()) {
            return new ItemStack(itemStack);
        }
        ItemStack result = new ItemStack(itemStack);
        ItemStackUtil.clearNBT(result);
        return result;
    }

    public static ItemStack getDried(@Nonnull ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return null;
        }
        return switch (item.getType()) {
            case POTION, DRAGON_BREATH, HONEY_BOTTLE -> new ItemStack(Material.GLASS_BOTTLE, 1);
            case WATER_BUCKET, LAVA_BUCKET, MILK_BUCKET -> new ItemStack(Material.BUCKET, 1);
            default -> null;
        };
    }

    /**
     * Transfer #{@link ItemStack} to #{@link String}
     */
    @Nonnull
    public static String itemStackToString(@Nonnull ItemStack itemStack) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("item", itemStack);
        return yamlConfiguration.saveToString();
    }

    /**
     * Transfer #{@link String} to #{@link ItemStack}
     */
    @Nullable
    public static ItemStack stringToItemStack(@Nonnull String local) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.loadFromString(local);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return yamlConfiguration.getItemStack("item");
    }

    public static String color(String str) {
        if (str == null) {
            return null;
        }
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void giveOrDropItem(Player p, ItemStack toGive) {
        for (int i = 0; i < 64; i++) {
            if (toGive.getAmount() <= 0) {
                return;
            }
            ItemStack incoming = toGive.clone();
            incoming.setAmount(Math.min(toGive.getMaxStackSize(), toGive.getAmount()));
            toGive.setAmount(toGive.getAmount() - incoming.getAmount());
            Collection<ItemStack> leftover = p.getInventory().addItem(incoming).values();
            for (ItemStack itemStack : leftover) {
                p.getWorld().dropItemNaturally(p.getLocation(), itemStack);
            }
        }
    }

    public static void send(CommandSender p, String message) {
        p.sendMessage(color("&7[&6NetworksExpansion&7] &r" + message));
    }

    public static ItemStack getPreEnchantedItemStack(Material material) {
        return getPreEnchantedItemStack(material, true);
    }

    @Nonnull
    @SafeVarargs
    public static ItemStack getPreEnchantedItemStack(Material material, boolean hide, @Nonnull Pair<Enchantment, Integer>... enchantments) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (Pair<Enchantment, Integer> pair : enchantments) {
            itemMeta.addEnchant(pair.getFirstValue(), pair.getSecondValue(), true);
        }
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
