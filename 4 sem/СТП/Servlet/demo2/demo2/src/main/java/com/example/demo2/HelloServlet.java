package com.example.demo2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double vec = Integer.parseInt(request.getParameter("vec"));
        double roct = Integer.parseInt(request.getParameter("roct"));
        double index=0;
        index=roct*roct*0.0001;
         index=vec/index;
        if((index>=19.5)&&(index<=22.9) )
        {
            request.setAttribute("result", "Норма");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
return;
        }
        if((index>=23)&&(index<=27.4) )
        {
            request.setAttribute("result", "Избыток массы тела");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            return;
        }
        if((index>=27.5)&&(index<=29.9) )
        {
            request.setAttribute("result", "Ожирение 1 тепени");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            return;
        }
        if((index>=30.0) )
        {
            request.setAttribute("result", "Ожирение второй степени");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            return;
        }
        if((index<=19.5))
        {
            request.setAttribute("result", "Недостаток");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}