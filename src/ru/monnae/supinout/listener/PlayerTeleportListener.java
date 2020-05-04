package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerTeleportListener implements Listener {
    private UsersManager usersManager;

    public PlayerTeleportListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
