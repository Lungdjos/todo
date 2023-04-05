package com.zra.todo.repos;

import com.zra.todo.entities.UserTodo;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public interface UserRepository<UserTodo extends AbstractAuditable, Long> extends JpaRepository<UserTodo, Long> {
    UserTodo findByUsername(String username);
}