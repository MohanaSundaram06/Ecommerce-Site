package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.User;

import java.util.List;

public interface UserService {

    boolean addUser(User theUser);

    boolean deleteUser(User theUser);

    boolean updateUser(User theUser);

    List<User> UserList();

    User getUser(String userName);
}
