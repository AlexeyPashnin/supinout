package ru.monnae.supinout.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.plugin.console.ConsoleMessage;
import ru.monnae.supinout.plugin.start.Supinout;

public class SignIn implements CommandExecutor {
    private UsersManager usersManager;

    public SignIn(){
        usersManager = Supinout.getInstance().getUsersManager();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length != 1) {
            String error = Supinout.getInstance().getCommand("signin").getUsage();
            commandSender.sendMessage(ConsoleMessage.getError(error));
        }
        else if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            Integer passwordHash = usersManager.getPlayerPasswordHash(player.getUniqueId());
            if (passwordHash == null) {
                String error = "Перед входом Вам необходимо зарегистрироваться!";
                commandSender.sendMessage(ConsoleMessage.getError(error));
            }

            if (strings[0].hashCode() != passwordHash) {
                String warning = "Вы ввели некорректный пароль. Попробуйте снова.";
                commandSender.sendMessage(ConsoleMessage.getWarning(warning));
            } else {
                String info = String.format("%s, Вы авторизованы.", player.getName());
                commandSender.sendMessage(ConsoleMessage.getInfo(info));
                usersManager.logInPlayer(player.getUniqueId());
            }

        } else {
            String error = "Отправителем команды может быть только игрок.";
            commandSender.sendMessage(ConsoleMessage.getError(error));
        }
        return true;
    }
}
