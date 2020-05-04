package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerPickupArrowListener implements Listener {
    private UsersManager usersManager;

    public PlayerPickupArrowListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerPickupArrow(PlayerPickupArrowEvent event){
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
