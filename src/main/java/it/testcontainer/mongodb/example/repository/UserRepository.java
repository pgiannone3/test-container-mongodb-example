package it.testcontainer.mongodb.example.repository;

import it.testcontainer.mongodb.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query(value = "{ 'email' : { $eq: ?0} }")
    User findUserByEmail(String email);
}
