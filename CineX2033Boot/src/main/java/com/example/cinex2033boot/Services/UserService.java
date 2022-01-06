package com.example.cinex2033boot.Services;

import com.example.cinex2033boot.Models.UserEntity;
import com.example.cinex2033boot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity addUser(UserEntity user){
        userRepository.save(user);
        return user;
    }

}
