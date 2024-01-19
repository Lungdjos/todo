package com.zra.todo.dto;

import com.zra.todo.entities.UserTodo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionResult {
    private boolean succeeded;
    private String message;
}
