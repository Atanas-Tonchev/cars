package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHttpClientIntegrationTest {
    private ApiResponseMessages messages;
    private static  int statusSuccess;
    private static final Logger logger = LogManager.getLogger(MyHttpClientIntegrationTest.class);
    private int resultStatusCode;
    private HttpResponse<String> singUp;
    private HttpResponse<String> singIn;
    private HttpResponse<String> testAdmin;
    private HttpResponse<String> testUser;
    private HttpResponse<String> testMod;

    @BeforeEach
    void setUp() throws Exception {
        MyHttpClient myHttpClient = new MyHttpClient();
        messages = new ApiResponseMessages();
        String username = "Atanas1990";
        String pass = "betimoni2215";
        String email = "rrrasgkl0s3hf2@example.com";
        List<String> userRoles = new ArrayList<>();
        userRoles.add(UserRole.MODERATOR);
        userRoles.add(UserRole.USER);
        ApiObjectUtil requestForm = new ApiObjectUtil(new ApiRegistration(username, pass, email, userRoles),
                new ApiLogin(username, pass), new ApiAuthorization());
        statusSuccess = HttpStatus.SC_OK;
        resultStatusCode = myHttpClient.testAll().statusCode();
        singUp = myHttpClient.newRegistration(requestForm);
        singIn = myHttpClient.login(requestForm);
        testAdmin = myHttpClient.authTestAdmin();
        testUser = myHttpClient.authTestUser();
        testMod = myHttpClient.authTestModerator();
    }

    @Test
      public void whenConnSuccessCheckAllResponseMessages() {

        if(statusSuccess!=resultStatusCode){
            logger.error("Connection field! Please try again!");
        }
        if(statusSuccess==resultStatusCode){

            if(singUp.body().equals(messages.getSuccessRegMessage().toString())){
                logger.info("Registration success!");
            }else if(singUp.body().equals(messages.getErrorRegMessageAlreadyTaken().toString())){
                logger.error("The User is already taken!");
            }else if(singUp.body().equals(messages.getErrorRegMessageUnauthorized().toString())){
                logger.error("Unauthorized Error!");
            }else {
                logger.error("Error!");
            }

            if(singIn.body().equals(messages.getErrorLoginMessageUnauthorized().toString())){
                logger.error("Something wrong! Your username or password is incorrect.");
            }else {
                logger.info("Login success!");
            }

            if(testAdmin.body().equals(messages.getSuccessAuthAdminMessage())){
                logger.info("The User have ADMINISTRATOR provisions.");
            }else if(testAdmin.body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have ADMINISTRATOR provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(testUser.body().equals(messages.getSuccessAuthUserMessage())){
                logger.info("The User have USER provisions.");
            }else if(testUser.body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have USER provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(testMod.body().equals(messages.getSuccessAuthModMessage())){
                logger.info("The User have MODERATOR provisions.");
            }else if(testMod.body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have MODERATOR provisions.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }
        }

        assertEquals(statusSuccess,HttpStatus.SC_OK);
        logger.info("Integration test complete success!");
    }

    @Test
    public void whenConnSuccessCheckAllResponseCodes() {

        if(statusSuccess!=resultStatusCode){
            logger.error("Connection field! Please try again!");
        }
        if(statusSuccess==resultStatusCode){
            if(statusSuccess==singUp.statusCode()){
                assertEquals(HttpStatus.SC_OK,statusSuccess);
                logger.info("New registration success!");
            }else {
                logger.error("Error! This User already exist!");
            }
            if(statusSuccess==singIn.statusCode()){
                assertEquals(HttpStatus.SC_OK,statusSuccess);
                if(statusSuccess==testAdmin.statusCode()){
                    assertEquals(HttpStatus.SC_OK,statusSuccess);
                    logger.info("You have ADMINISTRATOR provisions.");
                    logger.info("and");
                }else {
                    logger.error("You don't have ADMINISTRATOR provisions.");
                    logger.info("and");
                }
                if(statusSuccess==testUser.statusCode()){
                    assertEquals(HttpStatus.SC_OK,statusSuccess);
                    logger.info("You have USER provisions.");
                    logger.info("and");
                }else {
                    logger.error("You don't have USER provisions.");
                    logger.info("and");
                }
                if(statusSuccess==testMod.statusCode()){
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