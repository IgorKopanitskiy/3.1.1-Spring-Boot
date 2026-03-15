package com.kopanitskiy.spring.boot.service;

import com.kopanitskiy.spring.boot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public void save(User user);

    public User getById(Long id);

    public void deleteById(Long id);

    public void update(Long id, User userUpdate);
}

