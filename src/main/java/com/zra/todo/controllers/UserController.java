package com.zra.todo.controllers;

import com.zra.todo.services.implementation.UserTodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserTodoServiceImpl userService;
    @RequestMapping()
    public String registerUser() {
        return "index";
    }
}
