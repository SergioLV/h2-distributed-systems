CREATE TABLE IF NOT EXISTS sales (
    cartId INT NOT NULL,
    client VARCHAR(80) NOT NULL,
    amount INT NOT NULL,
    sale_date VARCHAR(30) NOT NULL,
    remaining_stock INT NOT NULL,
    latitude Decimal(8,6) NOT NULL,
    longitude Decimal(9,6) NOT NULL,
    PRIMARY KEY (cartId)
)