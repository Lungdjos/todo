package com.zra.todo.services;

import com.zra.todo.dto.CreateUserDTO;
import com.zra.todo.entities.UserTodo;
import com.zra.todo.services.dto.ActionResult;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserTodoService extends UserDetailsService {
    UserTodo findUserByUsername(String username);

    ActionResult createUser(CreateUserDTO userDTO);
}
