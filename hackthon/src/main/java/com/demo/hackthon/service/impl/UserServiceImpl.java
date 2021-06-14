package com.demo.hackthon.service.impl;

import com.demo.hackthon.entity.User;
import com.demo.hackthon.repo.UserRepo;
import com.demo.hackthon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public User addUser(User user) {
        if (user.getUserName() != null && user.getUserPass() != null) {
            user.setUserPass(passwordEncoder.encode(user.getUserPass()));
            userRepo.save(user);
        } else
            user = null;
        return user;
    }
}
