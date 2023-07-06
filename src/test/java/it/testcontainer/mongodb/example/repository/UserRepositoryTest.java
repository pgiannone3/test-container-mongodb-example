package it.testcontainer.mongodb.example.repository;

import it.testcontainer.mongodb.example.containers.MongoDBContainer;
import it.testcontainer.mongodb.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataMongoTest
class UserRepositoryTest extends MongoDBContainer {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {"albus.dumbledore@gmail.com", "harry.potter@gmail.com", "severus.snape@gmail.com"})
    void findUserByEmail_whenUserExistsInCollection_shouldReturnUser(String email) {
        User user = userRepository.findUserByEmail(email);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(email, user.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"hermione.granger@gmail.com", "horace.lumacorno@gmail.com"})
    void findUserByEmail_whenUserDoesNotExistsInCollection_shouldReturnUser(String email) {
        User user = userRepository.findUserByEmail(email);
        Assertions.assertNull(user);
    }
}