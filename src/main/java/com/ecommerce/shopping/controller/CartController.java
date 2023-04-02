package com.ecommerce.shopping.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.shopping.entity.Cart;
import com.ecommerce.shopping.entity.Orders;
import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.service.CartService;
import com.ecommerce.shopping.service.OrdersService;
import com.ecommerce.shopping.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("pandas/cart")
public class CartController {

	@Autowired
	private CartService theCartService;
	
	@Autowired
	private ProductService theProductService;
	
	@Autowired
	private OrdersService theOrdersService;
	
	@GetMapping("/yourCart")
	public String showCart(Model model,HttpSession theSession,  Principal principal ) {
		
		String theUserName = principal.getName();
		
		List<Cart> items = theCartService.CartList(theUserName);
				
		System.out.println(items);
		model.addAttribute("userName", theUserName);
		model.addAttribute("total",getTotal(items));
		model.addAttribute("cartDetails",items);
		return "cart";
	}
	
	

	private int getTotal(List<Cart> items) {
		
		int total = 0;
		
		for(Cart c : items) total += c.getPrice() * c.getQuantity();
		
		return total;
	}



	@PostMapping("/saveToCart")
	public String addToCart(@ModelAttribute("cart") Cart theCart,HttpSession theSession ,
							@RequestParam("productId") int theId, Principal principal) {
		
		theCart.setProductId(theId);
		
		theCart.setUserName(principal.getName());
		theCartService.addCart(theCart);
		
		return "redirect:yourCart";
	}
	
	@GetMapping("/updateCartItem")
	public String updateCartItem(Model theModel,@RequestParam("cartId")int theId) {
		
		Cart theCart = theCartService.getCart(theId);
		
		theModel.addAttribute("cart",theCart);
        theModel.addAttribute("productDetails", theProductService.getProduct(theCart.getProductId()));
        
        return "product/productsDetails";
	}
	
	@GetMapping("/deleteCartItem")
	public String deleteCartItem(@RequestParam("id")int theId) {
		
		theCartService.deleteCart(theCartService.getCart(theId));
		     
		return "redirect:yourCart";
	}
	

    @GetMapping("/productDetails")
    public String displayProductDetails(@RequestParam("productId") int id, Model model) {
    	
    	model.addAttribute("cart", new Cart());
        model.addAttribute("productDetails", theProductService.getProduct(id));
        return "product/productsDetails";
    }
    
    @GetMapping("/payment")
    public String payment(Model model, Principal principal) {
    	
    	String theUserName = principal.getName();
    	List<Cart> items = theCartService.CartList(theUserName);
    	
    	model.addAttribute("total",getTotal(items));
    	
    	return "paymentPage";
    }
    
    @PostMapping("/processPayment")
    public String processPayment( Principal principal) {
    	
    	String userName = principal.getName();
    	
    	List<Cart> items = theCartService.CartList(userName);
    	
    	for(Cart theCart : items) {
    		
    		Orders theOrder = new Orders();  		
    		theOrder.setUserName(userName);
    		theOrder.setProductName(theCart.getProductName());
    		theOrder.setQuantity(theCart.getQuantity());
    		theOrder.setPrice(theCart.getPrice());
    		theOrder.setTotal(theCart.getQuantity() * theCart.getPrice());
   		
    		theOrdersService.addOrders(theOrder);   		
    	}
    	
    	
    	for(Cart theCart : items) {
    		theCartService.deleteCart(theCart);
    	}
    	
    	return "redirect:/pandas/orders/myOrders";
    }
}













































