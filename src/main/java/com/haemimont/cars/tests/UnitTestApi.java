package com.haemimont.cars.tests;
import com.haemimont.cars.api.ApiObjectUtil;
import com.haemimont.cars.api.ApiResponseMessages;
import com.haemimont.cars.api.MyHttpClient;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class UnitTestApi {
    private static final Logger logger = LogManager.getLogger(UnitTestApi.class);
    MyHttpClient myHttpClient = new MyHttpClient();
    ApiResponseMessages messages = new ApiResponseMessages();
    private static final int success = HttpStatus.SC_OK;

    public int getConnectionTest() {
        int result;
        try {
            result = new MyHttpClient().testAll().statusCode();
            if (result == success) {
                logger.info("Connection success!");
            } else {
                logger.error("Connection failed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void connectionThread() throws InterruptedException {
            int result;
            try {
                result = new MyHttpClient().testAll().statusCode();
                if (result == success) {
                    logger.info("CONNECTION SUCCESS!");
                } else {
                    logger.error("CONNECTION FIELD");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public void registrationThread(ApiObjectUtil object) throws InterruptedException {
        try {
            if (myHttpClient.newRegistration(object).body().equals(messages.getSuccessRegMessage().toString())) {
                logger.info("Registration success!");
            } else if (myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageAlreadyTaken().toString())) {
                logger.error("The User is already taken!");
            } else if (myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageUnauthorized().toString())) {
                logger.error("Unauthorized Error!");
            } else {
                logger.error("Error!");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loginThread(ApiObjectUtil object) throws InterruptedException {
        try {
            if(myHttpClient.login(object).body().equals(messages.getErrorLoginMessageUnauthorized().toString())){
                logger.error("Something wrong! Your username or password is incorrect.");
            }else {
                logger.info("Login success!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void authThread() throws Exception {

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
    }

}
