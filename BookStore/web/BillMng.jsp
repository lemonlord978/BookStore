<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.User" %>
<%@page import = "model.Cart" %>
<%@page import = "model.Order" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Management</title>
        <link rel="icon" href="https://cdn.dribbble.com/users/1189548/screenshots/4884012/media/486695de6b18ec97632abfe85851ca52.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="productpage/css/navbar.css"/>
        <link rel="stylesheet" href="homepage/css/footer.css"/>
        <link rel="stylesheet" href="MyAccount/MyAccount.css"/>
        <link rel="stylesheet" href="adminpage/css/adminpage.css"/>
    </head>
    <body>

        <%
            List<Order> lst = (List<Order>) request.getAttribute("lst");
        %> 
        <input type="hidden" id="status"
               value="<%=request.getAttribute("status")%>">
        <header>
            <a class="logo" href="home">BLUEBIRD</a>
            <ul class="navbar">
                <li><a href="home">Home</a></li>
                <li><a href="">About</a></li>
                <li><a href="">Contact</a></li>
                <li><a href="home">Products</a></li>
                <li>
                    <a href="Admin.jsp">Account</a>
                </li>
            </ul>
            <div class="main">
                <a><i class="fa-sharp fa-solid fa-magnifying-glass"></i></a>
                <a href="myaccount"><i class="fa-sharp fa-regular fa-user"></i></a>
                <a href=""><i class="fa-sharp fa-solid fa-bag-shopping"></i></a>
                <div><i id="menu-icon" class="fa-solid fa-bars"></i></div>
            </div>
        </header>


        <section class="MyAccount_page_title_container">
            <h1>Bill Management</h1>
            <hr>
            <div class="SearchBar">
                <form class="searchBox" action="LBSearch" method="POST">
                    <input type="text" name="name" value="" placeholder="Search.."/>
                    <input type="submit" value="Search"> 
                </form>  
            </div>

            <div class="profile_container">
                <c: if test="${not empty status}">
                    <p class="text-center text text-fails">${status}</p>
                    <p></p>
                </c:>

                <div class="order_edit">
                    <div class="order_title">
                        <h2>Orders</h2>
                    </div>
                    <table>
                        <tr>
                            <td class="table_header"> Order ID </td>
                            <td class="table_header"> User ID </td>
                            <td class="table_header"> Price </td>
                            <td class="table_header"> Date</td>
                            <td class="table_header"> View </td>
                            <td class="table_header"> Status </td>
                            <td class="table_header"> Update </td>
                            <td class="table_header"> Delete </td>
                        </tr>
                        <%
                         if(lst!=null){
                         for(Order o: lst) {
                        %>
                        <tr>
                            <td><%= o.getOrderID() %></td>
                            <td><%= o.getUserID() %></td>
                            <td>$<%= o.getPrice() %></td>
                            <td><%= o.getDate() %></td>
                            <td> <a href="OrderDetails?id=<%= o.getOrderID() %>"/> Details </a> </td>
                            <% String status;
                                if(o.getStatus() == 1 ){
                                    status = "Wait";
                                }else if(o.getStatus() == 2){
                                    status = "Process";
                                }else{
                                    status = "Done";
                                }%>
                            <td><%= status %></td> 
                            <td>
                                <form action="UpdateStatusOrder" method="get">
                                    <% if(o.getStatus()!=3){ %>
                                    <a href="UpdateStatusOrder?orderID=<%=o.getOrderID()%>&status=<%=o.getStatus()%>">Update</a>
                                    <% }else{ %>
                                    Done
                                    <%}%>
                                </form>
                            </td> 
                            <td><a href="DeleteOrder?orderID=<%= o.getOrderID() %>">  Delete </a> </td>
                        </tr>  
                        <%      }
                            } %>

                    </table>   
                </div>    
            </div>
            <div>
                <input type="button" value="Go back!" onclick="history.back()">
            </div>
        </section>

        <!--footer-->
        <footer>
            <div class="footer">
                <div class="footer_content_1">
                    © BLUEBIRD
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
        <!--js link-->
        <script type="text/javascript" src="homepage/home.js"></script>

    </body>
</html>
