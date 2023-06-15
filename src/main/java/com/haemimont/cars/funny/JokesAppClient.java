package com.haemimont.cars.funny;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
public class JokesAppClient {
    Gson gson = new GsonBuilder().create();
    public String sampleApiRequest() throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://official-joke-api.appspot.com/random_ten"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    public String syncGson() throws Exception {
        String response = sampleApiRequest();
        String result = null;
        List<Jokes> jokes = gson.fromJson(response, new TypeToken<List<Jokes>>() {
        }.getType());
        for (Jokes joke:jokes){
            result = joke.getSetup()+ " - " +joke.getPunchline();
        }

        return result;
    }
}
