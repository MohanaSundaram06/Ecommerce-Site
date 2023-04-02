package com.ecommerce.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.shopping.entity.User;
import com.ecommerce.shopping.service.UserService;

@Controller
@RequestMapping("pandas/")
public class UserController {

	@Autowired
	private UserService theUserSevice;
	
	
	@PostMapping("/saveUser")
	public String setRole(@ModelAttribute("theUser") User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    
	    user.setPassword(encodedPassword);
		theUserSevice.addUser(user);
//		System.out.println(user);
		
		return "redirect:/login";		
	}
	
	
	
	
}



























