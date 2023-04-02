package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Cart;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean addCart(Cart theCart) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theCart);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCart(Cart theCart) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.remove(theCart);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCart(Cart theCart) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theCart);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Cart> CartList(String username) {

        Session session = entityManager.unwrap(Session.class);

        Query<Cart> query = session.createQuery("FROM Cart where userName = :name and paymentStatus = 'NP'", Cart.class);
        query.setParameter("name", username);

        return query.getResultList();

    }

    @Override
    public Cart getCart(int id) {

        Session session = entityManager.unwrap(Session.class);

        Cart theCart = session.get(Cart.class, id);

        return theCart;
    }
}


































