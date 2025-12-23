/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.Configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author AYUSH
 */
@Configuration //This tell spring that this class contains the receipe or blue print of all the object s required replacement of xml based configuration 
@ComponentScan(basePackages="com.mycompany.nexus.Configuration")//telss spring to search this project to find all the configuration and beeans
public class AppConfig {
    @Bean
    public DataSource getSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/practise?allowPublicKeyRetrieval=true&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("ayush52141");
        return (DataSource) ds;
    }
    @Bean
    public JdbcTemplate getTemplate(DataSource source){
        JdbcTemplate temp=new JdbcTemplate((javax.sql.DataSource) source);
        return temp;
    }
}
