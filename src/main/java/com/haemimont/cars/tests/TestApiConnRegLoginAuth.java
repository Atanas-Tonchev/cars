package com.haemimont.cars.tests;
import com.haemimont.cars.api.ApiObjectUtil;
import com.haemimont.cars.api.ApiResponseMessages;
import com.haemimont.cars.api.MyHttpClient;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class TestApiConnRegLoginAuth {
    MyHttpClient myHttpClient = new MyHttpClient();
    ApiResponseMessages messages = new ApiResponseMessages();
    ApiReceivingMessages receivingMessages = new ApiReceivingMessages();

    public int whenConnSuccessMakeSingUpSingInCheckAuth(ApiObjectUtil object) throws Exception {
        List<String> list = new ArrayList<>();
        receivingMessages.setMap(list);
        int result = new MyHttpClient().testAll().statusCode();
        if(result == HttpStatus.SC_OK){

            if(myHttpClient.newRegistration(object).body().equals(messages.getSuccessRegMessage().toString())){
                list.add("Registration success!");
            }else if(myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageAlreadyTaken().toString())){
                list.add("The User is already taken!");
            }else if(myHttpClient.newRegistration(object).body().equals(messages.getErrorRegMessageUnauthorized().toString())){
                list.add("Unauthorized Error!");
            }else {
                list.add("Error!");
            }
            if(myHttpClient.login(object).body().equals(messages.getErrorLoginMessageUnauthorized().toString())){
                list.add("Something wrong! Your username or password is incorrect.");
            }else {
                list.add("Login success!");
            }

            if(myHttpClient.authTestAdmin().body().equals(messages.getSuccessAuthAdminMessage())){
                list.add("The User have ADMINISTRATOR access.");
            }else if(myHttpClient.authTestAdmin().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                list.add("The User doesn't have ADMINISTRATOR access.");
            }else {
                list.add("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestUser().body().equals(messages.getSuccessAuthUserMessage())){
                list.add("The User have USER access.");
            }else if(myHttpClient.authTestUser().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                list.add("The User doesn't have USER access.");
            }else {
                list.add("Error! Please check your login or registration!");
            }

            if(myHttpClient.authTestModerator().body().equals(messages.getSuccessAuthModMessage())){
                list.add("The User have MODERATOR access.");
            }else if(myHttpClient.authTestModerator().body().equals(messages.getErrorAuthMessageUnauthorized().toString())) {
                list.add("The User doesn't have MODERATOR access.");
            }else {
                list.add("Error! Please check your login or registration!");
            }
            return HttpStatus.SC_OK;

        }else {
            list.add("Connection field! Please try again!");
            return HttpStatus.SC_UNAUTHORIZED;
        }
    }
}
