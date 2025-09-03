package org.example;

import org.example.factories.UserFactory;
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
    public CommandLineRunner init(UserRepository repository, UserFactory factory) {
        return args -> {
            // salva um usuário fixo
            repository.save(factory.make("Tiago Lemes", "tiagolemespalhano@gmail.com", "12345678"));

            // salva 25 usuários aleatórios
            repository.saveAll(factory.many(25));
        };
    }
}
