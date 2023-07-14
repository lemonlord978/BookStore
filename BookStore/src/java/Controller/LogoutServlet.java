package controller;

import model.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LogoutServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter pr = response.getWriter();
    
     request.getSession().setAttribute("currUser", null);
     pr.print("You have been loggod out!");  
     request.getRequestDispatcher("Login.jsp").include(request, response);  
  }

}
