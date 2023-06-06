package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

}