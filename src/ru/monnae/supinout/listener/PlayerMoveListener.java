package ru.monnae.supinout.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.plugin.start.Supinout;

public class PlayerMoveListener implements Listener {
    private UsersManager usersManager;

    public PlayerMoveListener(){
        this.usersManager = Supinout.getInstance().getUsersManager();
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
