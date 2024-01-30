package ru.netology.rest.model;



import ru.netology.rest.service.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserRepository {

    public Map<User, List<Authorities>> userListMap;

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    public List<Authorities> getAuthorities(String name, String password) {
        User user = new User(name, password);
        if (userListMap.containsKey(user)) return userListMap.get(user);
        return new ArrayList<>();

    }
}
