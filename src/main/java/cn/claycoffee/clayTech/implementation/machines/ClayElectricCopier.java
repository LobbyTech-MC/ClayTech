package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.api.slimefun.ANewContainer;
import cn.claycoffee.clayTech.utils.Lang;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/7/20 11:35
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class ClayElectricCopier extends ANewContainer {
    private static final Map<Block, Integer> mode = new HashMap<>();

    public ClayElectricCopier(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                              ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }


    @Override
    public @NotNull String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ELECTRIC_COPIER");
    }

    @Override
    public @NotNull ItemStack getProgressBar() {
        return new ItemStack(Material.BOOK);
    }

    @Override
    public int getEnergyConsumption() {
        return 40;
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public @Nullable MachineRecipe findNextRecipe(BlockMenu inv) {
        return null;
    }

    protected void tick(@NotNull Block b) {
        BlockMenu inv = StorageCacheUtils.getMenu(b.getLocation());
        if (inv == null) {
            return;
        }

        CraftingOperation currentOperation = getMachineProcessor().getOperation(b);

        if (currentOperation != null) {
            if (takeCharge(b.getLocation())) {

                if (!currentOperation.isFinished()) {
                    getMachineProcessor().updateProgressBar(inv, 22, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
                    getMachineProcessor().endOperation(b);
                    inv.addItem(getInputSlots()[0], getMachineProcessor().getOperation(b).getIngredients()[0]);
                }
            }
        } else {
            if (inv.getItemInSlot(19) == null || inv.getItemInSlot(20) == null) return;

            ItemStack input = inv.getItemInSlot(19);
            ItemStack output = inv.getItemInSlot(20);
            if (inv.getItemInSlot(19).getType() == Material.WRITABLE_BOOK && inv.getItemInSlot(20).getType() == Material.WRITABLE_BOOK) {
                // Mode I
                mode.put(b, 1);
            } else if (inv.getItemInSlot(19).getType() == Material.WRITTEN_BOOK && inv.getItemInSlot(20).getType() == Material.WRITABLE_BOOK) {
                // Mode II
                mode.put(b, 2);
            } else if (inv.getItemInSlot(19).getType() == Material.WRITABLE_BOOK && inv.getItemInSlot(20).getType() == Material.WRITTEN_BOOK) {
                // Mode II
                mode.put(b, 2);
            } else mode.put(b, 0);
            if (mode.get(b) > 0) {
                BookMeta sourceMeta = (BookMeta) input.getItemMeta();
                MachineRecipe r;
                if (mode.get(b) == 1) {
                    r = new MachineRecipe(sourceMeta.getPages().size() * 4, new ItemStack[]{}, new ItemStack[]{input});
                } else {
                    BookMeta copyMeta = (BookMeta) output.getItemMeta();
                    copyMeta.setPages(sourceMeta.getPages());
                    copyMeta.setGeneration(BookMeta.Generation.COPY_OF_ORIGINAL);
                    ItemStack c = output.clone();
                    c.setItemMeta(copyMeta);
                    r = new MachineRecipe(sourceMeta.getPages().size() * 4, new ItemStack[]{input}, new ItemStack[]{c});
                }
                getMachineProcessor().startOperation(b, new CraftingOperation(r));
            }
        }
    }
}