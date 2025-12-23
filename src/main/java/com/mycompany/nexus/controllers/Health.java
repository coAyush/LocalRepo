/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AYUSH
 */
@RestController
public class Health {
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public Map<String,String>health(){
        return Map.of("status","Fine working good");
    }
}
