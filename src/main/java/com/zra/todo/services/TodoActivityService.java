package com.zra.todo.services;

import com.zra.todo.entities.TodoActivity;

public interface TodoActivityService {
    void createTodo(TodoActivity activity);
    TodoActivity findViewById(int id);
    TodoActivity updateTodo(TodoActivity activity);
    void deleteTodo(TodoActivity activity);
}
