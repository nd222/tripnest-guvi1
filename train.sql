-- Create Database
CREATE DATABASE RailConnect;

-- Use the created database
USE RailConnect;

-- Create Table for Train Booking
CREATE TABLE train_bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    from_city VARCHAR(100),
    to_city VARCHAR(100),
    journey_date DATE,
    class VARCHAR(50),
    disability_concession BOOLEAN DEFAULT FALSE,
    flexible_with_date BOOLEAN DEFAULT FALSE,
    berth_availability BOOLEAN DEFAULT FALSE,
    railway_pass BOOLEAN DEFAULT FALSE,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
