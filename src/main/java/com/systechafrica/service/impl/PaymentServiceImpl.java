package com.systechafrica.service.impl;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerMySqlImpl;
import com.systechafrica.model.Payment;
import com.systechafrica.service.PaymentService;
import com.systechafrica.util.Config;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PaymentServiceImpl implements PaymentService {
    private Logger logger;

    private DatabaseHandler databaseHandler;

    public PaymentServiceImpl(DatabaseHandler databaseHandler,Logger logger) {
        this.logger = logger;
        this.databaseHandler=databaseHandler;
    }

    @Override
    public void savePayment(Payment payment) {
        try (Connection connection = databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD)) {
            logger.info("Saving payment to the db...");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payments ( order_id, payment_date,amount) VALUES (?,?,?);");
            preparedStatement.setString(1, payment.getOrderId());
            preparedStatement.setDate(2, Date.valueOf(payment.getPaymentDate()));
            preparedStatement.setDouble(3,payment.getAmount());
            preparedStatement.execute();

        } catch (ClassNotFoundException | SQLException e) {
            logger.info("Exception Saving Payment to Database: "  +e.getMessage());
        }
    }
}
