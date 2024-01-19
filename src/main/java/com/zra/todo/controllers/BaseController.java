package com.zra.todo.controllers;

import com.zra.todo.entities.TodoActivity;
import com.zra.todo.services.TodoActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private TodoActivityService taskService;

    @RequestMapping("/")
    public String showLogin() {
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index() {
        List<TodoActivity> todos = taskService.getTodos();
        if (todos.size() > 0 ) {
            return "redirect:/todo/displayTasks";
        }
        return "index";
    }
//    @GetMapping("/login")
    @GetMapping("/login")
    public String showLoginPage(){
        return "sign/login";
    }

    @RequestMapping("/register")
    public String showSignupPage(){
        return "sign/register";
    }
}

