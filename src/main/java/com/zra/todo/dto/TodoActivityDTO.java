package com.zra.todo.dto;

import com.zra.todo.entities.UserTodo;
import java.util.Date;

public class TodoActivityDTO {
    private  String task;
    private boolean status;
    private Date startDate;
    private Date endDate;
    private UserTodo userTodo;

    public TodoActivityDTO(String task, boolean status){
        this.task = task;
        this.status = status;
    }
    public TodoActivityDTO(String task, boolean status, Date startDate, Date endDate){
        this.task = task;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserTodo getUserTodo() {
        return userTodo;
    }

    public void setUserTodo(UserTodo userTodo) {
        this.userTodo = userTodo;
    }
}
