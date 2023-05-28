package com.wileyedge.elomatch;

import com.wileyedge.elomatch.persistence.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EloMatchApplication extends EloMatch {
	// Call the constructor of the parent class EloMatch.
	public EloMatchApplication(UserRepository userRepository) {
		super(userRepository);
	}

}

