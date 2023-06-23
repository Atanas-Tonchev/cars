package com.haemimont.cars.api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.haemimont.cars.utils.ApiUriConfiguration;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class MyHttpClient {
    ApiUriConfiguration myApiUri = new ApiUriConfiguration();
    Gson gson = new GsonBuilder().create();


    public HttpResponse<String> testAll() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(myApiUri.getTestAllUri()))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> newRegistration(ApiObjectUtil myApi) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username",myApi.singUp.getUsername());
        jo.put("email",myApi.singUp.getEmail());
        jo.put("password" , myApi.singUp.getPassword());
        jo.put("role",myApi.singUp.getRoles());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(myApiUri.getSignupUri()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jo)))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> login(ApiObjectUtil myApi) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username",myApi.singIn.getUsername());
        jo.put("password" , myApi.singIn.getPassword());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(myApiUri.getSigninUri()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jo)))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestUser(ApiObjectUtil myApi) throws Exception {
        String result = getAuthorizationValue(myApi);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(myApiUri.getTestUserAuthUri()))
                .header("Authorization", result)
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }



    public HttpResponse<String> authTestAdmin(ApiObjectUtil myApi) throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(myApiUri.getTestAdminUri()))
                .header("Authorization", getAuthorizationValue(myApi))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestModerator(ApiObjectUtil myApi) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(myApiUri.getTestModeratorUri()))
                .header("Authorization", getAuthorizationValue(myApi))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public String getAuthorizationValue(ApiObjectUtil myApi) throws Exception {
        String[] strArr = new String[] {login(myApi).body()};
        String response = Arrays.toString(strArr);
        String result = null;

        List<ApiAuthorization> myApisList = gson.fromJson(response, new TypeToken<List<ApiAuthorization>>() {
        }.getType());
        for (ApiAuthorization api : myApisList){
            result = api.tokenType+ " " +api.accessToken;
        }

        return result;
    }

}
