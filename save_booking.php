<?php
// Database configuration
$servername = "localhost";
$username = "root"; // Replace with your MySQL username
$password = "Nimit@22045";     // Replace with your MySQL password
$dbname = "bus.sql";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve form data
$from_city = $_POST['from'];
$to_city = $_POST['to'];
$departure_date = $_POST['date'];
$passengers = $_POST['passengers'];
$special_fares = implode(", ", $_POST['fare'] ?? []); // Handle multiple checkboxes
$user_id = 1; // Replace with logged-in user ID in a real application

// Insert booking details into the database
$sql = "INSERT INTO Bookings (user_id, from_city, to_city, departure_date, passengers, special_fares) 
        VALUES ('$user_id', '$from_city', '$to_city', '$departure_date', '$passengers', '$special_fares')";

if ($conn->query($sql) === TRUE) {
    echo "Booking successful!";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
