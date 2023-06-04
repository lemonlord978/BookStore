<%-- 
    Document   : add
    Created on : 01-06-2023, 12:35:02
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required ></td>
                </tr>

                <tr> 
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="Male" checked> Male
                        <input type="radio" name="gender" value="Female"> Female
                    </td>
                </tr>

                <tr>
                    <td>DOB:</td>
                    <td><input type="date" name="dob" required></td>
                    <!--<td><input type="text" pattern="{0,9}{1,2}/{0,9}{1,2}/{0,9}{4}" placeholder="dd/MM/yyyy" name="dob"></td> -->
                </tr>

                <tr>
                    <td><input type="submit" value="create" ></td>
                </tr>

            </table>
        </form>
    </body>
</html>
