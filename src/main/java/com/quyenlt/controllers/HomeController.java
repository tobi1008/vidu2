package com.quyenlt.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "quyen";

        req.setAttribute("name", name); 
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp"); 
        rd.forward(req, resp); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("ten");
        String lstname = req.getParameter("holot");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("Hello " + lstname + " " + name);
        out.close();
    }
}