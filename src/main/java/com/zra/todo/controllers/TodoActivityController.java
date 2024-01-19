package com.zra.todo.controllers;

import com.zra.todo.dto.TodoActivityDTO;
import com.zra.todo.entities.TodoActivity;
import com.zra.todo.services.TodoActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoActivityController {
    @Autowired
    private TodoActivityService taskService;
    @RequestMapping("/addTodo")
    public String showAddTask(){
        return "addTask";
    }
    @RequestMapping("/todo/addTodo")
    public String showAddTsk(){
        return "addTask";
    }

    @RequestMapping("/createTask")
    public String addTask(@RequestParam("todo") String todo,
                          @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                          @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date end
                         ) {
        TodoActivityDTO task = new TodoActivityDTO(todo,false, start, end);
        taskService.createTodo(task);

        return "redirect:/todo/displayTasks";
    }
    @RequestMapping("/displayTasks")
    public String getDisplay (ModelMap modelMap){
        List<TodoActivity> todos = taskService.getTodos();
        modelMap.addAttribute("tasks", todos);
        return "displayTask";
    }

    @RequestMapping("/todo/updateTask")
    public String showTaskUpdate(@RequestParam("taskId") long id, ModelMap modelMap){
        TodoActivity todo = taskService.findTodoById(id);
        modelMap.addAttribute("todo", todo);
        return "updateTask";
    }
    @RequestMapping("/updatedTask")
    public String updateTask(@RequestParam("taskId") String id,
                             @RequestParam("todo") String todo,
                             @RequestParam("status") String state,
                             ModelMap modelMap
    ) {
        TodoActivity activity = taskService.findTodoById(Long.parseLong(id));
        boolean status= false;
        // validating the status
        if (state.equals("Pending")) {
            status = false;
        } else if(state.equals("Completed")){
            status = true;
        }else {
            String msg = "Unknown status type, add a valid status.";
            modelMap.addAttribute("msg", msg);
            return "/todo/updatedTask";
        }
        activity.setTask(todo);
        activity.setStatus(status);
        TodoActivity updateTask = activity;
        taskService.updateTodo(updateTask);
        return "redirect:/todo/displayTasks";
    }
    @RequestMapping("/todo/deleteTask")
    public String deleteTask(@RequestParam("taskId") long taskId){
        taskService.deleteTodo(taskId);
        return "redirect:/todo/displayTasks";
    }
}
