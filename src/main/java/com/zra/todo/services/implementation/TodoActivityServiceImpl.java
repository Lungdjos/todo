package com.zra.todo.services.implementation;

import com.zra.todo.dto.TodoActivityDTO;
import com.zra.todo.entities.TodoActivity;
import com.zra.todo.repos.TodoActivityRepository;
import com.zra.todo.services.CurrentUserService;
import com.zra.todo.services.TodoActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class TodoActivityServiceImpl implements TodoActivityService {
    @Autowired
    private TodoActivityRepository todoActivityRepository;
    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public void createTodo(TodoActivityDTO activity) {
        var currentDate =  Date.from(Instant.now());
        var todo = new TodoActivity();
        todo.setTask(activity.getTask());
        todo.setStatus(activity.isStatus());
        todo.setStartDate(activity.getStartDate());
        todo.setEndDate(activity.getEndDate());
        todo.setUserTodo(currentUserService.getCurrentUser());
        todoActivityRepository.save(todo);
    }

    @Override
    public TodoActivity findTodoById(long id) {
        return todoActivityRepository.findTaskById(id);
    }

    @Override
    public List<TodoActivity> getTodos() {
        return currentUserService.getCurrentUser().getTodoActivities().stream().toList();
    }

    @Override
    public TodoActivity updateTodo(TodoActivity activity) {

//        var currentDate =  Date.from(Instant.now());
//        TodoActivity updatedTask = new TodoActivity();
//        updatedTask.setTask(activity.getTask());

        // condition to update
//        if(activity.isStatus()){
//            updatedTask.setStatus(activity.isStatus());
//            updatedTask.setEndDate(currentDate);
//            updatedTask.setUserTodo(currentUserService.getCurrentUser());
//        } else {
//            updatedTask.setStatus(activity.isStatus());
//            updatedTask.setUserTodo(currentUserService.getCurrentUser());
//        }

        return todoActivityRepository.save(activity);
    }

    @Override
    public void deleteTodo(long id) {
        TodoActivity todo = findTodoById(id);
        todoActivityRepository.delete(todo);
    }
}
