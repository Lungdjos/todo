package com.zra.todo.controllers;

import com.zra.todo.dto.CreateUserDTO;
import com.zra.todo.services.implementation.UserTodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserTodoServiceImpl userService;
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user")CreateUserDTO user) {
        userService.createUser(user);
        return "sign/login";
    }

}
