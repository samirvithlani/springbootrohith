package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	// get put post patch, delete

	static List<String> users = new ArrayList<>();

	@GetMapping(value = "/getuser")
	public List<String> getUsers() {

		users.add("Raj");
		users.add("Rahul");
		users.add("parth");
		users.add("mihir");

		return users;
	}

	@PostMapping(value = "/adduser")
	public void addUser(@RequestParam("username") String username) {

		users.add(username);
	}

}
