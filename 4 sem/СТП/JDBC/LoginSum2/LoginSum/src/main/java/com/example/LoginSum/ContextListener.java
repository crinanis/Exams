package com.example.LoginSum;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;


@WebListener("Context application listener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String location = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + location;

        PropertyConfigurator.configure(fullPath);
    }
}
