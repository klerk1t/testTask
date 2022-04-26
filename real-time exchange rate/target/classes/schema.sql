DROP TABLE IF EXISTS currency_rate;

CREATE TABLE currency_rate (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    rate NUMERIC(10, 5),
    date DATE
);
