package com.systechafrica.service;

import com.systechafrica.model.Order;

import java.sql.SQLException;

public interface OrderService {
    boolean saveOrder(Order order) throws SQLException, ClassNotFoundException;
    Order getOrderById();
    void deleteOrderById();

}
