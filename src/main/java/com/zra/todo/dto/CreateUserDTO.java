package com.zra.todo.dto;

//import com.zra.todo.entities.TodoActivity;
//import java.util.HashSet;
//import java.util.Set;

public class CreateUserDTO {
    // attributes
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String phone;

    // setters and getters
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
}
