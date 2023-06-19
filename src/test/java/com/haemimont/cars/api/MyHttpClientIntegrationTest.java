package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHttpClientIntegrationTest {
    MyHttpClient myHttpClient = new MyHttpClient();
    @Test
      public void ifConnSuccess_MakeNewReg_Login_Auth() throws Exception {
        int statusSuccess = HttpStatus.SC_OK;
        List<String> role = new ArrayList<>();
        role.add("admin");
        role.add("user");
        role.add("mod");
        RequestForm requestForm = new RequestForm("Atanas131212431","12222223625143423","rvababagklasV@example.com",role);
        if(statusSuccess!=myHttpClient.testAll().statusCode()){
            System.out.println("Connection field!");
        }
        if(statusSuccess==myHttpClient.testAll().statusCode()){
            statusSuccess = myHttpClient.newRegistration(requestForm).statusCode();
            assertEquals(200,statusSuccess);
            statusSuccess = myHttpClient.login(requestForm).statusCode();
            assertEquals(200,statusSuccess);
            statusSuccess = myHttpClient.authTestAdmin(requestForm).statusCode();
            assertEquals(200,statusSuccess);
            statusSuccess = myHttpClient.authTestUser(requestForm).statusCode();
            assertEquals(200,statusSuccess);
            statusSuccess = myHttpClient.authTestModerator(requestForm).statusCode();
            assertEquals(200,statusSuccess);
        }
        if(statusSuccess==HttpStatus.SC_OK){
            System.out.println("Integration test complete success!");
        }
    }
}