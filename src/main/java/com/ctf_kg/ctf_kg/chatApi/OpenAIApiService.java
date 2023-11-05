package com.ctf_kg.ctf_kg.chatApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


@Service
public class OpenAIApiService {

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    public String getResponse(String prompt) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Create a map and convert it to a JSON string automatically
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("prompt", prompt);
            jsonMap.put("max_tokens", 150);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonMap, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return "OpenAI API Client Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return "OpenAI API Error: " + e.getMessage();
        }
    }
}