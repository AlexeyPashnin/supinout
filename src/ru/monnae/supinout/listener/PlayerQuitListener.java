package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerQuitListener implements Listener {
    private UsersManager usersManager;

    public PlayerQuitListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        usersManager.logOutPlayer(event.getPlayer().getUniqueId());
    }
}
