import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FlightBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get the form data from the request
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureDate = request.getParameter("departure");
        String returnDate = request.getParameter("return");
        String passengers = request.getParameter("passengers");

        // Validate mandatory fields
        if (from == null || from.isEmpty() || to == null || to.isEmpty() ||
                departureDate == null || departureDate.isEmpty() || passengers == null || passengers.isEmpty()) {
            response.sendRedirect("errorPage.jsp"); // Redirect to an error page if validation fails
            return;
        }

        // Handle special fares (if selected)
        StringBuilder specialFares = new StringBuilder();
        String[] specialFaresList = request.getParameterValues("special-fares[]");
        if (specialFaresList != null) {
            for (String fare : specialFaresList) {
                specialFares.append(fare).append(" ");
            }
        }

        // Prepare the flight booking summary
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("departureDate", departureDate);
        request.setAttribute("returnDate", returnDate);
        request.setAttribute("passengers", passengers);
        request.setAttribute("specialFares", specialFares.length() > 0 ? specialFares.toString() : "None");

        // Forward the request to the JSP page for displaying the summary
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bookingConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
