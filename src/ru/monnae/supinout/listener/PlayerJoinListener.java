package ru.monnae.supinout.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.runnables.InfoRunnable;

public class PlayerJoinListener implements Listener {
    private Supinout instance;

    public PlayerJoinListener() {
        this.instance = Supinout.getInstance();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        InfoRunnable freezeRunnable = new InfoRunnable(event.getPlayer());
        freezeRunnable.runTaskTimer(instance, 0L, 100L);
    }
}