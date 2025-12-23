/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nexus.Configuration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author AYUSH
 */
public class WebInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {// this is known to tomcat like when tomcat starts before even srping is started 
        //tomcat looks for this servlet to know where the ioc container is and then it use ioc 
        //basically it likes the main box which only tomcat can use and inside it lies ioc
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class,WebConfig.class);//here our configuration classs get stored in ioc
        DispatcherServlet servlet=new DispatcherServlet(context);
        servletContext.addServlet("dispatcher",servlet).addMapping("/");//dispatcher servlet is registered with tomcat
        //flow is like
        
        //tomcat->servletContext->requestCommingto tomcat is forwaded to dispatcher servlet alos ioc createdat same time->dispatcher the sees the reques and consults with  ioc ->ioc will scan for for the controllers and return the adress back to dispatcher->the dispatecher then for forwards the request to that address
        
    }
    
}
