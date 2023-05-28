package com.wileyedge.elomatch.controller;

import com.wileyedge.elomatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    //declares a constant variable named userServiceInterface
    // of type UserServiceInterface that cannot be changed once it is set.
    private final UserService userService;
}
