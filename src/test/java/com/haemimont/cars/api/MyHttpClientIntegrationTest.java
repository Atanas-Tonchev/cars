package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHttpClientIntegrationTest {
    MyHttpClient myHttpClient = new MyHttpClient();
    ApiResponseMessages messages = new ApiResponseMessages();
    private static int statusSuccess = HttpStatus.SC_OK;
    private static String username = "Atanas1990";
    private static String pass = "betimoni2215";
    private static String email = "rrrasgkl0s3hf2@example.com";
    private static Logger logger = LogManager.getLogger(MyHttpClientIntegrationTest.class);
    private static List<String> userRoles;

    @Test
      public void whenConnSuccessCheckAllResponseMessages() throws Exception {

        userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil requestForm = new ApiObjectUtil(new ApiRegistration(username,pass,email, userRoles),
                new ApiLogin(username,pass),new ApiAuthorization());

        if(statusSuccess!=myHttpClient.testAll().statusCode()){
            logger.error("Connection field! Please try again!");
        }
        if(statusSuccess==myHttpClient.testAll().statusCode()){

            if(myHttpClient.newRegistration(requestForm).body().equals(messages.getSuccessRegMessage().toString())){
                logger.info("Registration success!");
            }else if(myHttpClient.newRegistration(requestForm).body().equals(messages.getErrorRegMessageAlreadyTaken().toString())){
                logger.error("The User is already taken!");
            }else if(myHttpClient.newRegistration(requestForm).body().equals(messages.getErrorRegMessageUnauthorized().toString())){
                logger.error("Unauthorized Error!");
            }else {
                logger.error("Error!");
            }

            if(myHttpClient.login(requestForm).body().equals(messages.getErrorLoginMessageUnauthorized().toString())){
               logger.error("Something wrong! Your username or password is incorrect.");
            }else {
                logger.info("Login success!");
            }

            if(myHttpClient.authTestAdmin(requestForm).body().equals(messages.getSuccessAuthAdminMessage())){
                logger.info("The User have ADMINISTRATOR provisions.");
            }else if(myHttpClient.authTestAdmin(requestForm).body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have ADMINISTRATOR provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestUser(requestForm).body().equals(messages.getSuccessAuthUserMessage())){
                logger.info("The User have USER provisions.");
            }else if(myHttpClient.authTestUser(requestForm).body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have USER provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestModerator(requestForm).body().equals(messages.getSuccessAuthModMessage())){
                logger.info("The User have MODERATOR provisions.");
            }else if(myHttpClient.authTestModerator(requestForm).body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have MODERATOR provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }
        }

        assertEquals(statusSuccess,HttpStatus.SC_OK);
        logger.info("Integration test complete success!");
    }

    @Test
    public void whenConnSuccessCheckAllResponseCodes() throws Exception {

        userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil requestForm = new ApiObjectUtil(new ApiRegistration(username,pass,email, userRoles),
                new ApiLogin(username,pass),new ApiAuthorization());

        if(statusSuccess!=myHttpClient.testAll().statusCode()){
            logger.error("Connection field! Please try again!");
        }
        if(statusSuccess==myHttpClient.testAll().statusCode()){
            if(statusSuccess==myHttpClient.newRegistration(requestForm).statusCode()){
                assertEquals(HttpStatus.SC_OK,statusSuccess);
                logger.info("New registration success!");
            }else {
                logger.error("Error! This User already exist!");
            }
            if(statusSuccess == myHttpClient.login(requestForm).statusCode()){
                logger.info("Welcome "+username);
                assertEquals(HttpStatus.SC_OK,statusSuccess);
                if(statusSuccess == myHttpClient.authTestAdmin(requestForm).statusCode()){
                    assertEquals(HttpStatus.SC_OK,statusSuccess);
                    logger.info("You have ADMINISTRATOR provisions.");
                    logger.info("and");
                }else {
                    logger.error("You don't have ADMINISTRATOR provisions.");
                    logger.info("and");
                }
                if(statusSuccess == myHttpClient.authTestUser(requestForm).statusCode()){
                    assertEquals(HttpStatus.SC_OK,statusSuccess);
                    logger.info("You have USER provisions.");
                    logger.info("and");
                }else {
                    logger.error("You don't have USER provisions.");
                    logger.info("and");
                }
                if(statusSuccess == myHttpClient.authTestModerator(requestForm).statusCode()){
                    assertEquals(HttpStatus.SC_OK,statusSuccess);
                    logger.info("You have MODERATOR provisions.");
                }else {
                    logger.error("You don't have MODERATOR provisions.");
                }
            }
        }
        if(statusSuccess==HttpStatus.SC_OK){
            logger.info("Test complete!");
        }else {
            logger.error("Error! Please check your registration or login");
        }
    }
}