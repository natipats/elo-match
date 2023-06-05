package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/signup")
    public String addNewUser(Model model){
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup/save")
    public String addingThisNewUserToDatabase(@Validated @ModelAttribute("user")User user,
                                                       BindingResult result,
                                                       Model model) {
        User userSubmitAndAdded = userService.findUserByName(user.getPlayerName());
        userSubmitAndAdded = userService.findUserByName(user.getUserName());

        if(userSubmitAndAdded != null && userSubmitAndAdded.getPlayerName() != null && !userSubmitAndAdded.getPlayerName().isEmpty()){
            result.rejectValue("playerName", null, "ERROR: this player name does not exist");
        }

        if(userSubmitAndAdded != null && userSubmitAndAdded.getUserName() != null && !userSubmitAndAdded.getUserName().isEmpty()){
            result.rejectValue("UserName", null, "ERROR: this user name does not exist");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/signup";
        }

        userService.saveUser(user);
        return "redirect:/users";
    }

}
