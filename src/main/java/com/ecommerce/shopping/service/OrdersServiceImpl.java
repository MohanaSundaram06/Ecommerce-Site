package com.ecommerce.shopping.service;

import com.ecommerce.shopping.dao.OrdersDAO;
import com.ecommerce.shopping.entity.Orders;
import com.ecommerce.shopping.entity.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO theOrdersDAO;

    @Override
    @Transactional
    public boolean addOrders(Orders theOrders) {

    	
        return theOrdersDAO.addOrders(theOrders);
    }

    @Override
    @Transactional
    public boolean deleteOrders(Orders theOrders) {

        return theOrdersDAO.deleteOrders(theOrders);
    }

    @Override
    @Transactional
    public boolean updateOrders(Orders theOrders) {

        return theOrdersDAO.updateOrders(theOrders);
    }

    @Override
    @Transactional
    public List<Orders> OrdersList(String userName) {

        return theOrdersDAO.OrdersList(userName);
    }

    @Override
    @Transactional
    public Orders getOrders(int id) {

        return theOrdersDAO.getOrders(id);
    }
}
