<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.User" %>
<%@page import = "model.Order" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account</title>
        <link rel="icon" href="https://cdn.dribbble.com/users/1189548/screenshots/4884012/media/486695de6b18ec97632abfe85851ca52.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="productpage/css/navbar.css"/>
        <link rel="stylesheet" href="homepage/css/footer.css"/>
        <link rel="stylesheet" href="MyAccount/MyAccount.css"/>
    </head>
    <body>

        <%
            User x = (User) request.getSession().getAttribute("currUser");
            List<Order> lsto = (List<Order>) request.getAttribute("lsto");
            User user = (User) request.getSession().getAttribute("currUser");
            int i=0;
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
                    <% if (user.getRollno() == 1) { %>
                    <a href="Admin.jsp">Admin</a>
                    <% } %>
                </li>
            </ul>
            <div class="main">
                <a href=""><i class="fa-sharp fa-regular fa-user"></i></a>
                <a href="cart"><i class="fa-sharp fa-solid fa-bag-shopping"></i></a>
                <div><i id="menu-icon" class="fa-solid fa-bars"></i></div>
            </div>
        </header>


        <section class="MyAccount_page_title_container">
            <h1>My Account</h1>
            <hr>
            <div class="profile_container">
                <c: if test="${not empty status}">
                    <p class="text-center text text-fails">${status}</p>
                    <p></p>
                </c:>

                <div class="profile_edit">
                    <div class="profile_title">
                        <h2 >Account detail</h2>
                    </div>
                    <form action="update" method="POST">
                        <div class="update_name">
                            <div>
                                <p>Real name</p>
                                <input type="text" name="name" value="<%= x.getName() %>"/> 
                            </div>
                            <div>
                                <p>Username</p>
                                <input type="text" name="username" value="<%= x.getUsername() %>"/> 
                            </div>
                        </div> 
                        <div class="update_name">
                            <div>
                                <p>Password</p>
                                <input type="password" name="password" value="<%= x.getPassword() %>"/> 
                            </div>
                            <div>
                                <p>Address</p>
                                <input type="text" name="Address" value="<%= x.getAddress() %> "/> 
                            </div>
                        </div>
                        <input type="hidden" name="rollno" value="<%= x.getRollno() %> ">
                        <p><input type="submit" value="Update"> 
                            <a href="logout"> Logout </a>

                    </form> 
                </div>
                <div class="order_edit">
                    <div class="order_title">
                        <h2>Order</h2>
                    </div>
                    <table>
                        <tr>
                            <td class="table_header"> No </td>
                            <td class="table_header"> Date </td>
                            <td class="table_header"> Price </td>
                            <td class="table_header">  </td>

                        </tr>
                        <%
                         for(Order o: lsto) {
                            i++;
                        %>
                        <tr>
                            <td><%=i%></td>
                            <td><%= o.getDate() %></td>
                            <td>$<%= o.getPrice() %></td>
                            <td> <a href="OrderDetails?id=<%= o.getOrderID() %>"/> Details </a> </td>
                            
                        </tr>
                        
                        <% } %> 
                    </table>   
                </div>    
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
