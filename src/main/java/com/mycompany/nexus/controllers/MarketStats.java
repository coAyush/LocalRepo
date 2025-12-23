/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.controllers;

import com.mycompany.nexus.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AYUSH
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MarketStats{
    @Autowired
    MarketService service;
    @GetMapping("/market")
public Object getMarketStats() {
    return service.marketStats();
}

}
