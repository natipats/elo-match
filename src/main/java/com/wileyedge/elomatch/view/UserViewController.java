package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    // This is ThymeLeaf - HTML
    @Autowired
    private final UserService userService;

    /*
        data is transferred to the users HTML attribute on the users
        page.
        */
    @GetMapping("/users")
    public String displayAllUsers(Model model) {
        model.addAttribute("users", userService.findUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addNewUser(){



        }
    @GetMapping("/register")

}
