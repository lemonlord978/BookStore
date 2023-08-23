<%-- 
    Document   : Admin
    Created on : Mar 15, 2023, 6:59:08 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="icon" href="https://cdn.dribbble.com/users/1189548/screenshots/4884012/media/486695de6b18ec97632abfe85851ca52.jpg">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="productpage/css/navbar.css"/>
        <link rel="stylesheet" href="homepage/css/footer.css"/>
        <link rel="stylesheet" href="MyAccount/MyAccount.css"/>
        <link rel="stylesheet" href="adminpage/css/adminpage.css"/>
    </head>
    <body>
        
        <header>
            <a class="logo" href="home">BLUEBIRD</a>
            <ul class="navbar">
                <li><a href="home">Home</a></li>
                <li><a href="">About</a></li>
                <li><a href="">Contact</a></li>
                <li><a href="ListofProduct">Products</a></li>
                <li>
                    <a href="Admin.jsp">Account</a>
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
            <h1>Welcome, Admin</h1>
            <hr>

        </section>
        
        <div class="AdOP ">
            <button>
                <a href="ListofProduct">List of Product</a>
            </button>
            <button>
                <a href="Listofuser">List of User</a>
            </button>
            <button>
                <a href="magageorder">Bill Management</a>
            </button>
            
        </div>


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
    </body>
</html>
