package com.zra.todo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
