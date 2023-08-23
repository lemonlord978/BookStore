
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;
import DAO.*;

@WebServlet(name = "ListofProduct", urlPatterns = {"/ListofProduct"})
public class ListofProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ProductDAO u = new ProductDAO();
        List<Product> lst = u.getProducts();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("Listofproduct.jsp").forward(request, response);
    }

}
