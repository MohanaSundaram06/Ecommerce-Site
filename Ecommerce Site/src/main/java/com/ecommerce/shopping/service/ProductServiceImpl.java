package com.ecommerce.shopping.service;

import com.ecommerce.shopping.dao.ProductDAO;
import com.ecommerce.shopping.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO theProductDAO;

    @Override
    @Transactional
    public boolean addProduct(Product theProduct) {

        return theProductDAO.addProduct(theProduct);
    }

    @Override
    @Transactional
    public boolean deleteProduct(Product theProduct) {

        return theProductDAO.deleteProduct(theProduct);
    }

    @Override
    @Transactional
    public boolean updateProduct(Product theProduct) {

        return theProductDAO.updateProduct(theProduct);
    }

    @Override
    @Transactional
    public List<Product> productList() {

        return theProductDAO.productList();
    }

    @Override
    @Transactional
    public Product getProduct(int id) {

        return theProductDAO.getProduct(id);
    }
}
