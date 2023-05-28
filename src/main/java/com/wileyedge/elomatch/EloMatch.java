package com.wileyedge.elomatch;

import com.wileyedge.elomatch.model.UserModel;
import com.wileyedge.elomatch.persistence.UserRepository;
import org.springframework.boot.SpringApplication;

public class EloMatch {
    protected final UserRepository userRepository;

    public EloMatch(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(EloMatchApplication.class, args);
    }

    public void run(String... args) throws Exception {
        UserModel sally = new UserModel(
                "sally",
                "salThunder",
                400,
                true
        );

        UserModel eugene = new UserModel(
                "eugene",
                "reganTeach",
                500,
                false
        );

        userRepository.save(sally);
        userRepository.save(eugene);
    }
}
