package com.cloud.microservicemongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class Seeder implements CommandLineRunner {
    private UserRepository repository;

    Seeder(UserRepository repository) {
        this.repository = repository;
        log.trace("Logging trace");
        log.warn("Logging warning");
        log.debug("Logging debug");
        log.info("Logging info");
        log.error("Logging error");
    }

    static List<User> seed() {
        List<User> list = Arrays.asList(
                new User("firstName111", "lastName0", "email0", "password0", Arrays.asList(
                        new Course("CourseName0", 1010l),
                        new Course("CourseName1", 234l),
                        new Course("CourseName2", 345l))),
                new User("firstName1", "lastName1", "email1", "password1", Arrays.asList(
                        new Course("CourseName1", 123l),
                        new Course("CourseName3", 234l))),
                new User("firstName2", "lastName2", "email2", "password2", Arrays.asList(
                        new Course("CourseName1", 123l))),
                new User("firstName3", "lastName3", "email3", "password3", Arrays.asList()));
        return list;
    }

    @Override
    public void run(String... args) throws Exception {

        List<User> list = seed();
        this.repository.deleteAll();
        this.repository.saveAll(list);
    }
}
