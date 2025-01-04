<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
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
            <h2>Something Went Wrong</h2>
            <p>We encountered an error while processing your request.</p>
            <p><strong>Error Message:</strong> <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Unknown error" %></p>
            <a href="index.jsp" class="search-button">Back to Home</a>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 RailConnect. All rights reserved.</p>
    </footer>
</body>
</html>
