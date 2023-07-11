<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Product" %>
<%@page import = "model.Category" %>
<%@page import = "model.User" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<Product> lst = (List<Product>) request.getAttribute("lst");
  List<Product> lst5 = (List<Product>) request.getAttribute("lst5");
  List<Category> lstc = (List<Category>) request.getAttribute("lstc");
  User user = (User) request.getSession().getAttribute("currUser");
%>   


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="icon" href="img/dc_logo.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="homepage/css/footer.css"/>
        <link rel="stylesheet" href="homepage/css/home.css"/>
        <link rel="stylesheet" href="homepage/css/lastest.css"/>
        <link rel="stylesheet" href="./homepage/css/shop_container.css"/>
        <link rel="stylesheet" href="homepage/css/shop_page_title_container.css"/>
    </head>
    <body>
        <!-- Header -->
        <header>
            <a class="logo" href="home">Dawning Crow</a>
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
                <a id="search_icon"><i class="fa-sharp fa-solid fa-magnifying-glass"></i></a>
                <a href="myaccount"><i class="fa-sharp fa-regular fa-user"></i></a>
                <a href="cart"><i class="fa-sharp fa-solid fa-bag-shopping"></i></a>
                <div><i id="menu-icon" class="fa-solid fa-bars"></i></div>
            </div>
            <div class="search_container">
                <form action="search" method="POST">
                    <input type="text" name="name" value="" placeholder="Search.."/>
                    <p></p>
                    <input type="submit" value="Search"> 
                </form>  
            </div>
        </header>

        <!--Body-->
        <!--shop_page_title_container-->
        <section class="shop_page_title_container">
            <div class="page_title_inner_container">
                <div class="title_contianer">
                    <h1>Products</h1>
                    <div class="optional">
                        <div class="address">                        
                            <a href="index.html">HOME</a>
                            <span>/</span>
                            <span>PRODUCTS</span>
                        </div>
                        <div>
                            <div class="dropdown">
                                <button class="nut_dropdown">--Sort--</button>
                                <div class="noidung_dropdown">
                                    <a href="sort?value=1">Sort by price: low to high</a>
                                    <a href="sort?value=2">Sort by price: high to low</a>
                                    <a href="sort?value=3">Sort by latest</a>
                                    <a href="home">Sort by newest</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="filter_container">
                        <div class="filter">
                            <ul>
                                <%
                                    for(Category x: lstc) {
                                %>
                                <li><a href="category?id=<%= x.getId() %>"><%= x.getName() %> </a></li>
                                    <% } %> 
                                <li><a href="home">All</a></li>
                            </ul>
                        </div>

                        <div>
                            <i id="filter-icon" class="fa-sharp fa-solid fa-list"></i>   
                            Filter
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--shop start-->
        <section class="shop" id="shop">
            <div class="shop_container">
                <%
                    if(!lst.isEmpty()){
                %>
                <%
                    for(Product x: lst) {
                %>
                <div class="box">
                    <a href="product?id=<%= x.getId() %> ">
                        <img src="<%= x.getImage() %> "/>
                        <h4><%= x.getName() %> </h4>
                        <h5>$<%= x.getPrice() %></h5>
                    </a>
                </div>
                <% } %>  
                <% } else {%> 
                <h2>No products found</h2>
                <% } %>    
            </div>
        </section>

        <section class="latest" id="latest">
            <div class="latest_container">
                <h1>NEWEST</h1>
                <div class="divided"></div>
                <ul class="latest_product_container">
                    <%
                    for(Product x: lst5) {
                    %>
                    <li class="latest_product_box">
                        <a href="product?id=<%= x.getId() %> ">
                            <img src="<%= x.getImage() %>" alt="alt"/>
                            <div class="latest_product_title">
                                <h4><%= x.getName() %></h4>
                                <h3>$<%= x.getPrice() %></h3>
                            </div>
                        </a>
                    </li>
                    <% } %>  
                </ul>
            </div>
        </section>

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

        <!--js link-->
        <script type="text/javascript" src="homepage/home.js"></script>
    </body>
</html>

