<?php
// Database credentials
$host = 'localhost'; // Change if hosted elsewhere
$username = 'root'; // Default for local MySQL
$password = ''; // Default is empty for XAMPP
$database = 'CabBookingDB'; // Ensure this matches the database name

// Create a connection
$conn = new mysqli($host, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve form data
$pickup = $_POST['pickup'];
$drop = $_POST['drop'];
$date = $_POST['date'];
$time = $_POST['time'];
$car = $_POST['car'];

// SQL query to insert booking details
$sql = "INSERT INTO CabBookings (pickup, drop_off, pickup_date, pickup_time, car_type) 
        VALUES ('$pickup', '$drop', '$date', '$time', '$car')";

if ($conn->query($sql) === TRUE) {
    echo "Booking successful!";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Close the connection
$conn->close();
?>
