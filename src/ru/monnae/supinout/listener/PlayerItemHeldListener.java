package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerItemHeldListener implements Listener {
    private UsersManager usersManager;

    public PlayerItemHeldListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event){
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
