package com.haemimont.cars;

import com.haemimont.cars.funny.Jokes;
import com.haemimont.cars.funny.JokesAppClient;

public class Main {
    public static void main(String[] args) {

        try {
           // System.out.println(new JokesAppClient().syncGson().getSetup());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
