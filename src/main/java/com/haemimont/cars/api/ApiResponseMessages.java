package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

public class ApiResponseMessages {

    protected JSONObject getSuccessRegMessage(){
        JSONObject jo = new JSONObject();
        jo.put("message","User registered successfully!");
        return jo;
    }

    protected JSONObject getErrorRegMessageAlreadyTaken(){
        JSONObject jo = new JSONObject();
        jo.put("message","Error: Username is already taken!");
        return jo;
    }

    protected JSONObject getErrorRegMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("path","/error");
        jo.put("error","Unauthorized");
        jo.put("message","Full authentication is required to access this resource");
        jo.put("status",statusCode);
        return jo;
    }

    protected JSONObject getErrorLoginMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("path","/api/auth/signin");
        jo.put("error","Unauthorized");
        jo.put("message","Bad credentials");
        jo.put("status",statusCode);
        return jo;
    }
    protected String getSuccessAuthUserMessage(){
        return "User Content.";
    }
    protected String getSuccessAuthModMessage(){
        return "Moderator Board.";
    }
    protected String getSuccessAuthAdminMessage(){
        return "Admin Board.";
    }
    protected JSONObject getErrorAuthMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("path","/error");
        jo.put("error","Unauthorized");
        jo.put("message","Full authentication is required to access this resource");
        jo.put("status",statusCode);
        return jo;
    }

}
