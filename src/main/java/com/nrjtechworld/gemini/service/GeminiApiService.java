package com.nrjtechworld.gemini.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class GeminiApiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GeminiApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String generateContent(String prompt, String userJwtToken) {
        // Gemini API URL with API key in the query
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;

        // Set headers for user authentication with JWT (this will be used to authenticate the local user)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
//        headers.set("Authorization", "Bearer " + userJwtToken);  // User JWT token for your app's internal authentication

        // Request body with the prompt for the Gemini API
        String requestBody = "{"
                + "\"contents\": [{"
                + "  \"parts\": [{\"text\": \"" + prompt.replace("\"", "\\\"") + "\"}]"
                + "}]"
                + "}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            // Make the API call to Gemini
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
            return extractGeneratedText(response.getBody());
        } catch (HttpClientErrorException e) {
            // Log error details for debugging
            System.out.println("Gemini API request failed: " + e.getStatusCode());
            System.out.println("Response body: " + e.getResponseBodyAsString());
            throw e;
        }

    }

    private String extractGeneratedText(String responseBody) {
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error parsing response: " + e.getMessage();
        }
    }
}
