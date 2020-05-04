package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.plugin.start.Supinout;

public class AsyncPlayerChatListener implements Listener {
    private UsersManager usersManager;

    public AsyncPlayerChatListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (!usersManager.isPlayerLogedIn(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
