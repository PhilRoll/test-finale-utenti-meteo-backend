CREATE SCHEMA weather_db;

USE weather_db;


CREATE TABLE user (
    id_u INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    lastname VARCHAR(255),
    city VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE weather (
    id_w INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    country VARCHAR(255),
    day DATE,
    forecast_text VARCHAR(255),
    max_temp_celsius DOUBLE,
    min_temp_celsius DOUBLE,
    wind_average_kmh DOUBLE,
    fk_u INT,
    FOREIGN KEY (fk_u) REFERENCES user(id_u)
);