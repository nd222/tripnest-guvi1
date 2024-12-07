CREATE DATABASE FlightBookingDB;

USE FlightBookingDB;

CREATE TABLE FlightBookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    departure_city VARCHAR(255) NOT NULL,
    destination_city VARCHAR(255) NOT NULL,
    departure_date DATE NOT NULL,
    return_date DATE,
    passengers INT NOT NULL,
    special_fares VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
