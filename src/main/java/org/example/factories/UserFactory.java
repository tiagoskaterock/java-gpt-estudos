package org.example.factories;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;
import org.example.models.User;

public class UserFactory {
    private static final Faker faker = new Faker();

    public static User make() {
        return new User(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }

    public static List<User> many(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(make());
        }
        return users;
    }
}
