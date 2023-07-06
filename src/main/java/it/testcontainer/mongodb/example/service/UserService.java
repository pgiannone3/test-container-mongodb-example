package it.testcontainer.mongodb.example.service;

import it.testcontainer.mongodb.example.model.User;

public interface UserService {
    User findUserByEmail(String email);
}
