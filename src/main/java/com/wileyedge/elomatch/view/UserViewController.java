package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.persistence.UserRepository;
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

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    // This is ThymeLeaf - HTML
    @Autowired
    private final UserService userService;
    private final UserRepository userRepository;

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

    public List<User> matchmakingAlgorithm() {
        List<User> allUsers = userRepository.findAll(); // Fetch all users from the database
        int totalUsers = allUsers.size();

        if (totalUsers >= 2) {
            Random random = new Random();
            int index1 = random.nextInt(totalUsers); // Generate a random index for the first user
            int index2 = random.nextInt(totalUsers); // Generate a random index for the second user
            System.out.println("in matchmaker");
            User user1 = allUsers.get(index1);
            User user2 = allUsers.get(index2);
            Long max = 0L;
            Long min = 0L;
            if (user1.getElo() > user2.getElo())
            {
                max = user1.getElo();
                min = user2.getElo();
            } else if (user2.getElo() > user1.getElo() )
            {
                max = user2.getElo();
                min = user1.getElo();
            }
            // Ensure that the two users have different IDs
            while (user1.getId().equals(user2.getId()) || (max - min > 100)){
                index2 = random.nextInt(totalUsers);
                user2 = allUsers.get(index2);
            }

            return List.of(user1, user2);
        } else {
            // Handle case when there are not enough users in the database
            System.out.println("list is empty");
            return Collections.emptyList();
        }
    }

    /*@GetMapping("/matchmaker/{startId}/{endId}")
    public String matchmaker(@PathVariable("startId") Integer startId,
                             @PathVariable("endId") Integer endId,
                             Model model) {

        return "redirect:/matchmaker";
    }*/
    @GetMapping("/matchmaker")
    public String matchmakerPage(Model model) {
        List<User> matchedUsers = matchmakingAlgorithm();

        model.addAttribute("users", matchedUsers);
        return "matchmaker";
    }

    // Identifying update page so that we can update the user details from the admin side.
    @GetMapping("/users/admin-edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model) {
        // Find the user with the provided ID in the userRepository.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("user", user); // Add the found user object to the model with the key "user".
        return "update-user"; // Return the "update" view to display the user update page.
    }

    @PostMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Long id, @Validated User currentUser, BindingResult result,
                                Model model) {
        // Check if there are validation errors in the user input.
        if (result.hasErrors()) {
            currentUser.setId(id); // Set the ID of the currentUser to the provided ID in the path variable.
            return "redirect:/users"; // Return the "update" view to display the form with validation errors.
        }

        userRepository.save(currentUser); // Save the updated user in the userRepository.
        model.addAttribute("users", userRepository.findAll()); // Add the list of all users to the model.
        return "redirect:/users"; // Redirect to the "/users" URL to display the updated list of users.
    }


    // delete a user
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        // Find the user with the provided ID in the userRepository.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID:" + id));
        userRepository.delete(user); // Delete the user from the userRepository.
        model.addAttribute("users", userRepository.findAll()); // Add the list of all users to the model.
        return "redirect:/users"; // Redirect to the "/users" URL to display the updated list of users.
    }
}
