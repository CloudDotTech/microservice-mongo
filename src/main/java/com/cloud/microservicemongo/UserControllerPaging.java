package com.cloud.microservicemongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/1.0")
public class UserControllerPaging {
    UserService service;

    UserControllerPaging(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> findAll() {

        return service.findAll();
    }

    @GetMapping("/pages")
//    public Page<User> findAllPaging(@RequestParam int size, @RequestParam int page) {
        public Page<User> findAllPaging(Pageable pageable) {
        return service.findAll(pageable);
    }
}