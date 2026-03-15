package com.kopanitskiy.spring.boot.dao;


import com.kopanitskiy.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
