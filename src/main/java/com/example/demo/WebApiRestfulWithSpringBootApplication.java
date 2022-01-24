package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class WebApiRestfulWithSpringBootApplication {

    public static void main(String[] args) { SpringApplication.run(WebApiRestfulWithSpringBootApplication.class, args); }

    //Enables communication between the api and the .js host
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
                "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    /*

    To test the api you need to use Postman and connect to the address :

    See all employees
    -----------------

    http://localhost:8080/employee/all                      It must be used with the GET method


    See only one employee
    ---------------------

    http://localhost:8080/employee/find/{id}                It must be used with the GET method


    Add an employee
    ---------------

    http://localhost:8080/employee/add                      It must be used with the POST method

    In Postman select tab body, format JSON and add (exemple in JSON):

    {
    "email" : "christine@gmail.com",
    "imageUrl" : "https://bootdey.com/img/Content/avatar/avatar7.png",
    "jobTitle" : "Developer Java",
    "name" : "Christine Dupond",
    "phone" : "0478/698523"
    }

    If the user is created, there is in Postman an annotation with Status: "201 created"


    Update an employee
    ------------------

    http://localhost:8080/employee/update                   It must be used with the PUT method

    Select one employee with find method and copy/paste JSON informations into the window above.
    After, you have to make the necessary changes in the JSON information and then send the request.


    Delete an employee
    ------------------

    http://localhost:8080/employee/delete/{id}              It must be used with the DELETE method

     */
}
