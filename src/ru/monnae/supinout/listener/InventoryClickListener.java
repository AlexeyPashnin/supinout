package ru.monnae.supinout.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class InventoryClickListener implements Listener {
    private UsersManager usersManager;

    public InventoryClickListener() {
        this.usersManager = Supinout.getInstance().getUsersManager();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player;
        if (event.getWhoClicked() instanceof Player) {
            player = (Player) event.getWhoClicked();
            if (!usersManager.isPlayerLogedIn(player.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}
