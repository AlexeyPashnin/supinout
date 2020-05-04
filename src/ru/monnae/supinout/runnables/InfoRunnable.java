package ru.monnae.supinout.runnables;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.plugin.start.Supinout;

public class InfoRunnable extends BukkitRunnable {
    private Player player;
    private UsersManager usersManager;

    public InfoRunnable(Player player){
        this.player = player;
        usersManager = Supinout.getInstance().getUsersManager();
    }
    @Override
    public void run() {
        if (!usersManager.isPlayerLogedUp(player.getUniqueId()))
            player.sendMessage("Вы не зарегистрированы. Пожалуйста, введите /signup <password>.");
        else if (!usersManager.isPlayerLogedIn(player.getUniqueId())) {
            player.sendMessage("Вы зарегистрированы. Пожалуйста, введите  /signin <password>.");
        } else this.cancel();
    }
}
