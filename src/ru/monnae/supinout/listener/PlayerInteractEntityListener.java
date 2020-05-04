package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerInteractEntityListener implements Listener {
    private UsersManager usersManager;

    public PlayerInteractEntityListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
