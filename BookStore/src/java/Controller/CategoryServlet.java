package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class CategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        khai bao ProductDAO va CategoryDAO
        ProductDAO u = new ProductDAO();
        CategoryDAO c = new CategoryDAO();
        //        Lay gia tri input nhap vao
        String cid = request.getParameter("id");
        //            In ra list cac san pham lay bang cid
        List<Product> lst = u.getProductsByCID(cid);
        request.setAttribute("lst", lst);

//            In ra list 5 san pham moi nha
        List<Product> lst5 = u.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

//            in ra list Category (loai san pham)
        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
