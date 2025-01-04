import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

@WebServlet("/TrainBookingServlet")
public class TrainBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the JSP page for search results
        request.getRequestDispatcher("trainSearchResults.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Parse JSON data from the request body
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = request.getReader().readLine()) != null) {
                jsonData.append(line);
            }

            JSONObject jsonObject = new JSONObject(jsonData.toString());
            String from = jsonObject.getString("from");
            String to = jsonObject.getString("to");
            String date = jsonObject.getString("date");
            String travelClass = jsonObject.getString("travelClass");

            // Example response (replace this with real database query results)
            JSONObject responseJson = new JSONObject();
            if (!from.isEmpty() && !to.isEmpty()) {
                responseJson.put("success", true);
                responseJson.put("trains", new String[] { "Train1", "Train2", "Train3" });
            } else {
                responseJson.put("success", false);
            }

            out.print(responseJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false}");
        } finally {
            out.close();
        }
    }
}
