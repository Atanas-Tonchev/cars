package com.haemimont.cars.api;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
public class ApiResponseMessages {

    public JSONObject getSuccessRegMessage(){
        JSONObject jo = new JSONObject();
        jo.put("message","User registered successfully!");
        return jo;
    }

    public JSONObject getErrorRegMessageAlreadyTaken(){
        JSONObject jo = new JSONObject();
        jo.put("message","Error: Username is already taken!");
        return jo;
    }

    public JSONObject getErrorRegMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("loggPath","/error");
        jo.put("error","Unauthorized");
        jo.put("message","Full authentication is required to access this resource");
        jo.put("status",statusCode);
        return jo;
    }

    public JSONObject getErrorLoginMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("loggPath","/api/auth/signin");
        jo.put("error","Unauthorized");
        jo.put("message","Bad credentials");
        jo.put("status",statusCode);
        return jo;
    }
    public String getSuccessAuthUserMessage(){
        return "User Content.";
    }
    public String getSuccessAuthModMessage(){
        return "Moderator Board.";
    }
    public String getSuccessAuthAdminMessage(){
        return "Admin Board.";
    }
    public JSONObject getErrorAuthMessageUnauthorized(){
        int statusCode = HttpStatus.SC_UNAUTHORIZED;
        JSONObject jo = new JSONObject();
        jo.put("loggPath","/error");
        jo.put("error","Unauthorized");
        jo.put("message","Full authentication is required to access this resource");
        jo.put("status",statusCode);
        return jo;
    }

}
