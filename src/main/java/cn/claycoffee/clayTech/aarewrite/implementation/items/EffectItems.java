package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.aarewrite.api.events.PlayerUseItemEvent;
import cn.claycoffee.clayTech.aarewrite.core.listeners.ItemUseListener;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import cn.claycoffee.clayTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class EffectItems {
    public EffectItems() {
        // rewrite
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_EFFECT_ITEM_I"))
                .withCost(30)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_TOOLS)
                                .withItem(ClayTechItems.TNT_EXPLOSION_CREATER)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.TNT_EXPLOSION_CREATER)
                                .withHandlers((ItemUseHandler) e -> {
                                    Bukkit.getPluginManager().callEvent(new PlayerUseItemEvent(e.getPlayer(), e.getItem()));
                                    boolean pass = false;
                                    String md = Utils.readPlayerMetadataString(e.getPlayer(), "lastUseTNTCreaterTime");
                                    if (System.currentTimeMillis() >= Long.parseLong(md) + 5000L) {
                                        pass = true;
                                    }

                                    if (!pass) {
                                        e.getPlayer().sendMessage(Lang.readGeneralText("TNT_EXPLOSION_CREATER_CD"));
                                        return;
                                    }

                                    if (!e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.TNT), 1)) {
                                        e.getPlayer().sendMessage(Lang.readGeneralText("TNT_EXPLOSION_CREATER_NO_TNT"));
                                        return;
                                    }


                                    Location currentLoc = e.getPlayer().getLocation();
                                    Inventory inv = e.getPlayer().getInventory();
                                    ItemStack TNT = inv.getItem(inv.first(Material.TNT));
                                    TNT.setAmount(TNT.getAmount() - 1);
                                    ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
                                    //ClayItem.setDurability(tool, ClayItem.getDurability(tool) - 1);
                                    e.getPlayer().sendMessage(Lang.readGeneralText("TNT_EXPLOSION_CREATER_WAIT"));
                                    Utils.setPlayerMetadata(e.getPlayer(), "lastUseTNTCreaterTime", System.currentTimeMillis() + "");
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            e.getPlayer().getWorld().spawnEntity(currentLoc, EntityType.PRIMED_TNT);
                                            Block center = currentLoc.add(0, -1, 0).getBlock();
                                            center.setMetadata("isExplosionCreater", new FixedMetadataValue(ClayTech.getInstance(), true));
                                            ItemUseListener.player.put(center, e.getPlayer().getName());
                                            return;
                                        }

                                    }.runTaskLater(ClayTech.getInstance(), 100);
                                })
                                .build())
                .build();
    }
}
