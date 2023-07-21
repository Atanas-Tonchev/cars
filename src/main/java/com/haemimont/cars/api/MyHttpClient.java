package com.haemimont.cars.api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class MyHttpClient {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new GsonBuilder().create();
    private static String authValue;

    public HttpResponse<String> testAll() throws Exception {
        return httpClient.send(HttpRequest.newBuilder()
                .uri(new URI(ApiUriConfiguration.TEST_ALL_URI))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> newRegistration(ApiObjectUtil myApi) throws Exception {
        JSONObject object = new JSONObject()
                .put("username", myApi.singUp.getUsername())
                .put("email", myApi.singUp.getEmail())
                .put("password", myApi.singUp.getPassword())
                .put("role", myApi.singUp.getRoles());

        return httpClient.send(HttpRequest.newBuilder()
                .uri(new URI(ApiUriConfiguration.SIGNUP_URI))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(object)))
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> login(ApiObjectUtil myApi) throws Exception {
        JSONObject object = new JSONObject()
                .put("username", myApi.singIn.getUsername())
                .put("password", myApi.singIn.getPassword());

        HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                .uri(new URI(ApiUriConfiguration.SIGNIN_URI))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(object)))
                .build(), HttpResponse.BodyHandlers.ofString());

        authValue = setAuthorizationValue(response.body());

        return response;
    }

    public HttpResponse<String> authTestUser() throws Exception {

        return httpClient.send(HttpRequest.newBuilder()
                .GET()
                .uri(new URI(ApiUriConfiguration.TEST_USER_AUTH_URI))
                .header("Authorization", authValue)
                .build(), HttpResponse.BodyHandlers.ofString());
    }


    public HttpResponse<String> authTestAdmin() throws Exception {

        return httpClient.send(HttpRequest.newBuilder()
                .GET()
                .uri(new URI(ApiUriConfiguration.TEST_ADMIN_AUTH_URI))
                .header("Authorization", authValue)
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestModerator() throws Exception {

        return httpClient.send(HttpRequest.newBuilder()
                .GET()
                .uri(new URI(ApiUriConfiguration.TEST_MODERATOR_AUTH_URI))
                .header("Authorization", authValue)
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    public String setAuthorizationValue(String httpResponse) {
        List<ApiAuthorization> myApiList = gson.fromJson(Arrays.toString(new String[]{httpResponse}), new TypeToken<List<ApiAuthorization>>() {
        }.getType());

        return myApiList.get(0).getAuthorization();
    }
}
