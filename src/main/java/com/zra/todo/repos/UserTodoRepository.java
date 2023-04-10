package com.zra.todo.repos;

import com.zra.todo.entities.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
    Optional<UserTodo> findByUsername(String username);
}