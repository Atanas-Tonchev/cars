package com.haemimont.cars.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHttpClientConnectionUnitTest {

    @Test
    public void checkConnectionByResponseStatus(){
        try {
            assertEquals(200,new MyHttpClient().testAll().statusCode());
            System.out.println("Connection success!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}