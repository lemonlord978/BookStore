package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import DAO.*;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

//        Goi UserDAO
        UserDAO dao = new UserDAO();

//        Khai bao cac bien 
        String xusername, xpassword;
        String xpassword_check;

//        Lay gia tri input nhap vao
        xusername = request.getParameter("username");
        xpassword = request.getParameter("password");
        xpassword_check = request.getParameter("password_repeat");

        RequestDispatcher dispatcher = null;

//        check Username nhap vao co valid khong
        if (dao.CheckUsername(xusername)) {
            request.setAttribute("status", "Username has already existed");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
            return;
        }

//        check Password nhap vao co valid khong
        if (!dao.checkPassword(xpassword)) {
            request.setAttribute("status", "invalid Password");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
            return;
        }

//        check password repeat nhap vao co trung voi passowrd khong
        if (!xpassword_check.equals(xpassword)) {
            request.setAttribute("status", "Password Repeat has to be similar to Password");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
            return;
        }

//      Tao mot user moi        
        User user = new User();
        user.setUsername(xusername);
        user.setPassword(xpassword);
        dao.UserRegister(user);
        request.setAttribute("status", "successfully");
        dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
    }
}
