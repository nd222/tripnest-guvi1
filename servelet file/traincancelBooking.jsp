<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancel Booking</title>
    <link rel="stylesheet" href="trains.css">
</head>
<body>
    <header>
        <div class="navbar">
            <h1>RailConnect</h1>
            <nav>
                <a href="index.jsp">Home</a>
                <a href="booking.jsp">Book Ticket</a>
            </nav>
        </div>
    </header>

    <main>
        <section class="booking-section">
            <h2>Cancel Your Booking</h2>
            <form action="CancelBookingServlet" method="post">
                <div class="form-group">
                    <label for="bookingId">Booking ID:</label>
                    <input type="text" id="bookingId" name="bookingId" required>
                </div>
                <button type="submit" class="search-button">Cancel Booking</button>
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 RailConnect. All rights reserved.</p>
    </footer>
</body>
</html>
