package org.example.factories;

import com.github.javafaker.Faker;
import org.example.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFactory {
    private final Faker faker = new Faker();
    private final PasswordEncoder encoder;

    public UserFactory(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    // dentro de UserFactory
    public User make(String name, String email, String password) {
        return new User(
                name,
                email,
                encoder.encode(password)
        );
    }

    public User make() {
        return new User(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                encoder.encode(faker.internet().password())
        );
    }

    public List<User> many(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(make());
        }
        return users;
    }
}
