package com.haemimont.cars.api;

public class ApiAuthorization {
    protected String accessToken;
    protected String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
