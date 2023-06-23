package com.haemimont.cars;
import com.haemimont.cars.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        String username = "Atanas1990";
        String pass = "betimoni22";
        String email = "rrrsgkls3hf2@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil req = new ApiObjectUtil(new ApiRegistration(username,pass,email, userRoles),
                new ApiLogin(username,pass),
                new ApiAuthorization());
        //logger.info(apiRole.getRole());
        /*List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("user");
        ApiObjectUtil myApi = new ApiObjectUtil("atanas2221","123456122223","gkls3123hf2@example.com",role);*/
        /*
        List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("mod");
        role.add("user");
        ApiObjectUtil myApi = new ApiObjectUtil("atanas1124412","123452261221212","gkasdals12123hf2@example.com",role);

        */
        try {
            //logger.info(new MyHttpClient().authTestUser(req).body());

            //logger.info(new MyHttpClient().login(req).body());
            //logger.info(new LoginMessages().getErrorLoginMessageUnauthorized());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
