package com.haemimont.cars.tests;
import com.haemimont.cars.api.ApiObjectUtil;
import com.haemimont.cars.api.ApiResponseMessages;
import com.haemimont.cars.api.MyHttpClient;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegrationTestApi {
    private static final Logger logger = LogManager.getLogger(IntegrationTestApi.class);
    MyHttpClient myHttpClient = new MyHttpClient();
    ApiResponseMessages messages = new ApiResponseMessages();

    public int whenConnSuccessMakeSingUpSingInCheckAuth(ApiObjectUtil object) throws Exception {
        int result = new MyHttpClient().testAll().statusCode();
        if(result == HttpStatus.SC_OK){

            if(myHttpClient.newRegistration(object).body().equals(messages.getSuccessRegMessage().toString())){
                logger.info("Registration success!");
            }else if(myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageAlreadyTaken().toString())){
                logger.error("The User is already taken!");
            }else if(myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageUnauthorized().toString())){
                logger.error("Unauthorized Error!");
            }else {
                logger.error("Error!");
            }
            if(myHttpClient.login(object).body().equals(messages.getErrorLoginMessageUnauthorized().toString())){
                logger.error("Something wrong! Your username or password is incorrect.");
            }else {
                logger.info("Login success!");
            }

            if(myHttpClient.authTestAdmin().body().equals(messages.getSuccessAuthAdminMessage())){
                logger.info("The User have ADMINISTRATOR access.");
            }else if(myHttpClient.authTestAdmin().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have ADMINISTRATOR access.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestUser().body().equals(messages.getSuccessAuthUserMessage())){
                logger.info("The User have USER access.");
            }else if(myHttpClient.authTestUser().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have USER access.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestModerator().body().equals(messages.getSuccessAuthModMessage())){
                logger.info("The User have MODERATOR access.");
            }else if(myHttpClient.authTestModerator().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                logger.error("The User doesn't have MODERATOR access.");
            }else {
                logger.error("Error! Please check your login or registration!");
            }
            return HttpStatus.SC_OK;

        }else {
            logger.error("Connection field! Please try again!");
            return HttpStatus.SC_UNAUTHORIZED;
        }
    }
}
