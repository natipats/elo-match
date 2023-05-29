package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ExperienceViewController {

    /*
    the ExperienceViewController acts as a controller that relies on the ExperienceService
    to perform operations related to experiences. By using constructor injection,
    the ExperienceService instance is automatically provided to the controller,
    allowing it to access the necessary functionality to handle HTTP requests
    and process the associated business logic.
     */
    private final ExperienceService experienceService;
}
