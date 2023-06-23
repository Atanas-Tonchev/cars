package com.haemimont.cars.utils;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiUriConfiguration {

    private static final String URI_BASE = "http://192.168.250.206:8080/api";

    private static final String PATH_TEST = "/test";

    private static final String PATH_AUTH = "/auth";

    private static final String TEST_ALL_URI = URI_BASE + PATH_TEST + "/all";

    private static final String SIGNUP_URI = URI_BASE + PATH_AUTH + "/signup";

    private static final String SIGNIN_URI = URI_BASE + PATH_AUTH + "/signin";

    private static final String TEST_USER_AUTH_URI = URI_BASE + PATH_TEST + "/user";

    private static final String TEST_ADMIN_AUTH_URI = URI_BASE + PATH_TEST + "/admin";

    private static final String TEST_MODERATOR_AUTH_URI = URI_BASE + PATH_TEST + "/mod";

    public String getTestAllUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(TEST_ALL_URI);
        return uriResolve.toString();
    }

    public String getSignupUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(SIGNUP_URI);
        return uriResolve.toString();
    }

    public String getSigninUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(SIGNIN_URI);
        return uriResolve.toString();
    }

    public String getTestUserAuthUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(TEST_USER_AUTH_URI);
        return uriResolve.toString();
    }

    public String getTestAdminUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(TEST_ADMIN_AUTH_URI);
        return uriResolve.toString();
    }

    public String getTestModeratorUri() throws URISyntaxException {
        URI uri = new URI(URI_BASE);
        URI uriResolve = uri.resolve(TEST_MODERATOR_AUTH_URI);
        return uriResolve.toString();
    }
}
