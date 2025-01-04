<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Booking - FlightFinder</title>
    <link rel="stylesheet" href="flight.css">
    <script src="flight.js" defer></script>
</head>
<body>
    <!-- Background Image -->
    <img src="airport_bg.jpg" alt="Background Image" class="background-img">

    <!-- Navigation Bar -->
    <header>
        <h1>FlightFinder</h1>
        <nav>
            <a href="#">Flights</a>
            <a href="#">Hotels</a>
            <a href="#">Trains</a>
            <a href="#">Buses</a>
            <a href="#">Offers</a>
            <a href="#">Customer Service</a>
            <button class="login-button">Log in/Sign up</button>
        </nav>
    </header>

    <!-- Booking Section -->
    <section class="booking-section">
        <div class="tabs">
            <button class="tab-button active" onclick="selectTripType('one-way')">One Way</button>
            <button class="tab-button" onclick="selectTripType('round-trip')">Round Trip</button>
        </div>
        
        <form id="flightForm" class="form-container" method="POST" action="flightBooking">
            <label for="from">From:</label>
            <select id="from" name="from" required>
                <option value="">Select departure city</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Delhi">Delhi</option>
                <option value="Bengaluru">Bengaluru</option>
                <option value="Chennai">Chennai</option>
                <option value="Hyderabad">Hyderabad</option>
                <option value="Kolkata">Kolkata</option>
                <option value="Ahmedabad">Ahmedabad</option>
                <option value="Pune">Pune</option>
                <option value="Jaipur">Jaipur</option>
                <option value="Goa">Goa</option>
            </select>

            <label for="to">To:</label>
            <select id="to" name="to" required>
                <option value="">Select destination city</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Delhi">Delhi</option>
                <option value="Bengaluru">Bengaluru</option>
                <option value="Chennai">Chennai</option>
                <option value="Hyderabad">Hyderabad</option>
                <option value="Kolkata">Kolkata</option>
                <option value="Ahmedabad">Ahmedabad</option>
                <option value="Pune">Pune</option>
                <option value="Jaipur">Jaipur</option>
                <option value="Goa">Goa</option>
            </select>

            <label for="departure">Departure Date:</label>
            <input type="date" id="departure" name="departure" required>

            <div id="return-date-group" style="display:none;">
                <label for="return">Return Date:</label>
                <input type="date" id="return" name="return">
            </div>

            <label for="passengers">Passengers:</label>
            <input type="number" id="passengers" name="passengers" min="1" value="1" required>

            <label>Special Fares (Optional):</label>
            <div>
                <input type="checkbox" id="student" name="special-fares[]" value="Student">
                <label for="student">Student</label>
                <input type="checkbox" id="senior" name="special-fares[]" value="Senior Citizen">
                <label for="senior">Senior Citizen</label>
                <input type="checkbox" id="armed-forces" name="special-fares[]" value="Armed Forces">
                <label for="armed-forces">Armed Forces</label>
            </div>

            <button type="submit" class="search-button">Search Flights</button>
        </form>
    </section>

    <!-- Footer Section -->
    <footer>
        <div class="footer-links">
            <a href="#">Flight Tracker</a>
            <a href="#">Book Visa</a>
            <a href="#">Travel Insurance</a>
            <a href="#">Plan</a>
            <a href="#">Car Rentals</a>
            <a href="#">Group Booking</a>
            <a href="#">Airport Cabs</a>
            <a href="#">Credit Card</a>
            <a href="#">Fare Alerts</a>
        </div>
        <p>&copy; 2024 FlightFinder. All rights reserved.</p>
    </footer>
</body>
</html>
