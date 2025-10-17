package org.cep.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cep.service.dto.AdressDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    AdressDTO adressDTO = new AdressDTO();

    public AdressDTO getAdress(String cep) {
        try {

            // initialize client
            HttpClient client = HttpClient.newHttpClient();

            // Do Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .GET()
                    .build();

            // get response
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            ObjectMapper mapper = new ObjectMapper();
            adressDTO = mapper.readValue(response.body(), AdressDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar CEP: " + e.getMessage(), e);
        }

        return adressDTO;
    }
}