/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import java.util.List;

/**
 *
 * @author LEMONLORD
 */
public class DeleteOrder extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderID = request.getParameter("orderID");
        int xOrder = Integer.parseInt(orderID);
        OrderDAO od = new OrderDAO();
        od.DeleteOrder(xOrder);
        List<Order> lst = od.getAllOrder();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("BillMng.jsp").forward(request, response);
    }
}
