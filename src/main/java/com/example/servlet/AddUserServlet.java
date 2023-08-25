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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    public void init (ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            User user = new User(firstName,lastName);
            Warehouse.getInstance().addUser(user);
            request.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
        }
        catch(Exception ex){
            getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
        }
    }
}
