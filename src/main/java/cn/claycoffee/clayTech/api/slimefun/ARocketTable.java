package cn.claycoffee.clayTech.api.slimefun;

import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
public abstract class ARocketTable extends AbstractMachine {
    public static final int[] inputSlots = new int[]{11, 19, 20, 21, 28, 29, 30, 37, 38, 39};
    public static final int[] outputSlots = new int[]{34};
    private static final int[] BORDER = {0, 1, 3, 5, 6, 7, 8, 14, 15, 16, 17, 23, 41, 50, 51, 52, 53, 32};
    private static final int[] BORDER_IN = {9, 10, 12, 13, 18, 22, 27, 31, 36, 40, 45, 46, 47, 48, 49};
    private static final int[] BORDER_OUT = {24, 25, 26, 33, 35, 42, 43, 44};
    private static final ItemStack BORDER_ITEM = new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,
            Lang.readMachinesText("SPLIT_LINE"));
    private static final ItemStack OTHERBORDER_ITEM = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
            Lang.readMachinesText("SPLIT_LINE"));

    public ARocketTable(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                        ItemStack[] recipe) {

        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int[] getInputSlots() {
        return inputSlots;
    }

    @Override
    public int[] getOutputSlots() {
        return outputSlots;
    }

    @Override
    public void constructMenu(BlockMenuPreset preset) {
        preset.addItem(5, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        for (int eachID : BORDER) {
            preset.addItem(eachID, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int eachID : BORDER_IN) {
            preset.addItem(eachID, OTHERBORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int eachID : BORDER_OUT) {
            preset.addItem(eachID, OTHERBORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());
        }
        preset.addItem(4, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "),
                ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(2, new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
                Lang.readMachinesText("ROCKET_ASSEMBLING_BLUEPRINT")), ChestMenuUtils.getEmptyClickHandler());

        preset.addItem(5, BORDER_ITEM, ChestMenuUtils.getEmptyClickHandler());

        for (int i : getOutputSlots()) {
            preset.addMenuClickHandler(i, new AdvancedMenuClickHandler() {

                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor,
                                       ClickAction action) {
                    return cursor == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

    @Override
    public MachineRecipe findNextRecipe(BlockMenu inv) {
        MachineRecipe r = null;
        Map<Integer, Integer> found = new HashMap<>();
        int i;
        for (MachineRecipe recipe : recipes) {
            i = 0;
            for (ItemStack input : recipe.getInput()) {
                if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(inputSlots[i]), input, true)) {
                    // 如果该位置的物品符合某合成配方的对应位置物品
                    if (input != null) {
                        found.put(inputSlots[i], input.getAmount());
                    }
                }
                if (inv.getItemInSlot(inputSlots[i]) == input && input == null) {
                    found.put(i, 0);
                }
                if (i < 9) {
                    i++;
                } else
                    i = 0;
            }
            if (found.size() == recipe.getInput().length) {
                r = recipe;
                break;
            } else
                found.clear();
        }

        return r;
    }

}
