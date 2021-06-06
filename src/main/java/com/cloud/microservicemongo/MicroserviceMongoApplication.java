package com.cloud.microservicemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MicroserviceMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceMongoApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Microservice up !!!" + '\n' +
                "http://localhost:8080/users" +
                "";
    }
}