package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //        Lay gia tri input nhap vao
        String xId = request.getParameter("id");

        //        khai bao ProductDAO va CategoryDAO
        Product x = null;
        ProductDAO t = new ProductDAO();

        //            In ra list 5 san pham moi nha
        List<Product> lst5 = t.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

        //            In ra san pham thông qua id cua chinh no
        x = t.getProduct(xId);
        request.setAttribute("x", x);
        request.getRequestDispatcher("product.jsp").forward(request, response);

    }

}
