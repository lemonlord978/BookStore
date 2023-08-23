/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;

/**
 *
 * @author LEMONLORD
 */
@WebServlet(name = "UpdateStatusOrder", urlPatterns = {"/UpdateStatusOrder"})
public class UpdateStatusOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("status"));
        int orderId = Integer.parseInt(request.getParameter("orderID"));
        
        OrderDAO t = new OrderDAO();
        
        if(status == 1){
            status = 2;
        }else if(status == 2){
            status = 3;
        }
        
        t.updateStatus(orderId, status);
        List<Order> lst = t.getAllOrder();
        
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("BillMng.jsp").forward(request, response);
        
    }
}
