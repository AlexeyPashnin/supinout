package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class PlayerCommandPreprocessListener implements Listener {
    private UsersManager usersManager;

    public PlayerCommandPreprocessListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().split(" ")[0].toLowerCase();
        String signUpCommand = "/signup";
        String signInCommand = "/signin";

        boolean isPlayerAbleToUseCommand = command.equalsIgnoreCase(signUpCommand)
                || command.equalsIgnoreCase(signInCommand);

        if (!isPlayerAbleToUseCommand) {
            event.setCancelled(true);
        }
    }
}
