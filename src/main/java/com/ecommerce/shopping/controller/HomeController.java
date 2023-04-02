package com.ecommerce.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.shopping.entity.User;
import com.ecommerce.shopping.service.CategoryService;
import com.ecommerce.shopping.service.ProductService;


@Controller
@RequestMapping("/pandas")
public class HomeController {

	@Autowired
	private ProductService theProductService;
	 
	@GetMapping("/home")
    public String showHome(Model model) {
		
		model.addAttribute("productDetails", theProductService.productList());
        return "gallery";
    }
	 
    @GetMapping("/login")
    public String showLoginForm(Model model) {

        return "redirect:/login";
    }
    
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

    	model.addAttribute("theUser", new User());
    	
        return "registrationForm";
    }
    
    @GetMapping("/about")
    public String showAboutUs(Model model) {
    	
        return "aboutUs";
    }
    
    
    @GetMapping("/products")
    public String displayGallery(Model model) {

        model.addAttribute("productDetails", theProductService.productList());

        return "gallery";

    }

}
