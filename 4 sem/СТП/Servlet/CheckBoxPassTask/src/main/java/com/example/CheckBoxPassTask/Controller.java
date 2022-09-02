package com.example.CheckBoxPassTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    private void action(HttpServletRequest req, HttpServletResponse resp) {

        String pass = req.getParameter("pass");
        String role = req.getParameter("role");

        Pattern pattern = Pattern.compile("[0-9]");
        Pattern pattern1 = Pattern.compile("[A-Za-zА-Яа-я]");

        if(!pass.isEmpty() && !role.isEmpty()){
            int len = pass.length();
            if(len>6&&len<12){
                Matcher matcher = pattern.matcher(pass);
                Matcher matcher1 = pattern1.matcher(pass);
                if(matcher.find() && matcher1.find()){
                    try {
                        req.getRequestDispatcher(getPath(req, resp, role)).forward(req,resp);
                    } catch (ServletException e) {
                        getServletContext().log(e.getMessage());
                    } catch (IOException e) {
                        getServletContext().log(e.getMessage());
                    }
                }
            }
        }
    }

    private String getPath(HttpServletRequest req, HttpServletResponse resp, String role) {
        if("user".equals(role)){
            return "Views/User.jsp";
        }
        else if("admin".equals(role)){
            setDateAttr(req);
            Date date = new Date();
            SimpleDateFormat dateFormat  =new SimpleDateFormat("hh:mm:ss");
            Cookie cookie = new Cookie("date",  dateFormat.format(date));
            resp.addCookie(cookie);
            return "Views/Admin.jsp";
        }

        return "Views/SignIn.jsp";
    }

    private void setDateAttr(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("date")){
                req.setAttribute("date",cookies[i].getValue());
                break;
            }
        }

    }
}
