package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Product;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean addProduct(Product theProduct) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theProduct);
        } catch (Exception e) {
            return false;
            
        }
        return true;
    }

    @Override
    public boolean deleteProduct(Product theProduct) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.remove(theProduct);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProduct(Product theProduct) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theProduct);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Product> productList() {

        Session session = entityManager.unwrap(Session.class);

        Query<Product> query = session.createQuery("FROM Product", Product.class);

        return query.getResultList();
    }

    @Override
    public Product getProduct(int id) {

        Session session = entityManager.unwrap(Session.class);

        Product theProduct = session.get(Product.class, id);

        return theProduct;
    }
}


















