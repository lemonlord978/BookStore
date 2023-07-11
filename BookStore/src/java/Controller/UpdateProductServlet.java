/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
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

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updatePr"})
public class UpdateProductServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        PrintWriter pr = response.getWriter();
        String xid = request.getParameter("id");
        ProductDAO p = new ProductDAO();
        Product pro = p.getProduct(xid);
        if (pro == null) {
            pr.println("<h2>Product is not found</h2>");
        } else {
            request.setAttribute("x", pro);
            dispatcher = request.getRequestDispatcher("editProduct.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        PrintWriter pr = response.getWriter();
        int xprice, xcateID, xid;
        String xname, ximage, sid, sprice, scateID;
        sid = request.getParameter("id");
        xname = request.getParameter("name");
        boolean isOk = true;

        xid = Integer.parseInt(sid.trim());

        if (xname == null || xname.trim().length() == 0 || xname.trim().equals("Invalid name!")) {
            xname = "Invalid name!";
            isOk = false;
        }

        ximage = request.getParameter("image");
        if (ximage == null || ximage.trim().length() == 0 || ximage.trim().equals("Invalid!")) {
            ximage = "Invalid!";
        }

        sprice = request.getParameter("price");
        if (sprice == null || sprice.trim().length() == 0) {
            xprice = 0;
        } else {
            xprice = Integer.parseInt(sprice.trim());
        }

        scateID = request.getParameter("cateID");
        if (scateID == null || scateID.trim().length() == 0) {
            xcateID = 0;
        } else {
            xcateID = Integer.parseInt(scateID.trim());
        }
        Product x = new Product(xid, xname, ximage, xprice, xcateID);
        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("editProduct.jsp").forward(request, response);
            return;
        }
        ProductDAO p = new ProductDAO();
        p.update(xid, x);
        List<Product> lst = p.getProducts();
        request.setAttribute("lst", lst);
        request.setAttribute("status", "successfully");
        dispatcher = request.getRequestDispatcher("Listofproduct.jsp");
        dispatcher.forward(request, response);

    }

}
