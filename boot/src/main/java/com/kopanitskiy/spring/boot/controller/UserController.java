package com.kopanitskiy.spring.boot.controller;

import com.kopanitskiy.spring.boot.model.User;
import com.kopanitskiy.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAll(Model model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("allUsers", allUsers);
        return "allUsersView";
    }


    @GetMapping("/addNewUser")
    public String addNew(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userInfoView";
    }


    @PostMapping("/saveUser")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String showUpdateForm(@RequestParam("id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "userInfoView";
    }

    @PostMapping("/updateUser")
    public String update(@RequestParam("id") long id, @ModelAttribute User userUpdate) {
        userService.update(id, userUpdate);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteById(@RequestParam("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

}