package com.systechafrica.service;

import com.systechafrica.model.Order;

import java.sql.SQLException;

public interface OrderService {
    void saveOrder(Order order);
    Order getOrderById();
    void deleteOrderById();

}
