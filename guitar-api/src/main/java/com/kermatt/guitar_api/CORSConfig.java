package com.kermatt.guitar_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CORSConfig {
    @Bean
    public WebMvcConfigurer corsConfig() {
        System.out.println("Adding CORS configuration pt1...");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://guitar-site.s3-website.us-east-2.amazonaws.com", "http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                        .allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Accept");
            }
        };
    }
}


// @Configuration
// @EnableWebMvc
// public class CORSConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 // .allowedOrigins("http://localhost:4200")
//                 .allowedOrigins("http://localhost:4200", "http://guitar-site.s3-website.us-east-2.amazonaws.com")
//                 // .allowedOrigins("*")
//                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                 .allowedHeaders("*")
//                 .allowCredentials(true);
//         // registry.addMapping("/api/v1/guitars/**")
//         // .allowedOrigins("*")
//         // .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//         // // .allowedHeaders("*")
//         // .allowedHeaders("Access-Control-Allow-Headers", "Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers")
//         // .allowCredentials(true)
//         // .maxAge(3600);   
//     }
// }

// @Configuration
// @EnableWebMvc
// public class CORSConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOrigins("http://localhost:4200", "http://guitar-site.s3-website.us-east-2.amazonaws.com", "http://localhost")
//                 .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
//                 .allowedHeaders("*") 
//                 .allowCredentials(false); 
//     }
// }