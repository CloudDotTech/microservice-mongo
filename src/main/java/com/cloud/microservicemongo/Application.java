package com.cloud.microservicemongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
@RestController
@SpringBootApplication
public class Application {
    public Application() {
        log.trace("Logging trace");
        log.warn("Logging warning");
        log.debug("Logging debug");
        log.info("Logging info");
        log.error("Logging error");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/")
    public String start() {
        return "Microservice up !!!" + '\n' +
                "http://localhost:8080/users" + '\n' +
                "http://localhost:8080/users/1.0" + '\n' +
                "http://localhost:8080/users/1.0/pages?size=1&page=10" + '\n' +
                "http://localhost:8080/users/1.0/pages?pageSize=3&pageNumber=1";
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
//        userRepository.deleteAll();
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                IntStream.range(0, 50).forEach(i -> {
                    User user = new User(
                            "firstName" + (int)(Math.random()*1000),
                            "lastName" + i,
                            "email" + i + 2 + "@email.com",
                            "password" + i,
                            Arrays.asList(
                            ));
//                                    new Course("CourseName" + i  , 1010l),
//                                    new Course("CourseName" + i  , 234l),
//                                    new Course("CourseName" + i + 2, 345l)));
//                    userRepository.save(user);
                });
            }
        };
    }
}