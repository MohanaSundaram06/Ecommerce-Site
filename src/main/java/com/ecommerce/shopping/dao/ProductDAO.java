package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Product;

import java.util.List;

public interface ProductDAO {

    boolean addProduct(Product theProduct);

    boolean deleteProduct(Product theProduct);

    boolean updateProduct(Product theProduct);

    List<Product> productList();

    Product getProduct(int id);
}
