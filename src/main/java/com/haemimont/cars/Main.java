package com.haemimont.cars;
import com.haemimont.cars.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        String username = "atanas221ttt2112";
        String pass = "112345126122223";
        String email = "rrrsgkls3hf2@example.com";
        ApiRole apiRole = new ApiRole();
        apiRole.setUser("user");
        apiRole.setModerator("mod");
        ApiRequestForm req = new ApiRequestForm(new ApiRegistration(username,pass,email, new ApiRole().getRole()),
                new ApiLogin(username,pass),
                new ApiAuthorization());
        //logger.info(apiRole.getRole());
        /*List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("user");
        ApiRequestForm myApi = new ApiRequestForm("atanas2221","123456122223","gkls3123hf2@example.com",role);*/
        /*
        List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("mod");
        role.add("user");
        ApiRequestForm myApi = new ApiRequestForm("atanas1124412","123452261221212","gkasdals12123hf2@example.com",role);

        */
        try {
            logger.info(new MyHttpClient().getAuthorizationValue(req));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
