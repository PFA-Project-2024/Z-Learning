package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.User;
import com.PfaGroup5.ZLearning.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSevice {


    final public UserRepo userRepo;

    public UserSevice(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public void loginValidation(String email, String password) {
        User user = userRepo.findByEmail(email);

        if(user == null && !user.getPassword().equals(password)) {
           throw new RuntimeException("Invalid email or password");
        }
    }

    public void register(User user) {
        List<User> users = userRepo.findAll();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                throw new RuntimeException("Email already exists");
            }
        }
        userRepo.save(user);
    }
}
