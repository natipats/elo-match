package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    // Mockito and mock check it on internet.
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    // run up before every test method, before every method.
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    @DisplayName("Test save user")
    public void testSaveUser(){
        // arrange
        User user = new User();
        user.setUserName("Pj");
        user.setPlayerName("cool");
        when(userRepository.save(user)).thenReturn(user);
        // act
        User savedUser = userService.saveUser(user);
        // assert
        verify(userRepository, times(1)).save(user);
        assertEquals(0L, savedUser.getElo());
        assertFalse(savedUser.getIsToxic());
    }

    @Test
    @DisplayName("Test delete an existing user")
    public void testDeleteAnExistingUser() {
        Long id = 1000L;

        User user = new User();
        user.setId(id);
        when(userRepository.findUsersById(id)).thenReturn(user);

        userService.deleteUser(id);

        // Verify the behavior
        verify(userRepository, times(1)).findUsersById(id);
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Test delete a non-existing user")
    public void testDeleteNonExistingUser() {
        Long id = 1000L;

        User user = new User();
        when(userRepository.findUsersById(id)).thenReturn(null);

        // Invoke and verify
        assertThrows(IllegalArgumentException.class, () -> {
            userService.deleteUser(id);
        });

        // Verify the behavior
        verify(userRepository, times(1)).findUsersById(id);
        verify(userRepository, never()).delete(any(User.class));
    }


}