package com.haemimont.cars.api;

public class ApiRequestForm {
    ApiRegistration singUp;
    ApiLogin singIn;
    ApiAuthorization authorization;

    public ApiRequestForm(ApiRegistration singUp, ApiLogin singIn, ApiAuthorization authorization) {
        this.singUp = singUp;
        this.singIn = singIn;
        this.authorization = authorization;
    }
}