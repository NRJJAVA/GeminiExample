package com.nrjtechworld.gemini.controller;

import com.nrjtechworld.gemini.service.GeminiApiService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "JWT")
public class GeminiController {

    @Autowired
    private GeminiApiService geminiApiService;

    @PostMapping("/generate")
    public String generateContent(@RequestBody String prompt,
                                  @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {

        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            System.out.println("No Authorization Header found!");
            return "No Authorization Header found!";
        }

        String token = authorizationHeader.replace("Bearer ", "");

        if (token.isEmpty()) {
            System.out.println("Token is empty!");
            return "Token is empty!";
        }

        System.out.println("Received Token: " + token);

        return geminiApiService.generateContent(prompt, token);
    }
}
