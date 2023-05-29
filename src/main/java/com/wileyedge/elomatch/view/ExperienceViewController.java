package com.wileyedge.elomatch.view;

import com.wileyedge.elomatch.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ExperienceViewController {

    private final ExperienceService experienceService;
}
