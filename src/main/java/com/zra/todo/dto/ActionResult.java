package com.zra.todo.dto;

import com.zra.todo.entities.UserTodo;

public class ActionResult {
    private boolean succeeded;
    private String message;

    public ActionResult(boolean b, String s) {
        this.succeeded = b;
        this.message = s;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
