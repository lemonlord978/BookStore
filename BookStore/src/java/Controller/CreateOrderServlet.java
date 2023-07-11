package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.text.SimpleDateFormat;
import model.*;
import java.util.*;
import java.sql.Date;
import java.time.LocalDate;
import DAO.*;


@WebServlet(name = "CreateOrder", urlPatterns = {"/buy"})
public class CreateOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ProductDAO u = new ProductDAO();
        CategoryDAO c = new CategoryDAO();

        List<Product> lst = u.getProducts();
        List<Product> lst5 = u.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        request.setAttribute("lst", lst);
        CartDAO cart = new CartDAO();
                
        int xOderID, xUserID, xProductID, xTotalPrice, xQuantity = 0, xPrice = 0, tPrice=0;
        String xName, xImage;
        
        
        xUserID = Integer.parseInt(request.getParameter("userID"));
        OrderDAO o = new OrderDAO();
        Order x = new Order(xUserID, 0);
        o.insert(x);
        x = o.GetLatestOrder();
        xOderID = x.getOrderID();
        OrderDetailsDAO od = new OrderDetailsDAO();
        List<Cart> list = cart.getUserItemses(xUserID);
        for(Cart ca :list){
            xProductID = ca.getProductID();
            xQuantity = ca.getQuantity();
            xPrice = ca.getPrice();
            xTotalPrice = xPrice * xQuantity;
            tPrice += xTotalPrice;

            xName = null;
            xImage = null;
            OrderDetails y = new OrderDetails(xOderID, xProductID, xTotalPrice, xQuantity, xName, xImage, xPrice);
            od.insert(y);
        }
        
        o.addPrice(x, tPrice);
        cart.buy(xUserID);
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
