-- Table: users
CREATE TABLE users(
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 username VARCHAR(255) NOT NULL ,
 password VARCHAR(255) NOT NULL
 )
ENGINE = innoDB;

-- Table: roles
CREATE TABLE roles(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
name VARCHAR(100) NOT NULL
)
ENGINE = innoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),

    UNIQUE (user_id, role_id)
)
ENGINE =InnoDB;

-- Insert data

INSERT INTO users VALUES (1,'borys','12345678');
INSERT INTO roles VALUES  (1,'POLE_USER');
INSERT INTO roles VALUES  (2,'POLE_ADMIN');

INSERT INTO user_roles VALUES (1,2);

