package ru.monnae.supinout.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class EntityAirChangeListener implements Listener {
    private UsersManager usersManager;

    public EntityAirChangeListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onEntityAirChange(EntityAirChangeEvent event) {
        Player player;
        if (event.getEntity()instanceof Player) {
            player = (Player) event.getEntity();
            if (!usersManager.isPlayerLogedIn(player.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}
