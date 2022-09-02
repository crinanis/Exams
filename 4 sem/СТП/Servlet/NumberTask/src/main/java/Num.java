import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "num", value = "/nums")
public class Num extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        int max=100;
        int min =0;
        int x = (int) ((Math.random()*((max-min)+1))+min);
        HttpSession session = request.getSession();
        session.setAttribute("oldcount", 0);
        session.setAttribute("count", min);
        session.setAttribute("number", x);
        request.getRequestDispatcher("/num.jsp").forward(request, response);

    }
}
