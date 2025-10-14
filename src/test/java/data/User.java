package data;

import lombok.Getter;

@Getter
public enum User {

    //Usually password would be a secret
    STANDARD_USER("standard_user", "secret_sauce");

    private final String username;
    private final String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}