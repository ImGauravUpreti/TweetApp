package com.tweetapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 *  Main class
 */

@SpringBootApplication
public class TweetAppLclApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetAppLclApplication.class, args);
	}

}
