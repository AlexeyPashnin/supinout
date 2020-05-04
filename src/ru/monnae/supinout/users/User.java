package ru.monnae.supinout.users;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    public UUID userUuid;
    public Integer passwordHash;
    public transient boolean isLogedIn;

    public User(UUID userUuid, Integer passwordHash, boolean isLogedIn){
        this.userUuid = userUuid;
        this.passwordHash = passwordHash;
        this.isLogedIn = isLogedIn;
    }
}
