/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AYUSH
 */
@Service
public class MarketService {
    @Autowired
    String coinGeckoUrl;
    @Autowired
    RestTemplate restTemplate;
    public Object marketStats(){
        return  restTemplate.getForObject(coinGeckoUrl+"/global", Object.class);
    }
}
