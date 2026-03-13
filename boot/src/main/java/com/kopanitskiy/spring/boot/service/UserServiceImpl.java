package com.kopanitskiy.spring.boot.service;

import com.kopanitskiy.spring.boot.dao.UserDao;
import com.kopanitskiy.spring.boot.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id: " + id + "не найден"));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
       userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User userUpdate) {
        User user = getUserById(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setAge(userUpdate.getAge());
        user.setCitizenship(userUpdate.getCitizenship());
        saveUser(user);
    }
}
