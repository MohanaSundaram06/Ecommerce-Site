package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User theUser);

    boolean deleteUser(User theUser);

    boolean updateUser(User theUser);

    List<User> UserList();

    User getUser(String userName);

}


















