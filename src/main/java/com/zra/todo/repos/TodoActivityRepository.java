package com.zra.todo.repos;

import com.zra.todo.entities.TodoActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoActivityRepository extends JpaRepository<TodoActivity, Long> {
}
