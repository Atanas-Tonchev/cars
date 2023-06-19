package com.haemimont.cars;
import com.haemimont.cars.api.MyApi;
import com.haemimont.cars.api.MyHttpClient;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("user");
        MyApi myApi = new MyApi("atanas2221","123456122223","gkls3123hf2@example.com",role);*/
        List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("mod");
        role.add("user");
        MyApi myApi = new MyApi("atanas11212","1234561221212","gkls12123hf2@example.com",role);

        try {
            System.out.println(new MyHttpClient().authTestModerator(myApi).body());
            System.out.println(new MyHttpClient().authTestUser(myApi).body());
            System.out.println(new MyHttpClient().authTestAdmin(myApi).body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
