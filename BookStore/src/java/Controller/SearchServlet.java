package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //        Lay gia tri input nhap vao
        String xName = request.getParameter("name").trim();

//        khai bao ProductDAO va CategoryDAO
        ProductDAO t = new ProductDAO();
        CategoryDAO c = new CategoryDAO();

        //            In ra list cac san pham lay bang ten
        List<Product> lst = t.getProductsByName(xName);
        request.setAttribute("lst", lst);

//            In ra list 5 san pham moi nha
        List<Product> lst5 = t.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

//            in ra list Category (loai san pham)
        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
