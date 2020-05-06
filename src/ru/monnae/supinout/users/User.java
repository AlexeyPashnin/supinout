package ru.monnae.supinout.users;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private UUID userUuid;
    private Integer passwordHash;
    private transient boolean isLogedIn;

    public User(UUID userUuid, Integer passwordHash, boolean isLogedIn) {
        this.userUuid = userUuid;
        this.passwordHash = passwordHash;
        this.isLogedIn = isLogedIn;
    }

    public UUID getUserUuid() {
        return this.userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public Integer getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(Integer passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isLogedIn() {
        return this.isLogedIn;
    }

    public void setLogedIn(boolean logedIn) {
        isLogedIn = logedIn;
    }
}
