<%-- 
    Document   : LoginPage
    Created on : Jun 8, 2023, 8:19:29 PM
    Author     : LEMONLORD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/LoginStyle.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">

</head>

<body>
    <% String alert = (String) request.getAttribute("Login"); %>
    <div id="wrapper">
        <h1>Login</h1>
        <form action="Login" method="post">
            <div class="text-field">
                <input name="user" type="text" required>
                <span></span>
                <label>Username</label>
            </div>
            <div class="text-field">
                <input name="pass" type="password" required>
                <span></span>
                <label>Password</label>
            </div>
            <% if(alert != null){%>
            <div>
                <% if(alert.equals("Success")){%>
                    <h5><%="Login successfully."%></h5>
                    <% } else { %>   
                    <h5><%="Wrong username or password."%></h5>
                <%}%>                
            </div>
            <% } %>
            <div>
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
</body>

</html>