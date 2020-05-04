package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class EntityDamageByEntityListener implements Listener {
    private UsersManager usersManager;

    public EntityDamageByEntityListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Player playerDamager;
        if (event.getDamager() instanceof Player) {
            playerDamager = (Player) event.getDamager();
            if (!usersManager.isPlayerLogedIn(playerDamager.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

}
