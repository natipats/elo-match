package com.wileyedge.elomatch;

import com.wileyedge.elomatch.model.UserModel;
import com.wileyedge.elomatch.persistence.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EloMatchApplication {

	public static void main(String[] args) {

		SpringApplication.run(EloMatchApplication.class, args);
	}

	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			UserModel sally;
			sally = new UserModel(
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

//			@Override
//			public void createUser() {
//				UserModel user1 = new UserModel();
//				user1.setPlayerName("sally");
//				user1.setUserName("salThunder");
//				user1.setElo(400);
//				user1.setToxic(true);
//
//				UserModel user2 = new UserModel();
//				user2.setPlayerName("eugene");
//				user2.setUserName("reganTeach");
//				user2.setElo(500);
//				user2.setToxic(false);
//
//				UserModel user3 = new UserModel();
//				user3.setPlayerName("rodrigo");
//				user3.setUserName("gamerLeague");
//				user3.setElo(700);
//				user3.setToxic(false);
//
//				userRepository.save(user1);
//				userRepository.save(user2);
//				userRepository.save(user3);
//			};
			userRepository.save(sally);
			userRepository.save(eugene);
		};
	}

}

