import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CabBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Fetch form data
        String pickup = request.getParameter("pickup");
        String drop = request.getParameter("drop");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String carType = request.getParameter("car");

        // Construct the HTML response
        out.println("<html><body>");
        out.println("<h3>Cab Booking Summary:</h3>");
        out.println("<p><strong>Pick-up Location:</strong> " + pickup + "</p>");
        out.println("<p><strong>Drop-off Location:</strong> " + drop + "</p>");
        out.println("<p><strong>Pick-up Date:</strong> " + date + "</p>");
        out.println("<p><strong>Pick-up Time:</strong> " + time + "</p>");
        out.println("<p><strong>Car Type:</strong> " + carType + "</p>");
        out.println("</body></html>");
    }
}
