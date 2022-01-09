package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudStorageApplication {
	//@Autowired
	//private static  UserService userService;
	public static void main(String[] args) {

		SpringApplication.run(CloudStorageApplication.class, args);
		//User user = new User(null, "user", null, "user", "mobeen", "zar");

		//userService.createUser(user);
	}

}
