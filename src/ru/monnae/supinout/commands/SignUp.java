package ru.monnae.supinout.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.monnae.supinout.plugin.console.ConsoleMessage;
import ru.monnae.supinout.plugin.start.Supinout;
import ru.monnae.supinout.users.UsersManager;

public class SignUp implements CommandExecutor {
    private Supinout instance;
    private UsersManager usersManager;

    public SignUp() {
        this.instance = Supinout.getInstance();
        this.usersManager = instance.getUsersManager();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length != 1) {
            String error = instance.getCommand("signup").getUsage();
            commandSender.sendMessage(ConsoleMessage.getError(error));
        } else if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            usersManager.logUpPlayer(player.getUniqueId(), strings[0].hashCode());

            String info = String.format("%s, Вы успешно зарегистрированы.", player.getName());
            commandSender.sendMessage(ConsoleMessage.getInfo(info));
        } else if (strings[0].length() < 6 || strings[0].length() > 20) {
            String warning = "Длина пароля не может быть менее 6 или более 20 символов.";
            commandSender.sendMessage(ConsoleMessage.getWarning(warning));
        } else {
            String error = "Отправителем команды может быть только игрок.";
            commandSender.sendMessage(ConsoleMessage.getError(error));
        }
        return true;
    }
}
