package com.ecommerce.shopping.service;

import com.ecommerce.shopping.dao.UserDAO;
import com.ecommerce.shopping.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO theUserDAO;

    @Override
    @Transactional
    public boolean addUser(User theUser) {

        return theUserDAO.addUser(theUser);
    }

    @Override
    @Transactional
    public boolean deleteUser(User theUser) {

        return theUserDAO.deleteUser(theUser);
    }

    @Override
    @Transactional
    public boolean updateUser(User theUser) {

        return theUserDAO.updateUser(theUser);
    }

    @Override
    @Transactional
    public List<User> UserList() {

        return theUserDAO.UserList();
    }

    @Override
    @Transactional
    public User getUser(String userName) {

        return theUserDAO.getUser(userName);
    }
}
