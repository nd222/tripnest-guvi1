<?php
$servername = "localhost"; // or your server name
$username = "root";        // your MySQL username
$password = "";            // your MySQL password
$dbname = "RailConnect";   // database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Collect form data
$from_city = $_POST['from'];
$to_city = $_POST['to'];
$journey_date = $_POST['date'];
$class = $_POST['class'];
$disability_concession = isset($_POST['disability']) ? 1 : 0;
$flexible_with_date = isset($_POST['flexible']) ? 1 : 0;
$berth_availability = isset($_POST['berth']) ? 1 : 0;
$railway_pass = isset($_POST['railway-pass']) ? 1 : 0;

// Prepare SQL to insert form data into the database
$sql = "INSERT INTO train_bookings (from_city, to_city, journey_date, class, disability_concession, flexible_with_date, berth_availability, railway_pass)
        VALUES ('$from_city', '$to_city', '$journey_date', '$class', $disability_concession, $flexible_with_date, $berth_availability, $railway_pass)";

if ($conn->query($sql) === TRUE) {
    echo "Booking successfully submitted!";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Close connection
$conn->close();
?>
