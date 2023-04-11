package com.zra.todo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserTodo extends AbstractEntity{
    private String fName;
    private String lName;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String phone;

    @OneToMany(mappedBy = "userTodo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TodoActivity> todoActivities = new HashSet<>();

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<TodoActivity> getTodoActivities() {
        return todoActivities;
    }

    public void setTodoActivities(Set<TodoActivity> todoActivities) {
        this.todoActivities = todoActivities;
    }
}
