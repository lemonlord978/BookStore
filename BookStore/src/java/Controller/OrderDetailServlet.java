
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

@WebServlet(name = "OrderDetails", urlPatterns = {"/OrderDetails"})
public class OrderDetailServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String xId = request.getParameter("id");
        
        OrderDetailsDAO u = new OrderDetailsDAO();
        List<OrderDetails> lst = u.getOrderItemses(Integer.parseInt(xId));
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("OrderDetails.jsp").forward(request, response);
//        if(lst == null){
//            out.println("hehe");
//        }else{
//            out.println("ehehe");
//        }
    }

}
