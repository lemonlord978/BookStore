/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import DAO.*;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateAd", urlPatterns = {"/registerA"})
public class CreateAdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        UserDAO dao = new UserDAO();
        String xusername, xpassword;
        String xpassword_check;

        xusername = request.getParameter("username");
        xpassword = request.getParameter("password");
        xpassword_check = request.getParameter("password_repeat");

        RequestDispatcher dispatcher = null;

        if (dao.CheckUsername(xusername)) {
            request.setAttribute("status", "Username has already existed");
            dispatcher = request.getRequestDispatcher("CreateAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!dao.checkPassword(xpassword)) {
            request.setAttribute("status", "invalid Password");
            dispatcher = request.getRequestDispatcher("CreateAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!xpassword_check.equals(xpassword)) {
            request.setAttribute("status", "Password Repeat has to be similar to Password");
            dispatcher = request.getRequestDispatcher("CreateAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(xusername);
        user.setPassword(xpassword);
        dao.createAd(user);
        request.setAttribute("status", "successfully");
        dispatcher = request.getRequestDispatcher("CreateAdmin.jsp");
        dispatcher.forward(request, response);
    }
}
