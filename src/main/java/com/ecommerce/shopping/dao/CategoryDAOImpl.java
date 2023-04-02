package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Category;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean addCategory(Category theCategory) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theCategory);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCategory(Category theCategory) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.remove(theCategory);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCategory(Category theCategory) {

        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(theCategory);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Category> categoryList() {

        Session session = entityManager.unwrap(Session.class);

        Query<Category> query = session.createQuery("FROM Category", Category.class);

        return query.getResultList();

    }

    @Override
    public Category getCategory(int id) {

        Session session = entityManager.unwrap(Session.class);

        Category theCategory = session.get(Category.class, id);

        return theCategory;
    }
}


































