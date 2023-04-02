package com.ecommerce.shopping.service;

import com.ecommerce.shopping.dao.CartDAO;
import com.ecommerce.shopping.entity.Cart;
import com.ecommerce.shopping.entity.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO theCartDAO;
    
    @Autowired
    private ProductService theProductService;

    @Override
    @Transactional
    public boolean addCart(Cart theCart) {

    	Product theProduct = theProductService.getProduct(theCart.getProductId());
    	
    	theCart.setProductName(theProduct.getProductName());
    	theCart.setPrice(theProduct.getPrice());
    	theCart.setPaymentStatus("NP");
        return theCartDAO.addCart(theCart);
    }

    @Override
    @Transactional
    public boolean deleteCart(Cart theCart) {

        return theCartDAO.deleteCart(theCart);
    }

    @Override
    @Transactional
    public boolean updateCart(Cart theCart) {

        return theCartDAO.updateCart(theCart);
    }

    @Override
    @Transactional
    public List<Cart> CartList(String userName) {

        return theCartDAO.CartList(userName);
    }

    @Override
    @Transactional
    public Cart getCart(int id) {

        return theCartDAO.getCart(id);
    }
}
