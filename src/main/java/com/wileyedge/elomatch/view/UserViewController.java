package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    // This is ThymeLeaf - HTML
    @Autowired
    private final UserService userService;

}
