/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import model.*;
import DAO.*;

@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/deleteu"})
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("userID");
        UserDAO p = new UserDAO();
        User x = p.getUserbyId(sid);
        if (x == null) {
            pr.println("<h2>User is not found</h2>");
        } else {
            p.delete(sid);
            List<User> lst = p.getAllUser();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("Listofuser.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("userID");
        UserDAO p = new UserDAO();
        User x = p.getUserbyId(sid);
        if (x == null) {
            pr.println("<h2>User is not found</h2>");
        } else {
            p.delete(sid);
            List<User> lst = p.getAllUser();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("Listofproduct.jsp").forward(request, response);
        }

    }
}
