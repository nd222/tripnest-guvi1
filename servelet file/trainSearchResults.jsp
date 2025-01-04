<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Train Search Results</title>
    <link rel="stylesheet" href="trains.css">
</head>
<body>
    <header>
        <div class="navbar">
            <h1>RailConnect</h1>
            <nav>
                <a href="#">Home</a>
                <a href="#">Booking</a>
                <a href="#">Contact</a>
            </nav>
        </div>
    </header>

    <main>
        <section class="results-section">
            <h2>Train Search Results</h2>
            <ul>
                <% 
                    // Placeholder for train results
                    String[] trains = (String[]) request.getAttribute("trains");
                    if (trains != null) {
                        for (String train : trains) {
                            out.println("<li>" + train + "</li>");
                        }
                    } else {
                        out.println("<p>No trains found. Please try again.</p>");
                    }
                %>
            </ul>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 RailConnect. All rights reserved.</p>
    </footer>
</body>
</html>
