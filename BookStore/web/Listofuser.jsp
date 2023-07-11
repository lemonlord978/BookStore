<%-- 
    Document   : Listofuser
    Created on : Mar 17, 2023, 2:27:38 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
    List<User> lst = (List<User>) request.getAttribute("lst");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of User</title>
        <link rel="icon" href="./img/dc_logo.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="productpage/css/navbar.css"/>
        <link rel="stylesheet" href="homepage/css/footer.css"/>
        <link rel="stylesheet" href="MyAccount/MyAccount.css"/>
        <link rel="stylesheet" href="adminpage/css/adminpage.css"/>
        
    </head>
    <body>
        <header>
            <a class="logo" href="home">Dawning Crow</a>
            <ul class="navbar">
                <li><a href="home">Home</a></li>
                <li><a href="">About</a></li>
                <li><a href="">Contact</a></li>
                <li><a href="home">Products</a></li>
                <li>
                    <a href="Admin.jsp">Admin</a>
                </li>

            </ul>
            <div class="main">
                <a><i class="fa-sharp fa-solid fa-magnifying-glass"></i></a>
                <a href="myaccount"><i class="fa-sharp fa-regular fa-user"></i></a>
                <a><i class="fa-sharp fa-solid fa-bag-shopping"></i></a>
                <div><i id="menu-icon" class="fa-solid fa-bars"></i></div>
            </div>
        </header>
        
        <section class="Admin_page_title_container">
            <h1>List of User</h1>
            <hr>  
        </section>
        
        <div class="listOfUser">
            <table class="TableofUser" border="1">
                <thead>
                    <tr>
                        <th scope="col"> UserID </th>
                        <th scope="col"> Name </th>
                        <th scope="col" "> Username </th>
                        <th scope="col"> Password </th>
                        <th scope="col"> Rollno </th>
                        <th scope="col"> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    if(lst == null){
                        out.println("he");
                        }else{
                    if(!lst.isEmpty()){
                    %>
                    <%
                        for(User x: lst) {
                    %>
                    <tr class="box">
                        <td><%= x.getUserID() %></td>
                        <td><%=x.getName()%></td>
                        <td><%=x.getUsername()%></td>
                        <td><%=x.getPassword()%></td>
                        <td><%=x.getRollno()%></td>
                        <td><a href="deleteu?userID=<%= x.getUserID() %>">  Delete </a> </td>
                    </tr>
                    <% } %>  
                    <% } else {%> 
                <h2>No users found</h2>
                <% }
                    } %> 
                </tbody>
            </table>
        </div>
        
        
        <!--footer-->
        <footer>
            <div class="footer">
                <div class="footer_content_1">
                    © DAWNING CROW
                </div>
                <div class="footer_content_2">
                    <div class="payment_icon">
                        <div><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Google_Pay_Logo.svg/512px-Google_Pay_Logo.svg.png?20221017164555" alt="alt"/>
                        </div>
                        <div><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/PayPal.svg/124px-PayPal.svg.png?20210313113929" alt="alt"/>
                        </div>
                        <div><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Visa_Inc._logo.svg/800px-Visa_Inc._logo.svg.png?20170118154621" alt="alt"/>
                        </div>
                        <div><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/MasterCard_1979_logo.svg/1920px-MasterCard_1979_logo.svg.png" alt="alt"/>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
