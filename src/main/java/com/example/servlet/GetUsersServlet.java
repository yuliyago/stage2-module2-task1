package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/users")
public class GetUsersServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Warehouse obj = Warehouse.getInstance();
            request.setAttribute("users",obj.getUsers());
            request.getRequestDispatcher("/jsp/users.jsp").forward(request,response);
        }
}
