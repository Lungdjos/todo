package com.zra.todo.services.implementation;

import com.zra.todo.dto.CreateUserDTO;
import com.zra.todo.entities.UserTodo;
import com.zra.todo.repos.UserTodoRepository;
import com.zra.todo.services.UserTodoService;
import com.zra.todo.dto.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserTodoServiceImpl implements UserTodoService {
    @Autowired
    private UserTodoRepository userTodoRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserTodo findUserByUsername(String username) {
       var userRecord = userTodoRepository.findByUsername(username);
       if(userRecord.isPresent()){
           return (UserTodo) userRecord.get();
       }
       return null;
    }

    @Override
    public ActionResult createUser(CreateUserDTO userDTO) {
        try {
            var existingUser = userTodoRepository.findByUsername(userDTO.getUsername());
            if (existingUser.isPresent()) {
                return new ActionResult(false, "User already exists " + userDTO.getUsername());
            }
            var newUser = new UserTodo();
            newUser.setfName(userDTO.getfName());
            newUser.setlName(userDTO.getlName());
            newUser.setUsername(userDTO.getUsername());
            newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            newUser.setPhone(userDTO.getPhone());
            userTodoRepository.save(newUser);

            return new ActionResult(true,"User created successfully.");
        } catch (Exception e) {
            return new ActionResult(false, e.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The username " + username + " is not available on the server");
        }
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
