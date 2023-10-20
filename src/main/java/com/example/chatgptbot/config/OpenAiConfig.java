package com.example.chatgptbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiConfig {

    @Value("${openai.api.key}")
    String OpenAiAPIKey;


    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add((request, body,execution) ->{
            request.getHeaders().add("Authorization","Bearer " +OpenAiAPIKey);
            return execution.execute(request, body);

        });
        return restTemplate;
    }
}
