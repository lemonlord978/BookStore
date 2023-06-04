<%-- 
    Document   : list
    Created on : 01-06-2023, 10:27:09
    Author     : DELL
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1> Student List </h1>
    <br/>
        <%
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
        %>
    </head>
    <body>
        
        <% if(students!= null){%>
        <table border="1">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    Name
                </td>
                <td>
                    Gender
                </td>
                <td>
                    DOB
                </td>
            </tr>
        <% for (Student s : students) {
            
            String gender;
            if(s.getGender().equals("1")){ 
                gender="Male";
            }else{
                gender="Female";
        }
        %>
                <tr>
                    <td>
                        <%=s.getId() %>
                    </td> 
                    <td>
                        <%=s.getName()%>
                    </td>
                    <td>
                        <%=gender%>
                    </td>                
                    <td>
                        <%=s.getDob()%>
                    </td>
                    <td>   
                    <a href="update?id=<%=s.getId()%> ">Update</a>
                    <a href="delete?id=<%=s.getId()%> ">Delete</a>
                    </td>
                    
                </tr>
        <%}%>
        </table>
        <%}%>
        <input type="button" value="Create" onclick="window.location.href='add.jsp'">
    </body>
</html>
