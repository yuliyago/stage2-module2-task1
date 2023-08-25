package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            String firstName = request.getParameter("firstName");
            System.out.println("Получили имя " +firstName);
            String lastName = request.getParameter("lastName");
            System.out.println("Получили фамилию "+lastName);
            User user = new User(firstName,lastName);
            System.out.println("Создали объект юзер");
            Warehouse.getInstance().addUser(user);
            System.out.println("Сохранили объект юзер в ворхауз "+Warehouse.getInstance().getUsers().size());
            request.setAttribute("user",user);
//            response.sendRedirect(request.getContextPath()+"/add");
            getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
        }
        catch(Exception ex){
            getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
        }
    }
}
