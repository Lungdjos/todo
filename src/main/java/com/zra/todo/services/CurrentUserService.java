package com.zra.todo.services;

import com.zra.todo.entities.UserTodo;

public interface CurrentUserService {
    UserTodo getCurrentUser();
    String getCurrentUsername();
}
