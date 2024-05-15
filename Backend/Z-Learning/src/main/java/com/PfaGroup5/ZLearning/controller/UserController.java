package com.PfaGroup5.ZLearning.controller;

import com.PfaGroup5.ZLearning.model.User;
import com.PfaGroup5.ZLearning.service.UserSevice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSevice userSevice;

    public UserController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @PostMapping("/login/{userName}/{password}")
    public User login(@PathVariable String userName, @PathVariable String password) {
        if(userSevice.loginValidation(userName, password) != null) {
            return userSevice.loginValidation(userName, password);
        }
        return null;
    }

    @PostMapping("/register")
    public User register(User user) {
        if(userSevice.register(user) != null) {
            return userSevice.register(user);
        }
        return null;
    }
}
