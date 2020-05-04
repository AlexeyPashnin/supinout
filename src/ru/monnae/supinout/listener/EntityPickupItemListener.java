package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class EntityPickupItemListener implements Listener {
    private UsersManager usersManager;

    public EntityPickupItemListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        Player player;
        if (event.getEntity() instanceof Player) {
            player = (Player) event.getEntity();
            if (!usersManager.isPlayerLogedIn(player.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}
