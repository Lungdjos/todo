package com.zra.todo.services;
import com.zra.todo.dto.CreateUserDTO;
import com.zra.todo.entities.UserTodo;
import com.zra.todo.repos.UserTodoRepository;
import com.zra.todo.services.implementation.UserTodoServiceImpl;
import com.zra.todo.dto.ActionResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTodoServiceImplTest {

    @Mock
    private UserTodoRepository userTodoRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserTodoServiceImpl userTodoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindUserByUsername() {
        // Mocking
        String username = "testUser";
        UserTodo userTodo = new UserTodo();
        userTodo.setUsername(username);

        when(userTodoRepository.findByUsername(username)).thenReturn(Optional.of(userTodo));

        // Test
        UserTodo result = userTodoService.findUserByUsername(username);

        // Verify
        assertNotNull(result);
        assertEquals(username, result.getUsername());
    }

    @Test
    void testFindUserByUsernameNotFound() {
        // Mocking
        String username = "nonExistentUser";

        when(userTodoRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Test
        UserTodo result = userTodoService.findUserByUsername(username);

        // Verify
        assertNull(result);
    }

    @Test
    void testCreateUser() {
        // Mocking
        CreateUserDTO userDTO = new CreateUserDTO();
        userDTO.setUsername("newUser");

        when(userTodoRepository.findByUsername(userDTO.getUsername())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(userDTO.getPassword())).thenReturn("encodedPassword");

        // Test
        ActionResult result = userTodoService.createUser(userDTO);

        // Verify
        assertTrue(result.isSucceeded());
        assertEquals("User created successfully.", result.getMessage());
        verify(userTodoRepository, times(1)).save(any(UserTodo.class));
    }

    @Test
    void testCreateUserAlreadyExists() {
        // Mocking
        CreateUserDTO userDTO = new CreateUserDTO();
        userDTO.setUsername("existingUser");

        when(userTodoRepository.findByUsername(userDTO.getUsername())).thenReturn(Optional.of(new UserTodo()));

        // Test
        ActionResult result = userTodoService.createUser(userDTO);

        // Verify
        assertFalse(result.isSucceeded());
        assertTrue(result.getMessage().contains("User already exists"));
        verify(userTodoRepository, never()).save(any(UserTodo.class));
    }

    @Test
    void testLoadUserByUsername() {
        // Mocking
        String username = "testUser";
        UserTodo userTodo = new UserTodo();
        userTodo.setUsername(username);

        when(userTodoRepository.findByUsername(username)).thenReturn(Optional.of(userTodo));

        // Test
        assertDoesNotThrow(() -> userTodoService.loadUserByUsername(username));
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        // Mocking
        String username = "nonExistentUser";

        when(userTodoRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Test
        assertThrows(UsernameNotFoundException.class, () -> userTodoService.loadUserByUsername(username));
    }
}
