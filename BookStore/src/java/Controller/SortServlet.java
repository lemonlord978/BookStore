package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class SortServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //        khai bao ProductDAO va CategoryDAO
        ProductDAO u = new ProductDAO();
        CategoryDAO c = new CategoryDAO();

        //        Lay gia tri input nhap vao
        String value = request.getParameter("value");

        if (value.equalsIgnoreCase("3")) {
            //            In ra list cac san pham cu nhat
            List<Product> lst = u.getLastestProducts();
            request.setAttribute("lst", lst);
        } else if (value.equalsIgnoreCase("1")) {
            //            In ra list cac san pham theo gia tu thap den cao
            List<Product> lst = u.getProductsLowToHigh();
            request.setAttribute("lst", lst);
        } else if (value.equalsIgnoreCase("2")) {
            //            In ra list cac san pham theo gia tu cao xuong thap
            List<Product> lst = u.getProductsHighToLow();
            request.setAttribute("lst", lst);
        } else {
            //            In ra list cac san pham theo thu tu mac dinh
            List<Product> lst = u.getProducts();
            request.setAttribute("lst", lst);
        }
//            In ra list 5 san pham moi nha
        List<Product> lst5 = u.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);
//            in ra list Category (loai san pham)
        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
