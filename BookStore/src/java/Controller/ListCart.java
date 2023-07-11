
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

@WebServlet(name = "ListCart", urlPatterns = {"/cart"})
public class ListCart extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int xUserID;
         User x = (User) request.getSession().getAttribute("currUser");
        CartDAO u = new CartDAO();
        List<Cart> lst = u.getUserItemses(x.getUserID());
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
//        if(lst == null){
//            out.println("hehe");
//        }else{
//            out.println("ehehe");
//        }
    }

}
