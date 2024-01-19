package com.zra.todo.services;

import com.zra.todo.dto.TodoActivityDTO;
import com.zra.todo.entities.TodoActivity;

import java.util.List;

public interface TodoActivityService {
    void createTodo(TodoActivityDTO activity);
    TodoActivity findTodoById(long id);
    List<TodoActivity> getTodos();
    TodoActivity updateTodo(TodoActivity activity);
    void deleteTodo(long id);
}
