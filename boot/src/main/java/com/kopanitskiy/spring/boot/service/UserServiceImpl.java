package com.kopanitskiy.spring.boot.service;

import com.kopanitskiy.spring.boot.dao.UserDao;
import com.kopanitskiy.spring.boot.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id: " + id + "не найден"));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
       userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User userUpdate) {
        User user = getById(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setAge(userUpdate.getAge());
        user.setCitizenship(userUpdate.getCitizenship());
        save(user);
    }
}
