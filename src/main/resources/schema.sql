DROP TABLE IF EXISTS given;
CREATE TABLE given (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  lastaudit DATE NOT NULL,person VARCHAR(100) NOT NULL ,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS product;
CREATE TABLE product(
  product_id  INT NOT NULL, product_name VARCHAR(100) NOT NULL , product_price DOUBLE
  NOT NULL , product_quantity INT NOT NULL , product_size VARCHAR(50) NOT NULL,
  PRIMARY KEY (product_id));