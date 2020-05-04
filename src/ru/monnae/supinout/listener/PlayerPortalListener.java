package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerPortalListener implements Listener {
    private UsersManager usersManager;

    public PlayerPortalListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
