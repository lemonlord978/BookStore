package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

//        Khai bao ProductDAO va CategoryDAO
        ProductDAO u = new ProductDAO();
        CategoryDAO c = new CategoryDAO();

        //            In ra list cac san pham
        List<Product> lst = u.getProducts();
        request.setAttribute("lst", lst);

        //            In ra list 5 san pham moi nha
        List<Product> lst5 = u.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

        //            in ra list Category (loai san pham)
        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        //Khai bao nhung input duoc nhap vao
        int xUserID, xProductID, xTotalPrice, xQuantity = 0, xPrice = 0;
        String xName, xImage;

        //lay gia tri o input
        xUserID = Integer.parseInt(request.getParameter("userID"));
        xProductID = Integer.parseInt(request.getParameter("productID"));
        xQuantity = Integer.parseInt(request.getParameter("quantity"));
        xPrice = Integer.parseInt(request.getParameter("price"));
        xTotalPrice = xPrice * xQuantity;

        xName = null;
        xImage = null;
        
        //Khai bao CartDAO
        CartDAO ca = new CartDAO();
        
        //Lay cartItem có userId và product id
        Cart x = ca.getCartItem(xUserID, xProductID);
        //Neu item do da có trong cart thi cong them so luong vao price
        if (x != null) {
            ca.addQuan(x, xQuantity, xTotalPrice);
        } else {
//            Neu khong thi insert item moi vao cart
            x = new Cart(xUserID, xProductID, xTotalPrice, xQuantity, xName, xImage, xPrice);
            ca.insert(x);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
