package com.example.LoginSum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignIn",value = "/signin")
public class SignIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountRepository repository = new AccountRepository();
        List<Account> accounts = repository.getAll();
        String login = req.getParameter("login");

        for(Account a:accounts){
            if(a.getLogin().equals(login)){
                req.setAttribute("id",a.getId());
                req.setAttribute("sum",a.getSum());
                req.getRequestDispatcher("Views/Work.jsp").forward(req,resp);
            }
        }

        req.getRequestDispatcher("Views/Error.jsp").forward(req,resp);
    }
}
