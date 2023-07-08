package it.testcontainer.mongodb.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private final ObjectId id;
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final String email;
    private final int age;

    public User(ObjectId id, String firstName, String lastName, String nickname, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.age = age;
    }

    public ObjectId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
