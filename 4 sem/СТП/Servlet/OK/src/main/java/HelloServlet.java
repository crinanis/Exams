import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String weight = request.getParameter("weight");
        String rost = request.getParameter("rost");
        double weightInt = Integer.parseInt(String.valueOf(weight));
        double rostInt = Integer.parseInt(String.valueOf(rost));

        String result;
        double IMT = weightInt/Math.pow(rostInt, 2);
        if(IMT>19.5 && IMT<22.9){
            result ="Норма";
        }
        else  if(IMT>23 && IMT<27.7){
            result ="збыток массы тела";
        } else  if(IMT>27 && IMT<29.9){
            result ="Ожирение 1 степени";
        }  else  if(IMT>30 && IMT<34.9){
            result ="Ожирение 2 степени";
            request.setAttribute("IMT", String.valueOf(IMT));
            request.setAttribute("result", result);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    public void destroy() {
    }
}