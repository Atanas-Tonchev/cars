package com.haemimont.cars.api;

public class ApiAuthorization {
    protected String accessToken;
    protected String tokenType;

    public String getAuthorization(){
        return tokenType+ " " +accessToken;
    }

}
