CREATE SCHEMA `db_fanaticos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE db_fanaticos;

# Cria a tabela clientes
CREATE TABLE customers (
    customer_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    is_whatsapp BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (customer_id)
) ENGINE=InnoDB;

# Cria a tabela de endereços de entrega
CREATE TABLE delivery_address(
    address_id INT NOT NULL AUTO_INCREMENT,
    address_1 VARCHAR(200) NOT NULL,
    number_1 VARCHAR(5) NOT NULL,
    address_2 VARCHAR(200),
    number_2 VARCHAR(5),
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    zipcode VARCHAR(20) NOT NULL,
    PRIMARY KEY (address_id)
) ENGINE=InnoDB;

# Cria a tabela de itens do menu
CREATE TABLE items (
		item_id VARCHAR(10) NOT NULL,
        sku VARCHAR(20) NOT NULL,
        name VARCHAR(100) NOT NULL,
        size VARCHAR(10) NOT NULL,
        category VARCHAR(20) NOT NULL,
		price DECIMAL(10,2) NOT NULL,
        PRIMARY KEY(item_id)
);

# Cria o index na coluna SKU da tabela itens, que será usada como chave estrangeira na tabela receita
CREATE INDEX idx_sku ON items(sku);

# Cria a tabela de ordem de pedido
CREATE TABLE orders (
	row_id INT NOT NULL AUTO_INCREMENT,
    order_id VARCHAR(10) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    item_id VARCHAR(10) NOT NULL,
    quanlity INT NOT NULL,
    customer_id INT NOT NULL,
    delivery BOOLEAN NOT NULL,
	address_id INT NOT NULL,
    restaurant BOOLEAN NOT NULL,
    PRIMARY KEY (row_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (address_id) REFERENCES delivery_address(address_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
) ENGINE=InnoDB;

# Cria a tabela ingredientes
CREATE TABLE ingredient(
    ingredient_id VARCHAR(20) NOT NULL,
    name VARCHAR(200) NOT NULL,
    weight INT NOT NULL,
    meas VARCHAR(20) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    PRIMARY KEY (ingredient_id)
);

# Cria a tabela de inventário
CREATE TABLE inventory(
    inventory_id INT NOT NULL AUTO_INCREMENT,
    item_id VARCHAR(20) NOT NULL,
    quanlity INT NOT NULL,
    PRIMARY KEY (inventory_id),
    FOREIGN KEY (item_id) REFERENCES ingredient(ingredient_id) ON DELETE CASCADE
);

# Cria a tabela de receitas
CREATE TABLE recipe (
    row_id INT NOT NULL AUTO_INCREMENT,
    recipe_id VARCHAR(20) NOT NULL,
    ingredient_id VARCHAR(20) NOT NULL,
    ingredient_quanlity INT NOT NULL,
    PRIMARY KEY(row_id),
    FOREIGN KEY (recipe_id) REFERENCES items(sku) ON DELETE CASCADE,
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id) ON DELETE CASCADE,
    FOREIGN KEY (ingredient_id) REFERENCES inventory(item_id) ON DELETE CASCADE
);

