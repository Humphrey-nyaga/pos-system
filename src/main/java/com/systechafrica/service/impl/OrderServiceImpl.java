package com.systechafrica.service.impl;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerMySqlImpl;
import com.systechafrica.model.Order;
import com.systechafrica.service.OrderService;
import com.systechafrica.util.Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class OrderServiceImpl implements OrderService {
    private Logger logger;
    DatabaseHandler databaseHandler;


    public OrderServiceImpl(Logger logger) {
        this.logger = logger;
        databaseHandler = new DatabaseHandlerMySqlImpl();
    }

    @Override
    public void saveOrder(Order order) {
        try (Connection connection = databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (order_id) VALUES (?);");
            preparedStatement.setString(1, order.getOrderId());
            preparedStatement.execute();
            logger.info("Saving order to database...");
        }catch (SQLException | ClassNotFoundException e){
            logger.info("Order Could Not Be Saved!! " + e.getMessage());
        }
    }

    @Override
    public Order getOrderById() {
        return null;
    }

    @Override
    public void deleteOrderById() {

    }
}
