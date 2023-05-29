package com.wileyedge.elomatch;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.persistence.UserRepository;
import com.wileyedge.elomatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
public class EloMatchApplication implements ApplicationRunner {

	private final UserService userService;
	public static void main(String[] args) {

		SpringApplication.run(EloMatchApplication.class, args);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
     // Automatically doing what we write here.
		User sally = new User(
				"sally",
				"salThunder",
				400L,
				true
		);

		User eugene = new User(
				"eugene",
				"reganTeach",
				500L,
				false
		);

		userService.saveUser(sally);
		userService.saveUser(eugene);

	}
}

