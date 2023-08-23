package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import DAO.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "LPSearch", urlPatterns = {"/LPSearch"})
public class LPSearch extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //        Lay gia tri input nhap vao
        String xName = request.getParameter("name").trim();

//        khai bao ProductDAO va CategoryDAO
        ProductDAO t = new ProductDAO();

        //            In ra list cac san pham lay bang ten
        List<Product> lst = t.getProductsByName(xName);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("Listofproduct.jsp").forward(request, response);

    }
}
