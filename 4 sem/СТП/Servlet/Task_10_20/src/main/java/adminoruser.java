import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "adminoruser", value = "/adminoruser")
public class adminoruser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
if (login.equals("admin"))
{
    request.getRequestDispatcher("TimeSessionServlet").forward(request, response);
}
if (login.equals("user"))
{     response.sendRedirect("foruser");}
else
    request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

