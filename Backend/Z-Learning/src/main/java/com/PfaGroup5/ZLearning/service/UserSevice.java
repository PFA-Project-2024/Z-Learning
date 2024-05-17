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


    public User loginValidation(String userName, String password) {
        User user = userRepo.findByUserName(userName);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User register(User user) {
        List<User> users = userRepo.findAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                return null;
            }
        }
        userRepo.save(user);
        return user;
    }
}
