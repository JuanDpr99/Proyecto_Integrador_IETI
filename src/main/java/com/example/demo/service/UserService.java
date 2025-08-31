package com.example.demo.service;

import com.example.demo.model.User;
import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Collection<User> findAll();
    Optional<User> findById(String id);
    User update(String id, User user);
    void delete(String id);
}
