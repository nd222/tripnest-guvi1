<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cab Booking Form</title>
    <link rel="stylesheet" href="cabstyle.css">
</head>
<body>
    <div class="form-container">
        <h2>Book Your Cab</h2>
        <form action="CabBookingServlet" method="POST">
            <div>
                <label for="pickup">Pick-up Location:</label>
                <input type="text" id="pickup" name="pickup" required>
            </div>
            <div>
                <label for="drop">Drop-off Location:</label>
                <input type="text" id="drop" name="drop" required>
            </div>
            <div>
                <label for="date">Pick-up Date:</label>
                <input type="date" id="date" name="date" required>
            </div>
            <div>
                <label for="time">Pick-up Time:</label>
                <input type="time" id="time" name="time" required>
            </div>
            <div>
                <label for="car">Select Car Type:</label>
                <select id="car" name="car" required>
                    <option value="Hatchback">Hatchback</option>
                    <option value="Sedan">Sedan</option>
                    <option value="SUV">SUV</option>
                    <option value="Luxury">Luxury</option>
                </select>
            </div>
            <button type="submit">Book Now</button>
        </form>
    </div>
</body>
</html>
