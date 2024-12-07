

-- Create the CabBookings table
CREATE TABLE CabBookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pickup VARCHAR(255) NOT NULL,
    drop_off VARCHAR(255) NOT NULL,
    pickup_date DATE NOT NULL,
    pickup_time TIME NOT NULL,
    return_date DATE NULL,
    return_time TIME NULL,
    car_type VARCHAR(50) NOT NULL,
    features TEXT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

