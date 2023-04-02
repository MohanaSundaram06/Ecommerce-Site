package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Orders;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean addOrders(Orders theOrders) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theOrders);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteOrders(Orders theOrders) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.remove(theOrders);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateOrders(Orders theOrders) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theOrders);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Orders> OrdersList(String username) {

        Session session = entityManager.unwrap(Session.class);

        Query<Orders> query = session.createQuery("FROM Orders where userName = :name", Orders.class);
        query.setParameter("name", username);

        return query.getResultList();

    }

    @Override
    public Orders getOrders(int id) {

        Session session = entityManager.unwrap(Session.class);

        Orders theOrders = session.get(Orders.class, id);

        return theOrders;
    }
}


































