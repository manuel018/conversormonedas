package com.mycompany.conversormonedas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiService {

    private HttpClient cliente = HttpClient.newHttpClient();
    private final String API_URL = "https://v6.exchangerate-api.com/v6/56055434f03eb669315fddb6/latest/";
    private List coinPrefixFullList;

    public ApiService() {
        getAllCoins();
    }

    public String getCoinExchange(String fromCoinPrefix, String toCoinPrefix, double quanty) throws Exception {
        try {
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL.concat(fromCoinPrefix)))
                    .GET()
                    .build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .create();
            String json = respuesta.body();
            ApiResponse res = gson.fromJson(json, ApiResponse.class);
            BigDecimal bd = new BigDecimal(String.valueOf(Double.parseDouble(res.conversion_rates.get(toCoinPrefix)) * quanty));
            BigDecimal result = bd.setScale(2, RoundingMode.HALF_UP);
            return result.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    private void getAllCoins() {
        try {
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL.concat("USD")))
                    .GET()
                    .build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .create();
            String json = respuesta.body();
            ApiResponse res = gson.fromJson(json, ApiResponse.class);
            coinPrefixFullList = new ArrayList(Arrays.asList(res.conversion_rates.keySet().toArray()));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void getFullList() {
        System.out.println("----------- LISTA DE MONEDAS --------------");
        this.coinPrefixFullList.forEach(System.out::println);
        System.out.println("-------------------------------------------");
    }
}
