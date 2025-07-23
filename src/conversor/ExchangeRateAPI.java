package src.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateAPI {
    private String apiKey ="bc8cb753e981f9f0774306ef";
    private String baseURL = "https://v6.exchangerate-api.com/v6/";

    public ExchangeRateResponse obtenerDivisa(String baseCode) throws IOException, InterruptedException{
        String url = baseURL + apiKey + "/latest/" + baseCode;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }
}
