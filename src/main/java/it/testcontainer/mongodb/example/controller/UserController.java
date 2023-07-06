package it.testcontainer.mongodb.example.controller;

import it.testcontainer.mongodb.example.model.User;
import it.testcontainer.mongodb.example.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public User findUserByEmail(@RequestParam String email) {
        return userRepository.findUserByEmail(email);
    }
}
