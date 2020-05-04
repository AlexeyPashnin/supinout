package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerLevelChangeListener implements Listener {
    private UsersManager usersManager;

    public PlayerLevelChangeListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerLevelChange(PlayerLevelChangeEvent event){
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.getPlayer().setLevel(event.getOldLevel());
        }
    }
}
