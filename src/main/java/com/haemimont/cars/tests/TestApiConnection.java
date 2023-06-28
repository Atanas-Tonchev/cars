package com.haemimont.cars.tests;
import com.haemimont.cars.api.MyHttpClient;
import org.apache.http.HttpStatus;

public class TestApiConnection {

    public String getConnectionTest() {
        int result;
        try {
            result = new MyHttpClient().testAll().statusCode();
            if(result == HttpStatus.SC_OK){
                return "Connection success!";
            }else {
                return "Connection field";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
