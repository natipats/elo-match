package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // If a field is private final it makes the dependency injection in the background.
public class ExperienceService {

    @Autowired
    private final UserRepository userRepository;
}
