package com.ecommerce.shopping.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.shopping.entity.Orders;
import com.ecommerce.shopping.service.OrdersService;

@Controller
@RequestMapping("pandas/orders")
public class OrdersController {

	@Autowired
	private OrdersService theOrdersService;
	
	@GetMapping("/myOrders")
	public String showOrders(Model theModel, Principal principal) {
		
		List<Orders> theOrders = theOrdersService.OrdersList(principal.getName());
		
		theModel.addAttribute("orders",theOrders);
		
		return "my-orders";
	}
}
