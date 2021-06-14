package com.cloud.microservicemongo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    UserRepository service;

    UserController(UserRepository service) {
        this.service = service;
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        if (service.existsById(user.getId()))
            return service.save(user);
        else
            return null;
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        if (service.existsById(id))
            service.deleteById(id);
    }


    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        if (service.existsById(user.getId()))
            service.delete(user);
    }
}