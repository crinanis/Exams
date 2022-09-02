import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "game", value = "/game")
public class game extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        Cookie c = null;
        if(cookies!=null){
            for (int i = 0; i < cookies.length; i++) {
                if (i == (cookies.length - 1)) {
                    c = cookies[i];
                    int old=Integer.parseInt(c.getValue());
                    session.setAttribute("oldcount", old);
                }
            }}
        else
        {
            session.setAttribute("oldcount", 0);
        }
        int max = 100;
        int min = 0;
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);


        session.setAttribute("count", min);
        session.setAttribute("number", x);
        request.getRequestDispatcher("/num.jsp").forward(request, response);
    }
}
