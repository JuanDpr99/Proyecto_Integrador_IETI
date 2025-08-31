package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryUserService implements UserService {

    private final Map<String, User> db = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1000);

    @Override
    public User create(User user) {
        String id = (user.getId() != null && !user.getId().isBlank())
                ? user.getId()
                : String.valueOf(seq.getAndIncrement());
        user.setId(id);
        db.put(id, user);
        return user;
    }

    @Override
    public Collection<User> findAll() {
        return db.values();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public User update(String id, User user) {
        if (!db.containsKey(id)) {
            throw new NoSuchElementException("User not found: " + id);
        }
        user.setId(id);
        db.put(id, user);
        return user;
    }

    @Override
    public void delete(String id) {
        if (db.remove(id) == null) {
            throw new NoSuchElementException("User not found: " + id);
        }
    }
}