/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.service;

import com.mycompany.nexus.repository.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AYUSH
 */
@Service
public class TestService {
    @Autowired
    public CoinRepo repo;
    
    public String getStatus(){
        return repo.getStatus();
    }
    
}
