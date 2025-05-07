package com.danielnatan.conversor.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class ExchangeRateService {
    private static final String API_KEY = carregarApiKey();
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static double obterTaxa(String de, String para) {
        String urlStr = BASE_URL + de + "/" + para;

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            int status = conexao.getResponseCode();
            if (status != 200) {
                System.out.println("Erro ao acessar a API. Código: " + status);
                return -1;
            }

            Scanner scanner = new Scanner(conexao.getInputStream());
            StringBuilder resposta = new StringBuilder();

            while (scanner.hasNext()) {
                resposta.append(scanner.nextLine());
            }

            scanner.close();

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(resposta.toString(), JsonObject.class);
            return json.get("conversion_rate").getAsDouble();

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }

    private static String carregarApiKey() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            return props.getProperty("api.key");
        } catch (IOException e) {
            System.out.println("Erro ao carregar config.properties: " + e.getMessage());
            return "";
        }
    }
}