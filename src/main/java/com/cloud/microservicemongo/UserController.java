package com.cloud.microservicemongo;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public List<User> getUsers() {
        return Seeder.seed();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user = new User("firstName0", "lastName0", "email0", "password0", Arrays.asList(
                new Course("CourseName0", 123l),
                new Course("CourseName1", 234l),
                new Course("CourseName2", 345l)));
        user.setId(id);
        return user;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        user.setId("id");
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        return user;
    }


    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        user.setFirstName("DELETED");
        return user;
    }
}

//    @Autowired
//    private UserRepository repository;
//
//    @PostMapping("/addUser")
//    public String saveUser(@RequestBody User user) {
//        repository.save(user);
//        return "Added user with id : " + user.getId();
//    }
//
//    @GetMapping("/findAllUsers")
//    public List<User> getUsers() {
//        return repository.findAll();
//    }
//
//    @GetMapping("/findAllUsers/{id}")
//    public Optional<User> getUser(@PathVariable int id) {
//        return repository.findById(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteUser(@PathVariable int id) {
//        repository.deleteById(id);
//        return "user deleted with id : " + id;
//    }

