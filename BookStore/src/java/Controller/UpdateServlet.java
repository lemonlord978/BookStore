package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class UpdateServlet extends HttpServlet {

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

    //doGet ->update.jsp -> doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String xName, xUsername, xPassword, sUserID, sRollno;
        int xUserID, xRollno;
        xName = request.getParameter("name");
        xUsername = request.getParameter("username");
        xPassword = request.getParameter("password");
        sUserID = request.getParameter("id").trim();
        sRollno = request.getParameter("rollno").trim();

        xUserID = Integer.parseInt(sUserID);
        xRollno = Integer.parseInt(sRollno);

        OrderDAO o = new OrderDAO();
        User userNow = (User) request.getSession().getAttribute("currUser");
        List<Order> lsto = o.getOrders(userNow.getUserID());
        request.setAttribute("lsto", lsto);

        UserDAO dao = new UserDAO();
        if (xName.isEmpty()) {
            request.setAttribute("status", "Realname must not be empty");
            request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
            return;
        }

        if (!dao.checkPassword(xPassword)) {
            request.setAttribute("status", "invalid Password");
            request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
            return;
        }

        if (xUsername.equalsIgnoreCase(userNow.getUsername())) {
            User x = new User(xUserID, xName, xUsername, xPassword, xRollno);

            UserDAO u = new UserDAO();
            u.update(xUserID, x);
            User user;
            user = u.getUser(xUsername, xPassword);
            request.setAttribute("user", user);

            request.setAttribute("lsto", lsto);
            request.setAttribute("status", "Informations have been update");
            request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
        } else if (dao.CheckUsername(xUsername)) {
            request.setAttribute("status", "Username has already existed");
            request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
            return;
        }
    }
}
