<?php
// Database credentials
$host = 'localhost'; // Change if hosted elsewhere
$username = 'root'; // Default for local MySQL
$password = ''; // Default is empty for XAMPP
$database = 'FlightBookingDB'; // Database name

// Create a connection
$conn = new mysqli($host, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve form data
$departure_city = $_POST['from'];
$destination_city = $_POST['to'];
$departure_date = $_POST['departure'];
$return_date = !empty($_POST['return']) ? $_POST['return'] : NULL;
$passengers = $_POST['passengers'];
$special_fares = isset($_POST['special-fares']) ? implode(', ', $_POST['special-fares']) : NULL;

// SQL query to insert booking details
$sql = "INSERT INTO FlightBookings (departure_city, destination_city, departure_date, return_date, passengers, special_fares) 
        VALUES ('$departure_city', '$destination_city', '$departure_date', '$return_date', '$passengers', '$special_fares')";

if ($conn->query($sql) === TRUE) {
    echo "Flight booked successfully!";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Close the connection
$conn->close();
?>
