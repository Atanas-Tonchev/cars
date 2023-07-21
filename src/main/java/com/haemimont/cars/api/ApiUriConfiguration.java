package com.haemimont.cars.api;

public enum ApiUriConfiguration {
    ;
    public static final String URI_BASE = "http://192.168.250.206:8080/api";

    public static final String PATH_TEST = "/test";

    public static final String PATH_AUTH = "/auth";

    public static final String TEST_ALL_URI = URI_BASE + PATH_TEST + "/all";

    public static final String SIGNUP_URI = URI_BASE + PATH_AUTH + "/signup";

    public static final String SIGNIN_URI = URI_BASE + PATH_AUTH + "/signin";

    public static final String TEST_USER_AUTH_URI = URI_BASE + PATH_TEST + "/user";

    public static final String TEST_ADMIN_AUTH_URI = URI_BASE + PATH_TEST + "/admin";

    public static final String TEST_MODERATOR_AUTH_URI = URI_BASE + PATH_TEST + "/mod";

}
