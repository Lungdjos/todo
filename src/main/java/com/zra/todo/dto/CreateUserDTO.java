package com.zra.todo.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserDTO {
    // attributes
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
}
