package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHttpClientIntegrationTest {
    MyHttpClient myHttpClient = new MyHttpClient();
    private static Logger logger = LogManager.getLogger(MyHttpClientIntegrationTest.class);

    MyHttpClientIntegrationTest() throws URISyntaxException {
    }

    @Test
      public void whenConnSuccessMakeNewRegThanLoginAndCheckAuth() throws Exception {
        int statusSuccess = HttpStatus.SC_OK;
        String username = "atanas0112";
        String pass = "112345";
        String email = "rrs3hf2@example.com";
        ApiRole apiRole = new ApiRole();
        apiRole.setUser("user");
        apiRole.setModerator("mod");
        ApiRequestForm requestForm = new ApiRequestForm(new ApiRegistration(username,pass,email,
                new ApiRole().getRole()),
                new ApiLogin(username,pass),
                new ApiAuthorization());
        if(statusSuccess!=myHttpClient.testAll().statusCode()){
            logger.error("Connection field! Please try again!");
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
            logger.info("Integration test complete success!");
        }
    }
}