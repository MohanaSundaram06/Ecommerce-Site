package com.ecommerce.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.shopping.entity.Category;
import com.ecommerce.shopping.service.CategoryService;

@Controller
@RequestMapping("pandas/category")
public class CategoryController {

	@Autowired
	private CategoryService theCategoryService;
	
	@GetMapping("/manage-category")
	public String showCategory(Model model) {
		
		List<Category> cagetoryList = theCategoryService.categoryList();
		
		model.addAttribute("theCategory",cagetoryList);
		
		return "/category/manage-category";
	}
	
	@GetMapping("/addCategory")
	public String showCategoryForm(Model model) {
		
		model.addAttribute("theCategory", new Category());
		
		return "/category/categoryForm";
	}
	
	
	@PostMapping("/saveCategory")
	public String addCategory(@ModelAttribute("theCategory") Category category) {
		
		theCategoryService.addCategory(category);
		
		return "redirect:manage-category";
	}
	
	
	@GetMapping("/deleteCategory")	
	public String deleteCategory(@RequestParam("categoryId") int theId) {
		
		Category theCategory = theCategoryService.getCategory(theId);
		
		theCategoryService.deleteCategory(theCategory);
		
		return "redirect:manage-category";
	}
	
	@GetMapping("/editCategory")
	public String editCategory(Model model,@RequestParam("categoryId") int theId) {
		
		Category category = theCategoryService.getCategory(theId);
		
		model.addAttribute("theCategory", category);
		
		return "/category/categoryForm";
	}
}











