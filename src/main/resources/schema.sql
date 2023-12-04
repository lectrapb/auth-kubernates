DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS  users (user_id INT NOT NULL AUTO_INCREMENT,
user_name VARCHAR(255),
user_email VARCHAR(255),
user_password VARCHAR(255),
create_at TIMESTAMP,
PRIMARY KEY (user_id));
