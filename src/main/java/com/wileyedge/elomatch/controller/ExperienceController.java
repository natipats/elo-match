package com.wileyedge.elomatch.controller;


import com.wileyedge.elomatch.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

// Add the @RestController annotation to indicate it's a special controller
@RestController
// Add the @RequiredArgsConstructor annotation to generate a constructor for dependencies
@RequiredArgsConstructor
public class ExperienceController {

    //declares a constant variable named rankServiceInterface
    // of type RankServiceInterface that cannot be changed once it is set
    private final ExperienceService experienceService;
}
