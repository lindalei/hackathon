package com.demo.hackthon.service;

import com.demo.hackthon.entity.User;

public interface UserService {
    User findUserByUsername(String username);
    User addUser(User user);
}
