package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Orders;

import java.util.List;

public interface OrdersService {

    boolean addOrders(Orders theOrders);

    boolean deleteOrders(Orders theOrders);

    boolean updateOrders(Orders theOrders);

    List<Orders> OrdersList(String userName);

    Orders getOrders(int id);
}
