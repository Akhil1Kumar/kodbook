package com.kodbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodbook.entities.Post;
import com.kodbook.entities.User;
import com.kodbook.service.PostService;
import com.kodbook.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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
	public String login(Model model, HttpSession session)	{
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			if(session.getAttribute("username")!=null)
				return "home";
				else 
					return "index";
			
	}
	
	@GetMapping("/openMyProfile")
	public String openProfile(HttpSession session, Model model) {
		String username= (String)session.getAttribute("username");
		User user= service.getUser(username);
		model.addAttribute("user", user);
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		if(session.getAttribute("username")!=null)
			return "myProfile";
			else 
				return "index";
		
	}
	@PostMapping("/visitProfile")
	public String visitProfile(@RequestParam String profileName, Model model) {
		User user= service.getUser(profileName);
		model.addAttribute("user", user);
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		return "showUserProfile";
	}
	
	
	@GetMapping("/openEditProfile")
	public String editProfile(HttpSession session) {
		if(session.getAttribute("username")!=null)
		return "editProfile";
		else 
			return "index";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	
	
	
}
