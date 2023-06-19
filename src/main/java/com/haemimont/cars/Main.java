package com.haemimont.cars;
import com.haemimont.cars.api.RequestForm;
import com.haemimont.cars.api.MyHttpClient;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("user");
        RequestForm myApi = new RequestForm("atanas2221","123456122223","gkls3123hf2@example.com",role);*/
        List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("mod");
        role.add("user");
        RequestForm myApi = new RequestForm("atanas1124412","123452261221212","gkasdals12123hf2@example.com",role);


        try {

            System.out.println(new MyHttpClient().authTestModerator(myApi).body());
            System.out.println(new MyHttpClient().authTestUser(myApi).body());
            System.out.println(new MyHttpClient().authTestAdmin(myApi).body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
