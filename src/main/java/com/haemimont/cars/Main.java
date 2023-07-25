package com.haemimont.cars;
import com.haemimont.cars.api.*;
import com.haemimont.cars.tests.MultiThreadTest;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String username = "Atanas1990";
        String pass = "betimoni2215";
        String email = "rrrrrrrsjsf@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil req = new ApiObjectUtil(new ApiRegistration(username,pass,email, userRoles),
                new ApiLogin(username,pass),
                new ApiAuthorization());

        MultiThreadTest test = new MultiThreadTest();
        //test.getThreadTestApiInnerLock(req);
        try {
            test.getThreadTestApi(req);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

