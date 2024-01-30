package ru.netology.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

public class User {
    @Value("${ru.netology.rest.name}")
    @Setter
    @Getter
    private String name;
    @Value("${ru.netology.rest.password}")
    @Setter
    @Getter
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}




