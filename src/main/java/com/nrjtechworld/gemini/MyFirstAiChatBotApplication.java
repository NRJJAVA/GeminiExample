package com.nrjtechworld.gemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nrjtechworld.gemini")
public class MyFirstAiChatBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAiChatBotApplication.class, args);
	}

}
