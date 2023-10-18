USE javase;
CREATE TABLE IF NOT EXISTS users
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders
(
    order_id   VARCHAR(255) PRIMARY KEY,
    order_time DATETIME DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS products
(
    id   VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    order_id VARCHAR(255)NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS payments
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(255) NOT NULL,
    payment_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON UPDATE CASCADE

);

INSERT  INTO users ( username, password) VALUES ('admin','Admin123');
/*INSERT INTO orders (order_id, order_time)
VALUES (?, ?); */
INSERT INTO payments ( order_id, payment_date,amount) VALUES (?,?);