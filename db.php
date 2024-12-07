<?php
$servername = "localhost";
$username = "root"; // replace with your MySQL username
$password = ""; // replace with your MySQL password
$dbname = "travel_booking_platform";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
