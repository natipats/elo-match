package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Component
public class RankServiceImpl implements RankServiceInterface {

    @Autowired
    private UserRepository rankingAttached;
}
