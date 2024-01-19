package com.zra.todo.services;

import com.zra.todo.dto.TodoActivityDTO;
import com.zra.todo.entities.TodoActivity;
import com.zra.todo.entities.UserTodo;
import com.zra.todo.repos.TodoActivityRepository;
import com.zra.todo.services.implementation.TodoActivityServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoActivityServiceImplTest {

    @Mock
    private TodoActivityRepository todoActivityRepository;

    @Mock
    private CurrentUserService currentUserService;

    @InjectMocks
    private TodoActivityServiceImpl todoActivityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateTodo() {
        // Mocking
        TodoActivityDTO todoActivityDTO = new TodoActivityDTO();
        todoActivityDTO.setTask("Task 1");
        todoActivityDTO.setStatus(false);
        todoActivityDTO.setStartDate(new Date());
        todoActivityDTO.setEndDate(new Date());

        when(currentUserService.getCurrentUser()).thenReturn(createTestUser());
        doNothing().when(todoActivityRepository).save(any(TodoActivity.class));

        // Test
        assertDoesNotThrow(() -> todoActivityService.createTodo(todoActivityDTO));

        // Verify
        verify(todoActivityRepository, times(1)).save(any(TodoActivity.class));
    }

    @Test
    void testFindTodoById() {
        // Mocking
        long todoId = 1L;
        when(todoActivityRepository.findTaskById(todoId)).thenReturn(createTestTodoActivity());

        // Test
        TodoActivity result = todoActivityService.findTodoById(todoId);

        // Verify
        assertNotNull(result);
        assertEquals(todoId, result.getId());
    }

    @Test
    void testGetTodos() {
        // Mocking
        when(currentUserService.getCurrentUser()).thenReturn(createTestUser());

        // Test
        List<TodoActivity> result = todoActivityService.getTodos();

        // Verify
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testUpdateTodo() {
        // Mocking
        TodoActivity todoActivity = createTestTodoActivity();
        when(todoActivityRepository.save(any(TodoActivity.class))).thenReturn(todoActivity);

        // Test
        TodoActivity result = todoActivityService.updateTodo(todoActivity);

        // Verify
        assertNotNull(result);
        assertEquals(todoActivity.getId(), result.getId());
    }

    @Test
    void testDeleteTodo() {
        // Mocking
        long todoId = 1L;
        TodoActivity todoActivity = createTestTodoActivity();
        when(todoActivityRepository.findTaskById(todoId)).thenReturn(todoActivity);
        doNothing().when(todoActivityRepository).delete(todoActivity);

        // Test
        assertDoesNotThrow(() -> todoActivityService.deleteTodo(todoId));

        // Verify
        verify(todoActivityRepository, times(1)).delete(todoActivity);
    }

    // Helper method to create a test user
    private UserTodo createTestUser() {
        UserTodo user = new UserTodo();
        user.setId(1L);
        user.setTodoActivities((Set<TodoActivity>) Collections.singletonList(createTestTodoActivity()));
        return user;
    }

    // Helper method to create a test todo activity
    private TodoActivity createTestTodoActivity() {
        TodoActivity todoActivity = new TodoActivity();
        todoActivity.setId(1L);
        todoActivity.setTask("Task 1");
        todoActivity.setStatus(false);
        todoActivity.setStartDate(new Date());
        todoActivity.setEndDate(new Date());
        return todoActivity;
    }
}
