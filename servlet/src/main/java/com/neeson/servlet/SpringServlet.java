package com.neeson.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by daile on 2017/8/15.
 */
public class SpringServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();

        ServletContext servletContext = getServletContext();

        servletContext.log("SpringServlet");

        writer.write("hello SpringServlet");

    }

}
