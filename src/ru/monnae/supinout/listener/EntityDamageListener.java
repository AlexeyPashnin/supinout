package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class EntityDamageListener implements Listener {
    private UsersManager usersManager;

    public EntityDamageListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Player playerDamaged;
        if (event.getEntity() instanceof Player) {
            playerDamaged = (Player) event.getEntity();
            if (!usersManager.isPlayerLogedIn(playerDamaged.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}
