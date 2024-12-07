-- Create a new database
CREATE DATABASE travel_booking_platform;

-- Use the database
USE travel_booking_platform;

-- Table for storing user details (for login/registration purposes)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for storing flight bookings
CREATE TABLE flight_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    departure_city VARCHAR(100),
    arrival_city VARCHAR(100),
    departure_date DATE,
    return_date DATE,
    passengers INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table for storing bus bookings
CREATE TABLE bus_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    departure_city VARCHAR(100),
    arrival_city VARCHAR(100),
    departure_date DATE,
    passengers INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table for storing train bookings
CREATE TABLE train_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    from_city VARCHAR(100),
    to_city VARCHAR(100),
    journey_date DATE,
    class VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table for storing cab bookings
CREATE TABLE cab_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    pickup_location VARCHAR(100),
    drop_location VARCHAR(100),
    booking_date DATE,
    passengers INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table for storing monument visits
CREATE TABLE monument_visits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    monument_name VARCHAR(100),
    visit_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
