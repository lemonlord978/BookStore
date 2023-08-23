package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "UpdateUser", urlPatterns = {"/updateUser"})
public class UpdateUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        PrintWriter pr = response.getWriter();
        String xid = request.getParameter("userID");
        UserDAO p = new UserDAO();
        User u = p.getUserbyId(xid);
        if (u == null) {
            pr.println("<h2>User is not found</h2>");
        } else {
            request.setAttribute("user", u);
            dispatcher = request.getRequestDispatcher("EditUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    //doGet ->update.jsp -> doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xName, xUsername, xPassword, sUserID, sRollno, xAddress;
        int xUserID, xRollno;
        xName = request.getParameter("name");
        xUsername = request.getParameter("username");
        xPassword = request.getParameter("password");
        sUserID = request.getParameter("id").trim();
        sRollno = request.getParameter("rollno").trim();
        xAddress = request.getParameter("Address").trim();

        xUserID = Integer.parseInt(sUserID);
        xRollno = Integer.parseInt(sRollno);

        
        UserDAO dao = new UserDAO();
        User userNow = dao.getUserbyId(sUserID);

        if (xName.isEmpty()) {
            request.setAttribute("status", "Realname must not be empty");
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
            return;
        }

        if (!dao.checkPassword(xPassword)) {
            request.setAttribute("status", "invalid Password");
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
            return;
        }

        if (xUsername.equalsIgnoreCase(userNow.getUsername())) {
            User x = new User(xUserID, xName, xUsername, xPassword, xRollno, xAddress);
            dao.update(xUserID, x);
            User user;
            user = dao.getUserbyId(sUserID);
            request.setAttribute("user", user);
            request.setAttribute("status", "Informations have been update");
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        } else if (!xUsername.equalsIgnoreCase(userNow.getUsername())) {
            User x = new User(xUserID, xName, xUsername, xPassword, xRollno, xAddress);
            dao.update(xUserID, x);
            User user;
            user = dao.getUserbyId(sUserID);
            request.setAttribute("user", user);
            request.setAttribute("status", "Informations have been update");
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
            
        } else if (dao.CheckUsername(xUsername)) {
            request.setAttribute("status", "Username has already existed");
            request.getRequestDispatcher("EditUser.jsp").forward(request, response);
        }
    }
}
