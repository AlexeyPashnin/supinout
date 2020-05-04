package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.plugin.start.Supinout;

import java.util.UUID;

public class PlayerCommandPreprocessListener implements Listener {
    private UsersManager usersManager;

    public PlayerCommandPreprocessListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        UUID playerUuid = event.getPlayer().getUniqueId();
        String command = event.getMessage().split(" ")[0].toLowerCase();
        String signUpCommand = "/signup";
        String signInCommand = "/signin";
        boolean isPlayerAbleToUseCommand = !usersManager.isPlayerLogedUp(playerUuid)
                && command.equalsIgnoreCase(signUpCommand)
                || !usersManager.isPlayerLogedIn(playerUuid)
                && command.equalsIgnoreCase(signInCommand)
                || usersManager.isPlayerLogedIn(playerUuid);

        if (!isPlayerAbleToUseCommand) {
            event.setCancelled(true);
        }
    }
}
