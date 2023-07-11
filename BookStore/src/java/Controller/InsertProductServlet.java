/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import DAO.*;
/**
 *
 * @author admin
 */
@WebServlet(name = "InsertProductServlet", urlPatterns = {"/insertPr"})
public class InsertProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        PrintWriter pr = response.getWriter();
        String xname, ximage, sprice,scateID, xAuthor;
        
        xname = request.getParameter("name");
        ximage = request.getParameter("image");
        sprice = request.getParameter("price");
        scateID = request.getParameter("cateID");
        xAuthor = request.getParameter("Author");
        
        ProductDAO p = new ProductDAO(); 
        Product x = new Product();
        x.setName(xname);
        x.setImage(ximage);
        x.setPrice(Integer.parseInt(sprice));
        x.setCateID(Integer.parseInt(scateID));
        x.setAuthor(xAuthor);
        
        p.InsertPr(x);
        request.setAttribute("status", "successfully");
        dispatcher = request.getRequestDispatcher("InsertProduct.jsp");
        dispatcher.forward(request, response);
        
    }
}
