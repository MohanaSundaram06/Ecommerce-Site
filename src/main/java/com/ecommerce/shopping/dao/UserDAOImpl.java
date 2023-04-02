package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean addUser(User theUser) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(User theUser) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.remove(theUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User theUser) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> UserList() {

        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("FROM User", User.class);

        return query.getResultList();

    }

    @Override
    public User getUser(String userName) {

        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("FROM User where email =:email",User.class);
        
        query.setParameter("email", userName);
        
        User theUser = (User) query.uniqueResult();

        return theUser;
    }
}


































