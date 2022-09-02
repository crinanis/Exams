package com.example.LoginSum;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Action", value = "/action")
public class Action extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(Action.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        int sum = Integer.parseInt(req.getParameter("sum"));
        AccountRepository repository = new AccountRepository();

        if("add".equals(action)){
            int value = Integer.parseInt(req.getParameter("value"));
            value +=sum;
            repository.transaction(value,id);
            LOGGER.info("Add value (sum:" + value + " id: " + id + ")");
        }else if("pay".equals(action)){
            int value = Integer.parseInt(req.getParameter("value"));
            if(sum>=value){
                value = sum-value;
                repository.transaction(value,id);
                LOGGER.info("PAy (sum:" + value + " id: " + id + ")");
            }else{
                LOGGER.info("Can not pay ...");
            }
        }else if("getinfo".equals(action)){
            req.setAttribute("pay",sum);
            req.getRequestDispatcher("Views/info.jsp").forward(req,resp);
        }

        req.getRequestDispatcher("Views/Signin.jsp").forward(req,resp);
    }
}
