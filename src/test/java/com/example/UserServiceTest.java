package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById_ShouldReturnUser_WhenUserExists() {
        // Given
        long userId = 1L;
        User expectedUser = new User(userId, "John Doe", "john@example.com");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // When
        User actualUser = userService.getUserById(userId);

        // Then
        assertEquals(expectedUser, actualUser);
        verify(userRepository, times(1)).findUserById(userId);
    }

    @Test
    void getUserById_ShouldCallRepositoryWithCorrectId() {
        // Given
        long userId = 1L;
        User expectedUser = new User(userId, "John Doe", "john@example.com");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // When
        userService.getUserById(userId);

        // Then
        verify(userRepository, times(1)).findUserById(userId);
    }
} 