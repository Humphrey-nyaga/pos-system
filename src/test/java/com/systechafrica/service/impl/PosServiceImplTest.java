package com.systechafrica.service.impl;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerMySqlImpl;
import com.systechafrica.service.AuthenticationService;
import com.systechafrica.service.OrderService;
import com.systechafrica.service.PaymentService;
import com.systechafrica.service.PosService;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosServiceImplTest {

    private PosService posService;

    @BeforeEach
    void setup() {
        DatabaseHandler databaseHandler = new DatabaseHandlerMySqlImpl();
        Logger logger = Logger.getLogger(PosServiceImplTest.class.getName());
        AuthenticationService authenticationService = new AuthenticationServiceImpl(databaseHandler, logger);
        PaymentService paymentService = new PaymentServiceImpl(databaseHandler, logger);
        OrderService orderService = new OrderServiceImpl(databaseHandler,logger);
        posService = new PosServiceImpl(authenticationService, paymentService, orderService, logger);
    }

    @Test
    @Disabled
    void startApplication() {
        posService.startApplication();
    }
}