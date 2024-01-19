package com.zra.todo.services.implementation;

import com.zra.todo.entities.UserTodo;
import com.zra.todo.services.CurrentUserService;
import com.zra.todo.services.UserTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {
    @Autowired
    private UserTodoService userService;

    @Override
    public UserTodo getCurrentUser() {
        return userService.findUserByUsername(getCurrentUsername());
    }

    @Override
    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
