/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;
import DAO.*;

/**
 *
 * @author admin
 */
@WebServlet(name = "Listofuser", urlPatterns = {"/Listofuser"})
public class Listofuser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        UserDAO u = new UserDAO();
        List<User> lst = u.getAllUser();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("Listofuser.jsp").forward(request, response);
//        if(lst == null){
//            out.println("he");
//        }else{
//            out.println("eehe");
//        }
        
    
    }
}
