<%@page import = "model.Product" %>
<%@page import = "model.User" %>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="icon" href="img/dc_logo.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="productpage/css/navbar.css"/>
        <link rel="stylesheet" href="productpage/css/product.css"/>
        <link rel="stylesheet" href="productpage/css/relatedProduct.css"/>
        <link rel="stylesheet" href="homepage/css/lastest.css"/>
        <link rel="stylesheet" href="homepage/css/footer.css"/>
    </head>
    <body>
        <%
            Product x = (Product) request.getAttribute("x");
              List<Product> lst5 = (List<Product>) request.getAttribute("lst5");
                    User user = (User) request.getSession().getAttribute("currUser");

        %>  
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


        <!--body-->
        <section class="product_container">
            <div class="product_inner_container">
                <div class="image_container">
                    <img src="<%= x.getImage() %> " alt="alt"/>
                </div>
                <div class="content_container">
                    <div class="address">                        
                        <a href="index.html">HOME</a>
                        <span>/</span>
                        <a href="home">Products</a>
                    </div>
                    <h1><%= x.getName() %> </h1>
                    <div class="divided"></div>
                    <h2>$<%= x.getPrice() %> </h2>
                    <h3>All prices are in <span>U.S Dollar</span></h3>
                    <form class="payment" action="addtocart" method="POST">
                        <input type="hidden" name="userID" value="<%= user.getUserID() %>" />
                        <input type="hidden" name="productID" value="<%= x.getId() %>" />
                        <input type="hidden" name="price" value="<%= x.getPrice() %>" />
                        <input type="number" name="quantity" value="1"/>
                        <input type="submit" value="Add to Cart   /ᐠ｡ꞈ｡ᐟ\ "> 
                    </form>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consectetur purus quis nisi molestie, sed finibus tortor lacinia. Integer est.</p>

                </div>
        </section>


        <section class="latest" id="latest">
            <div class="latest_container">
                <h1>NEWEST</h1>
                <div class="divided"></div>
                <ul class="latest_product_container">
                    <%
                    for(Product t: lst5) {
                    %>
                    <li class="latest_product_box">
                        <a href="product?id=<%= t.getId() %> ">
                            <img src="<%= t.getImage() %>" alt="alt"/>
                            <div class="latest_product_title">
                                <h4><%= t.getName() %></h4>
                                <h3>$<%= t.getPrice() %></h3>
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
        <script type="text/javascript" src="productpage/product.js"></script>
    </body>
</html>
