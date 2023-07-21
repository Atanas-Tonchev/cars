package com.haemimont.cars;
import com.haemimont.cars.api.*;
import com.haemimont.cars.tests.IntegrationTestApi;
import com.haemimont.cars.tests.MultiThreadTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        String username = "Atanas1990";
        String pass = "betimoni2215";
        String email = "rrrrrrrsjsf@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil req = new ApiObjectUtil(new ApiRegistration(username, pass, email, userRoles),
                new ApiLogin(username, pass),
                new ApiAuthorization());

        MultiThreadTest test = new MultiThreadTest();
        IntegrationTestApi testApi = new IntegrationTestApi();

        //test.getThreadTestApi(req);
        //test.getThreadTestApiInnerLock(req);





        //File logFile = new File("C:\\Users\\User\\Desktop\\nasko\\logger.log");

    }
}

