package org.example;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaGptEstudosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGptEstudosApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository repository) {
        return args -> {
            repository.save(new User("Tiago", "tiago@email.com"));
            repository.save(new User("João", "joao@email.com"));
            repository.save(new User("Maria", "maria@email.com"));
        };
    }
}
