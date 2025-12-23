/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AYUSH
 */
@Configuration
public class GeckoConfig {
    @Bean
    public RestTemplate restTemplate(){//REST TEMPLATE IS USED IN SPRING TO CALL OR EXTRACT DATA FROM EXTENAL APIS SIMILAR TO FETCH INNJS
        return new RestTemplate();
    }
    @Bean
    public String coinGeckoUrl(){
        return "https://api.coingecko.com/api/v3";
    }
}
