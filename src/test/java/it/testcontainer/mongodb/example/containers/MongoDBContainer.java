package it.testcontainer.mongodb.example.containers;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

@Testcontainers
public class MongoDBContainer {

    @Container
    public static final GenericContainer<?> MONGO_DB_CONTAINER = new GenericContainer<>(
            DockerImageName.parse("mongo:5.0.18"))
            .withExposedPorts(27017)
            .withReuse(true)
            .withEnv("MONGO_INITDB_ROOT_USERNAME", "user")
            .withEnv("MONGO_INITDB_ROOT_PASSWORD", "password")
            .withEnv("MONGO_INITDB_DATABASE", "admin")
            .withCopyFileToContainer(MountableFile.forClasspathResource("./init-schema.js"), "/docker-entrypoint-initdb.d/init-script.js");

    static {
        MONGO_DB_CONTAINER.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", MONGO_DB_CONTAINER::getHost);
        registry.add("spring.data.mongodb.port", MONGO_DB_CONTAINER::getFirstMappedPort);
        registry.add("spring.data.mongodb.username", () -> "test_container");
        registry.add("spring.data.mongodb.password", () -> "test_container");
        registry.add("spring.data.mongodb.database", () -> "user_management");
    }
}
