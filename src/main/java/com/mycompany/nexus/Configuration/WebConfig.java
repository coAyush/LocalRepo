/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author AYUSH
 */
@EnableWebMvc//this tells ioc that this project is a web based project and follows mvc pattern
@Configuration
@ComponentScan("com.mycompany.nexus")
public class WebConfig implements WebMvcConfigurer {
    
}
