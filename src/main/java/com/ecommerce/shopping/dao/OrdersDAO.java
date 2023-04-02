package com.ecommerce.shopping.dao;

import java.util.List;

import com.ecommerce.shopping.entity.Orders;

public interface OrdersDAO {

	boolean addOrders(Orders theOrders);

    boolean deleteOrders(Orders theOrders);

    boolean updateOrders(Orders theOrders);

    List<Orders> OrdersList(String userName);

    Orders getOrders(int id);
}