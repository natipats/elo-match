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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        User saveUser = userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/matchmaker")
    public String matchmakerPage(Model model) {
        //List<User> matchedUsers = matchmakingAlgorithm();
        List<User> matchedUsers = matchmakingAlgorithm();

        model.addAttribute("users_matchmaker", matchedUsers);
        return "matchmaker";
    }

    // Identifying update page so that we can update the user details from the admin side.
    @GetMapping("/users/edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model) {
        // Find the user with the provided ID in the userRepository.
        User user = userService.findUserById(id);
        if(user == null){
            throw new IllegalArgumentException("Invalid user Id:" + id);
        } else {
            model.addAttribute("user", user); // Add the found user object to the model with the key "user".
            return "updateUser"; // Return the "update" view to display the user update page.
        }
    }

    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Validated User currentUser, BindingResult result,
                                Model model) {
        // Check if there are validation errors in the user input.
        if (result.hasErrors()) {
            currentUser.setId(id); // Set the ID of the currentUser to the provided ID in the path variable.
            return "update"; // Return the "update" view to display the form with validation errors.
        }

        userService.saveUser(currentUser); // Save the updated user in the userRepository.
        model.addAttribute("users", userService.findUsers()); // Add the list of all users to the model.
        return "users"; // Redirect to the "/users" URL to display the updated list of users.
    }


    // delete a user
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        // Find the user with the provided ID in the userRepository.
        User user = userService.findUserById(id);
        if(user == null){
            throw new IllegalArgumentException("Invalid user Id:" + id);
        } else {
            userService.deleteUser(id);
            model.addAttribute("users", userService.findUsers()); // Add the list of all users to the model.
            return "redirect:/users"; // Redirect to the "/users" URL to display the updated list of users.
        }
    }

    private List<User> matchmakingAlgorithm() {
        List<User> allUsers = userService.findUsers(); // Fetch all users from the database
        List<User> matchers = new ArrayList<>();
        matchers.add(getRandomElement(allUsers));
        matchers.add(getRandomElement(allUsers));
        return matchers;
    }

    private User getRandomElement(List<User> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
