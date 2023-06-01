package com.wileyedge.elomatch;

import com.wileyedge.elomatch.entity.User;
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
		User sky = new User(
				"sky",
				"blueIsColourOfSky",
				400L,
				false
		);

		User sally = new User(
				"sally",
				"salThunder",
				400L,
				true
		);

		User eugene = new User(
				"eugene",
				"reganTeach",
				2600L,
				false
		);

		User rachel = new User(
				"rachel",
				"musicSonic",
				500L,
				false
		);

		User peter = new User(
				"peter",
				"pete_spidey",
				4000L,
				true
		);

		User rodrigo = new User(
				"rodrigo",
				"natipats",
				3000L,
				true
		);

		User gemma = new User(
				"gemma",
				"jumpEighty",
				1700L,
				false
		);

		User magnus = new User(
				"magnus",
				"guidedLegend",
				2000L,
				true
		);

		User scott = new User(
				"scott",
				"zeroDriver",
				2800L,
				false
		);

		User melissa = new User(
				"melissa",
				"gamerLeague",
				2850L,
				true
		);


		userService.saveUser(sky);
		userService.saveUser(sally);
		userService.saveUser(eugene);
		userService.saveUser(rachel);
		userService.saveUser(peter);
		userService.saveUser(rodrigo);
		userService.saveUser(gemma);
		userService.saveUser(magnus);
		userService.saveUser(scott);
		userService.saveUser(melissa);

	}
}

