package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.UserFormDao;
import fr.efrei.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("signing")
    public UserFormDao createUser(
            UserFormDao userFormDao
    ) {
        userService.addUser(userFormDao);

        return userFormDao;
    }


}
