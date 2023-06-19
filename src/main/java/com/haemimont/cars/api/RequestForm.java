package com.haemimont.cars.api;
import java.util.List;

public class RequestForm {
    private String username;
    private final String password;
    private final String email;
    private final List<String> role;
    String accessToken;
    String tokenType;

    public RequestForm(String username, String password, String email, List<String> role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public List<String> getRole() {
        return role;
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
    public String getEmail() {
        return email;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
}