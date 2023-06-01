package com.wileyedge.elomatch;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
public class EloMatchApplication  {
	public static void main(String[] args) {

		SpringApplication.run(EloMatchApplication.class, args);
	}

}

