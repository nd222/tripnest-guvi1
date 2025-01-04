<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Confirmation - FlightFinder</title>
</head>
<body>
    <h1>Booking Confirmation</h1>
    <h3>Your Flight Search Summary:</h3>
    <p><strong>From:</strong> ${from}</p>
    <p><strong>To:</strong> ${to}</p>
    <p><strong>Departure Date:</strong> ${departureDate}</p>
    <p><strong>Return Date:</strong> ${returnDate != null ? returnDate : "N/A"}</p>
    <p><strong>Passengers:</strong> ${passengers}</p>
    <p><strong>Special Fares:</strong> ${specialFares}</p>

    <p>Thank you for using FlightFinder! We hope you have a great journey.</p>
</body>
</html>
