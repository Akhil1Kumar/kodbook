package com.kodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kodbook.entities.User;
import com.kodbook.service.PostService;
import com.kodbook.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class UserController {

	@Autowired
	UserService service;
	@Autowired
	PostService postService;
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute User user) {
		String username = user.getUsername();
		String email = user.getEmail();
		boolean status = service.userExists(username, email);
		if(status == false) {
			service.addUser(user);
		}
		return "index";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password )  {
		boolean status= service.validateUser(username, password);
		if(status == true) {
			return "home";
		}
		return "index";
	}
	@PostMapping("/updateProfile")
	public String updateProfile(@RequestParam String dob) {
		System.out.println(dob);
		return "myProfile";
	}
	
	
	
}
