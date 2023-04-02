package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Product;

import java.util.List;

public interface ProductService {

    boolean addProduct(Product theProduct);

    boolean deleteProduct(Product theProduct);

    boolean updateProduct(Product theProduct);

    List<Product> productList();

    Product getProduct(int id);
}
