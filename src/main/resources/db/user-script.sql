
CREATE USER 'transaction'@'localhost' IDENTIFIED BY 'inbound123';

GRANT ALL PRIVILEGES ON * . * TO 'transaction'@'localhost';

FLUSH PRIVILEGES;