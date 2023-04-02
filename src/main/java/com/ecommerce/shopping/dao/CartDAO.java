package com.ecommerce.shopping.dao;

import java.util.List;

import com.ecommerce.shopping.entity.Cart;

public interface CartDAO {

	boolean addCart(Cart theCart);

    boolean deleteCart(Cart theCart);

    boolean updateCart(Cart theCart);

    List<Cart> CartList(String userName);

    Cart getCart(int id);
}
