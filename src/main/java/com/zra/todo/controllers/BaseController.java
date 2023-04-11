package com.zra.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping("/")
    public String showLogin() {
        return "redirect:/index";
    }
    @RequestMapping("/index")
//     @RequestMapping("/")
    public String index() {
        //
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

