package com.kodbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodbook.entities.Post;
import com.kodbook.service.PostService;
import com.kodbook.service.UserService;



@Controller
public class NavigationController {

	@Autowired
	UserService service;
	@Autowired
	PostService postService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	@GetMapping("/openCreatePost")
	public String createPost() {
		return "post";
	}
	@GetMapping("/goHome")
	public String login(Model model)	{
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
	}
	
	@GetMapping("/openMyProfile")
	public String openProfile() {
		return "myProfile";
	}
	
	@GetMapping("/openEditProfile")
	public String editProfile() {
		return "editProfile";
	}
	
	
	
	
}
