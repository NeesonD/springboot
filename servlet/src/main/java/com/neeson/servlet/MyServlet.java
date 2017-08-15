package com.neeson.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daile on 2017/8/15.
 */
@WebServlet(
        name = "myservlet",
        value = "/myservlet"
)
public class MyServlet extends HttpServlet {

    private PrintWriter writer;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        writer = response.getWriter();
        ServletContext servletContext = getServletContext();
        servletContext.log("myServlet  doGet");
        writer.write("hello");
    }
}