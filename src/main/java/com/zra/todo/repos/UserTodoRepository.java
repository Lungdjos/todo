package com.zra.todo.repos;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserTodoRepository<UserTodo extends AbstractAuditable, Long> extends JpaRepository<UserTodo, Long> {
    Optional<UserTodo> findByUsername(String username);
}