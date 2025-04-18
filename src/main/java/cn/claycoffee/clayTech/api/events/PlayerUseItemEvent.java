package cn.claycoffee.clayTech.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player used a ClayTech item. 当一个玩家使用粘土科技中的物品时触发.
 */
public class PlayerUseItemEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final ItemStack item;

    public PlayerUseItemEvent(Player player, ItemStack item) {
        this.player = player;
        this.item = item;
    }

    /**
     * @return the player.玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the item.物品
     */
    public ItemStack getItem() {
        return item;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}
