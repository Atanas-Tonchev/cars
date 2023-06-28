package com.haemimont.cars.api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyHttpClientUnitTest {
    private static Logger logger = LogManager.getLogger(MyHttpClientUnitTest.class);
    @Test
    public void checkConnectionByResponseStatus(){
        try {
            assertEquals(200,new MyHttpClient().testAll().statusCode());
            logger.info("Connection success!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}