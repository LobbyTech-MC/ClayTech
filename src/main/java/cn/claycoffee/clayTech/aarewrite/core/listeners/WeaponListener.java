package cn.claycoffee.clayTech.aarewrite.core.listeners;

import cn.claycoffee.clayTech.utils.Affect;
import cn.claycoffee.clayTech.utils.Utils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class WeaponListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.isCancelled()) return;
        if (e.getDamager().getType() == EntityType.ARROW) {
            try {
                Player d = (Player) ((Projectile) e.getDamager()).getShooter();
                Player p = (Player) e.getEntity();
                Affect.AffectCheck(d, p);
            } catch (Exception ignored) {
            }
        } else {
            if (e.getDamager().getType() == EntityType.PLAYER && e.getEntity().getType() == EntityType.PLAYER) {
                Player d = (Player) e.getDamager();
                Player p = (Player) e.getEntity();
                Affect.AffectCheck(d, p);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.PLAYER) {
            Player d = e.getPlayer();
            try {
                if (Utils.ExistInList("§7钩子武器", Utils.getLore(d.getInventory().getItemInMainHand()))) {
                    Player p = (Player) e.getRightClicked();
                    Affect.AffectCheck(d, p);
                }
            } catch (Exception ignored) {

            }
        }
    }
}
