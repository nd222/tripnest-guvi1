<?php
// Database configuration
$host = 'localhost';
$dbname = 'CabBookingDB';
$username = 'root';
$password = '';

// Establishing a connection
try {
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Database connection failed: " . $e->getMessage());
}

// Check if form data is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Capture form data
    $pickup = $_POST['pickup'];
    $drop = $_POST['drop'];
    $date = $_POST['date'];
    $time = $_POST['time'];
    $return_date = $_POST['return_date'] ?? null;
    $return_time = $_POST['return_time'] ?? null;
    $car_type = $_POST['car'];
    $features = isset($_POST['features']) ? implode(', ', $_POST['features']) : 'None';

    // Insert data into the database
    $query = "INSERT INTO CabBookings (pickup, drop_off, pickup_date, pickup_time, return_date, return_time, car_type, features)
              VALUES (:pickup, :drop_off, :pickup_date, :pickup_time, :return_date, :return_time, :car_type, :features)";

    $stmt = $conn->prepare($query);

    $stmt->bindParam(':pickup', $pickup);
    $stmt->bindParam(':drop_off', $drop);
    $stmt->bindParam(':pickup_date', $date);
    $stmt->bindParam(':pickup_time', $time);
    $stmt->bindParam(':return_date', $return_date);
    $stmt->bindParam(':return_time', $return_time);
    $stmt->bindParam(':car_type', $car_type);
    $stmt->bindParam(':features', $features);

    if ($stmt->execute()) {
        echo "Booking saved successfully!";
    } else {
        echo "Error saving booking.";
    }
} else {
    echo "Invalid request.";
}
?>
