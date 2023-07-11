package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ProductDAO u = new ProductDAO();
        CategoryDAO c = new CategoryDAO();

        List<Product> lst = u.getProducts();
        List<Product> lst5 = u.getNewestProductsBy5();
        request.setAttribute("lst5", lst5);

        List<Category> lstc = c.getCategorys();
        request.setAttribute("lstc", lstc);

        request.setAttribute("lst", lst);
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
