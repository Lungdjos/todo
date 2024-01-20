package com.zra.todo.dto;

import com.zra.todo.entities.UserTodo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoActivityDTO {
    private  String task;
    private boolean status;
    private Date startDate;
    private Date endDate;
    private UserTodo userTodo;

    public TodoActivityDTO(String todo, boolean b, Date start, Date end) {
    }
}
