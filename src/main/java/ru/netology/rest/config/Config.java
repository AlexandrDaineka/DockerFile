package ru.netology.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.rest.model.User;
import ru.netology.rest.model.UserRepository;
import ru.netology.rest.service.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration

public class Config {
    @Bean
    public UserRepository userRepository(@Value("${ru.netology.rest.name}") String name,
                                         @Value("${ru.netology.rest.password}") String password) {
        Map<User, List<Authorities>> map = new HashMap<>();
        map.put(new User(name, password), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        return new UserRepository(map);
    }
}