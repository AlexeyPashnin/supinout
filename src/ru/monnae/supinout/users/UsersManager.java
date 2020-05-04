package ru.monnae.supinout.users;

import ru.monnae.supinout.files.FileManager;
import ru.monnae.supinout.plugin.start.Supinout;

import java.util.ArrayList;
import java.util.UUID;

public class UsersManager {
    private Supinout instance;
    private ArrayList<User> users;
    private FileManager fileManager;

    public UsersManager() {
        this.instance = Supinout.getInstance();
        this.users = new ArrayList<>();
        this.fileManager = instance.getFileManager();

        ArrayList<String> usersFilesNames = fileManager
                .getFilesNames(fileManager.getPlayersDirectoryPath());
        for (String fileName : usersFilesNames) {
            User user = (User)
                    fileManager.readFile(fileManager.getPlayersDirectoryPath(), fileName);
            user.isLogedIn = false;
            users.add(user);
        }
    }

    public boolean logInPlayer(UUID playerUuid) {
        for (User user : users)
            if (user.userUuid.equals(playerUuid)) {
                user.isLogedIn = true;
                return true;
            }
        return false;
    }

    public boolean logUpPlayer(UUID playerUuid, Integer passwordHash) {
        for (User user : users)
            if (user.userUuid.equals(playerUuid)) {
                return false;
            }
        User user = new User(playerUuid, passwordHash, true);
        users.add(user);
        fileManager.writeFile(fileManager.getPlayersDirectoryPath(), playerUuid.toString(), user);
        return true;
    }

    public boolean logOutPlayer(UUID playerUuid) {
        for (User user : users)
            if (user.userUuid.equals(playerUuid)) {
                user.isLogedIn = false;
                return true;
            }
        return false;
    }

    public boolean isPlayerLogedUp(UUID playerUuid) {
        for (User user : users) if (user.userUuid.equals(playerUuid)) return true;
        return false;
    }

    public boolean isPlayerLogedIn(UUID playerUuid) {
        for (User user : users) if (user.userUuid.equals(playerUuid)) return user.isLogedIn;
        return false;
    }

    public Integer getPlayerPasswordHash(UUID playerUuid) {
        for (User user : users)
            if (user.userUuid.equals(playerUuid)) {
                return user.passwordHash;
            }
        return null;
    }
}
