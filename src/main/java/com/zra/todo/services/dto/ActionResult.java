package com.zra.todo.services.dto;

import com.zra.todo.entities.UserTodo;

public class ActionResult {
    private boolean succeeded;
    private String message;

    public ActionResult(boolean b, String s) {
        this.succeeded = b;
        this.message = s;
    }
}
