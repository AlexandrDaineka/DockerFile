package ru.netology.rest.controller;

import ru.netology.rest.service.Authorities;
import ru.netology.rest.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }
    //в @RequestParam параметры должны соответствовать тем что в проперти
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("name") String name, @RequestParam("password") String password) {
        return service.getAuthorities(name, password);
    }


}
