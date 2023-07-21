package com.haemimont.cars.api;
public class ApiObjectUtil {
    ApiRegistration singUp;
    ApiLogin singIn;
    ApiAuthorization authorization;

    public ApiObjectUtil(ApiRegistration singUp, ApiLogin singIn, ApiAuthorization authorization) {
        this.singUp = singUp;
        this.singIn = singIn;
        this.authorization = authorization;
    }
}