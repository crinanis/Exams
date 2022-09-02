import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "number", value = "/number")
public class number extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numb = (int) request.getSession().getAttribute("number");
        int cout = (int) request.getSession().getAttribute("count");
        int max=100;
        int min=0;
        String command = request.getParameter("command");
        if (command != null) {
            switch (command) {
                case "<": {
                    HttpSession session = request.getSession();
                    if(numb!=0){
                        numb=numb-1;
                        cout=cout+1;}
                    else {
                        session.setAttribute("error", "загаданное число должно быть больше 0");
                    }

                    session.setAttribute("number", numb);
                    session.setAttribute("count", cout);
                    request.getRequestDispatcher("/num.jsp").forward(request, response);
                    break;
                }
                case "=": {
                    HttpSession session = request.getSession();
                    session.setAttribute("number", numb);
                    String str = String.valueOf(cout);
                    Cookie cookie = new Cookie("oldcount", str);
                    response.addCookie(cookie);
                    session.setAttribute("count", cout);
                    request.getRequestDispatcher("/win.jsp").forward(request, response);
                    break;
                }
                case ">": {
                    HttpSession session = request.getSession();
                    if(numb<100){
                        numb=numb+1;
                        cout=cout+1;}
                    else {
                        session.setAttribute("error", "загаданное число должно быть меньше 100");
                    }


                    session.setAttribute("number", numb);
                    session.setAttribute("count", cout);
                    request.getRequestDispatcher("/num.jsp").forward(request, response);
                    break;
                }
            }
        }

        request.getRequestDispatcher("/num.jsp").forward(request, response);
    }
}
