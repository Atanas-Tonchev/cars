package com.haemimont.cars.utils;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiUriConfiguration {
    private static final String uriBase = "http://192.168.250.206:8080/api/";
    private static final String testAllUri = "languages/../test/all";
    private static final String signupUri = "languages/../auth/signup";
    private static final String signinUri = "languages/../auth/signin";
    private static final String testUserAuthUri = "languages/../test/user";
    private static final String testAdminUri = "languages/../test/admin";
    private static final String testModeratorUri = "languages/../test/mod";

    public String getTestAllUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(testAllUri);
        return uriResolve.toString();
    }
    public String getSignupUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(signupUri);
        return uriResolve.toString();
    }
    public String getSigninUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(signinUri);
        return uriResolve.toString();
    }
    public String getTestUserAuthUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(testUserAuthUri);
        return uriResolve.toString();
    }
    public String getTestAdminUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(testAdminUri);
        return uriResolve.toString();
    }
    public String getTestModeratorUri() throws URISyntaxException {
        URI uri = new URI(uriBase);
        URI uriResolve = uri.resolve(testModeratorUri);
        return uriResolve.toString();
    }
}
