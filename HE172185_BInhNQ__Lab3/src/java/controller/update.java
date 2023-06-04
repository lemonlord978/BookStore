/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAL.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Student;

/**
 *
 * @author DELL
 */
public class update extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            StudentDAO std = new StudentDAO();
            
            String id_f= request.getParameter("id");
            int id=covertID(id_f);
            Student s= std.getStudent(id);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"update\" method=\"post\">");
            out.println("    <table>");
            out.println("        <tr>");
            out.println("            <td>Id</td>");
            out.println("            <td><input type=\"text\" name=\"id\" value =\"" + id + "\"/ readonly> </td>");
            out.println("        </tr>");
            out.println("        <tr>");
            out.println("            <td>Name:</td>");
            out.println("            <td><input type=\"text\" name=\"name\" value=\""+ s.getName()+"\"required ></td>");
            out.println("        </tr>");

            out.println("        <tr>");            
            out.println("             <td>Gender:</td>");
            out.println("            <td>");
        if(s.getGender().equals("1")){        
            out.println("                <input type=\"radio\" name=\"gender\" value=\"Male\"checked> Male");
            out.println("                <input type=\"radio\" name=\"gender\" value=\"Female\"> Female");
        }else{    
            out.println("                <input type=\"radio\" name=\"gender\" value=\"Male\"> Male");
            out.println("                <input type=\"radio\" name=\"gender\" value=\"Female\"checked> Female");
        }
            out.println("            </td>");
            out.println("        </tr>");

            out.println("        <tr>");            
            out.println("            <td>DOB:</td>");
            out.println("            <td><input type=\"date\" name=\"dob\"value=\""+ s.getDob()+"\"required ></td>");
            //out.println("<td><input type=\"text\" pattern=\"{0,9}{1,2}/{0,9}{1,2}/{0,9}{4}\" placeholder=\"dd/MM/yyyy\" name=\"dob\"value=\""+ s.getDob()+"\"required></td>");
            out.println("        </tr>");

            out.println("        <tr>");                                
            out.println("            <td><input type=\"submit\" value=\"update\" ></td>");
            out.println("        </tr>");

            out.println("    </table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    public Integer covertID(String a){
        int num=0;
        try{
            num=Integer.parseInt(a);
            return num;
        }catch(NumberFormatException e){
            return null;
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        StudentDAO std = new StudentDAO();
        Student s =new Student();
        String id_r = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date = request.getParameter("dob");
        java.sql.Date sqlDate =DOB(date);
        int id= convertID(id_r);
            s.setId(id);
            s.setName(name);
            s.setGender(gender);
            s.setDob(sqlDate);
            std.updateStudent(s);
            response.sendRedirect("StudentList");
        
        
        
    }
    public java.sql.Date DOB (String d){
        java.util.Date utilDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            utilDate= sdf.parse(d);
            java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());
            return sqlDate;
        }catch(ParseException ex){
            return null;
        }
    }
    public Integer convertID (String a){
        
        int num =0;
        try{
            num=Integer.parseInt(a);
            return num;
        }catch(Exception e){
            return null;
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
