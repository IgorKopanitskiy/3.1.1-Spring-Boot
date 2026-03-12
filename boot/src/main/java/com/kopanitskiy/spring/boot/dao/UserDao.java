package com.kopanitskiy.spring.boot.dao;


import com.kopanitskiy.spring.boot.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(Long id);

    public void deleteUser(User user);

}
