package com.busfinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/BusBookingServlet")
public class BusBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("cancel".equalsIgnoreCase(action)) {
            cancelBooking(request, response);
        } else if ("confirm".equalsIgnoreCase(action)) {
            confirmBooking(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid action.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("book".equalsIgnoreCase(action)) {
            bookBus(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid action.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void bookBus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");
        String passengers = request.getParameter("passengers");

        if (from == null || to == null || date == null || passengers == null || from.isEmpty() || to.isEmpty()
                || date.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("from", from);
        session.setAttribute("to", to);
        session.setAttribute("date", date);
        session.setAttribute("passengers", passengers);

        response.sendRedirect("BusBookingServlet?action=confirm");
    }

    private void confirmBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String from = (String) session.getAttribute("from");
        String to = (String) session.getAttribute("to");
        String date = (String) session.getAttribute("date");
        String passengers = (String) session.getAttribute("passengers");

        if (from == null || to == null || date == null || passengers == null) {
            request.setAttribute("errorMessage", "No booking data found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("date", date);
        request.setAttribute("passengers", passengers);
        request.getRequestDispatcher("confirmBooking.jsp").forward(request, response);
    }

    private void cancelBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // Clear session data to cancel booking

        request.setAttribute("message", "Your booking has been successfully canceled.");
        request.getRequestDispatcher("cancelBooking.jsp").forward(request, response);
    }
}
