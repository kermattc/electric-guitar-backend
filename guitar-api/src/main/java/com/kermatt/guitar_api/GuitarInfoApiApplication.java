package com.kermatt.guitar_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GuitarInfoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarInfoApiApplication.class, args);
	}

    // had to move the bean over to the main class because for some reason it kept getting ignored (-12 hours of my life)
	@Bean
    public WebMvcConfigurer corsConfig() {
        System.out.println("Adding CORS configuration pt1...");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("https://d3v8d7zaba9elv.cloudfront.net", "http://localhost:4200")
                    .allowedMethods("GET")
                    .allowedHeaders("content-type", "authorization");
            }
        };
    }
}
