package com.example.zadaniedomjaz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.stream.StreamSupport;
@Service
public class KursService {


    private final KursRepository kursRepository;

    public KursService(KursRepository kursRepository) {
        this.kursRepository = kursRepository;
    }


    public double calculateAverageRate(String currency, int days) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/last/" + days + "/";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            JsonNode rates = root.path("rates");

            double sum = StreamSupport.stream(rates.spliterator(), false)
                    .mapToDouble(rate -> rate.path("mid").asDouble())
                    .sum();

            float average = (float) (sum / days);

            zapytanie_kurs request = new zapytanie_kurs();
            request.setWaluta(currency);
            request.setLiczba_dni(days);
            request.setKurs(average);
            request.setData_zapytania(LocalDateTime.now());
            kursRepository.save(request);

            return average;

        } catch (Exception e) {
            throw new RuntimeException("Error processing NBP API response", e);
        }
    }
}

