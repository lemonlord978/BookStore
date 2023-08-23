package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "LBSearch", urlPatterns = {"/LBSearch"})
public class LBSearch extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int xName = 0;
        //        Lay gia tri input nhap vao
        try{
            xName = Integer.parseInt(request.getParameter("name").trim());
        }catch(NumberFormatException e){
            out.print(e);
        }

//        khai bao ProductDAO va CategoryDAO
        OrderDAO t = new OrderDAO();

        //            In ra list cac san pham lay bang ten
        List<Order> lst = t.getOrders(xName);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("BillMng.jsp").forward(request, response);

    }
}
