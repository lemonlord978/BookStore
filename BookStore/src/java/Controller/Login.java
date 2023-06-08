/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LEMONLORD
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String u = request.getParameter("user");
        String p = request.getParameter("pass");
        String suc = "Success";
        String fail = "Wrong";
        //Get data from XML
        ServletContext sc = getServletContext();
        String user = sc.getInitParameter("username");
        String pass = sc.getInitParameter("password");
        if (user.equals(u) && pass.equals(p)) {
            request.setAttribute("Login", suc);
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
        } else {
            request.setAttribute("Login", fail);
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
        }
    }

}
