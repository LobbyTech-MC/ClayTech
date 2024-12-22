package cn.claycoffee.clayTech.aarewrite.api.abstracts;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.inventory.ItemStack;

public abstract class ANewContainer extends AbstractMachine {
    public ANewContainer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
                         ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
}