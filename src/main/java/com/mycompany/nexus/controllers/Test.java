/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.controllers;

import com.mycompany.nexus.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AYUSH
 */
@RestController
public class Test {
    @Autowired
    TestService service;
    @GetMapping("/test")
    public String test(){
         return service.getStatus();
    }
}
