package com.haemimont.cars.api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class MyHttpClient {
    private final String url = "http://192.168.250.206:8080/api";
    Gson gson = new GsonBuilder().create();

    public HttpResponse<String> testAll() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String testAll = "/test/all";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+ testAll))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> newRegistration(MyApi myApi) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username",myApi.getUsername());
        jo.put("email",myApi.getEmail());
        jo.put("password" , myApi.getPassword());
        jo.put("role",myApi.getRole());
        HttpClient client = HttpClient.newHttpClient();
        String reg = "/auth/signup";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+ reg))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jo)))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> login(MyApi myApi) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username",myApi.getUsername());
        jo.put("password" , myApi.getPassword());
        HttpClient client = HttpClient.newHttpClient();
        String login = "/auth/signin";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+ login))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jo)))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestUser(MyApi myApi) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String testUser = "/test/user";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(url+ testUser))
                .header("Authorization", getAuthorizationValue(myApi))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestAdmin(MyApi myApi) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String testAdmin = "/test/admin";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(url+ testAdmin))
                .header("Authorization", getAuthorizationValue(myApi))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> authTestModerator(MyApi myApi) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String testModerator = "/test/mod";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(url+ testModerator))
                .header("Authorization", getAuthorizationValue(myApi))
                .build();

        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }

    public String getAuthorizationValue(MyApi myApi) throws Exception {
        String[] strArr = new String[] {login(myApi).body()};
        String response = Arrays.toString(strArr);
        String authorizeValue = null;
        List<MyApi> myApisList = gson.fromJson(response, new TypeToken<List<MyApi>>() {
        }.getType());
        for (MyApi api : myApisList){
            authorizeValue = api.getTokenType()+ " " +api.getAccessToken();
        }

        return authorizeValue;
    }
}
