package fr.efrei.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("auth")
    public String helloAuth() {
        return "hello auth";
    }


}
