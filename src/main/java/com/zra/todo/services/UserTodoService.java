package com.zra.todo.services;

import com.zra.todo.dto.CreateUserDTO;
import com.zra.todo.entities.UserTodo;
import com.zra.todo.services.dto.ActionResult;

public interface UserTodoService {
    UserTodo findUserByUsername(String username);

    ActionResult createUser(CreateUserDTO userDTO);
}
