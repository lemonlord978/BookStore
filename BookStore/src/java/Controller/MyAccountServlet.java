package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class MyAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        OrderDAO o = new OrderDAO();
        
        User x = (User) request.getSession().getAttribute("currUser");
        
        List<Order> lsto = o.getOrders(x.getUserID());
        request.setAttribute("lsto", lsto);
        
        
        request.getRequestDispatcher("MyAccount.jsp").forward(request, response);

    }

}
