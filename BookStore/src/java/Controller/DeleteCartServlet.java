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
import model.*;
import DAO.*;
import java.util.List;

/**
 *
 * @author LEMONLORD
 */
@WebServlet(name = "DeleteCartServlet", urlPatterns = {"/deleteCart"})
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("id");
        int xid = Integer.parseInt(sid);
        User userNow = (User) request.getSession().getAttribute("currUser");
        int UserID = userNow.getUserID();
        CartDAO p = new CartDAO();
        Cart x = p.getCartItem(UserID, xid);
        if (x == null) {
            pr.println("<h2>Product is not found</h2>");
        } else {
            p.delete(sid);
            List<Cart> lst = (List<Cart>) p.getCartItem(UserID, xid);
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("id");
        int xid = Integer.parseInt(sid);
        User userNow = (User) request.getSession().getAttribute("currUser");
        int UserID = userNow.getUserID();
        CartDAO p = new CartDAO();
        Cart x = p.getCartItem(UserID, xid);
        if (x == null) {
            pr.println("<h2>Product is not found</h2>");
        } else {
            p.delete(sid);
            List<Cart> lst = (List<Cart>) p.getCartItem(UserID, xid);
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }

    }
}
