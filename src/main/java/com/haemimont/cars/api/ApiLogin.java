package com.haemimont.cars.api;
public class ApiLogin {
    private final String username;
    private final String password;

    public ApiLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}