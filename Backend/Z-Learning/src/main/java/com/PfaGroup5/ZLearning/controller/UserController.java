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
    public ResponseEntity login(@PathVariable String email, @PathVariable String password) {

        try {
            userSevice.loginValidation(email, password);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/register")
    public ResponseEntity register(User user) {
        try {
            userSevice.register(user);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
