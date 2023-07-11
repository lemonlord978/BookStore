package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.List;
import model.*;
import DAO.*;

@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deletePr"})
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("id");
        ProductDAO p = new ProductDAO();
        Product x = p.getProduct(sid);
        if (x == null) {
            pr.println("<h2>Product is not found</h2>");
        } else {
            p.delete(sid);
            List<Product> lst = p.getProducts();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("Listofproduct.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String sid = request.getParameter("id");
        ProductDAO p = new ProductDAO();
        Product x = p.getProduct(sid);
        if (x == null) {
            pr.println("<h2>Product is not found</h2>");
        } else {
            p.delete(sid);
            List<Product> lst = p.getProducts();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("Listofproduct.jsp").forward(request, response);
        }

    }
}
