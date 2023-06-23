package com.haemimont.cars.api;


import java.util.List;

public class ApiRegistration {
    private String username;
    private String password;
    private String email;
    private List<String> userRoles;

    public ApiRegistration(String username, String password, String email, List<String> userRoles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return userRoles;
    }

}
