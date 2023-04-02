package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Cart;

import java.util.List;

public interface CartService {

    boolean addCart(Cart theCart);

    boolean deleteCart(Cart theCart);

    boolean updateCart(Cart theCart);

    List<Cart> CartList(String userName);

    Cart getCart(int id);
}
