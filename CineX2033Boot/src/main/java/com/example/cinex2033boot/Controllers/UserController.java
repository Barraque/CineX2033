package com.example.cinex2033boot.Controllers;

import com.example.cinex2033boot.Repositories.UserRepository;
import com.example.cinex2033boot.Services.UserService;
import com.example.cinex2033boot.Models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("signing")
    public UserEntity adduser(
            @RequestBody UserEntity user
    ){
        return userService.addUser(user);
    }

    @GetMapping("")
    public UserEntity hello(
    ){
        return userRepository.findByUsername("quentin");
    }

    @PostMapping("auth")
    public String isAuth(){
        return "tu es auth";
    }

}
