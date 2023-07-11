<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>

<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon"
        href="https://cdn.dribbble.com/users/1189548/screenshots/4884012/media/486695de6b18ec97632abfe85851ca52.jpg">
    <link rel="stylesheet" href="css/HomePage.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
    <header>
        <div class="navbar">
            <div class="logo"><a href="CreatePage.html">Bluebird</a></div>
            <ul class="links">
                <li><a href="CreatePage.html">Home</a></li>
                <li><a href="Product.html">Product</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <div class="icon">
                <li class="search">
                    <input type="text" id="search-box">
                    <a href="#"><i class="fa-solid fa-magnifying-glass"></i></a>
                </li>
                <li class="cart"><a href="#"><i class="fa-solid fa-cart-shopping"></i></i></i></a></li>
                <li class="user"><a href="#"><i class="fa-solid fa-user"></i></a></li>
            </div>
            <div class="toggle-btn">
                <i class="fa-solid fa-bars"></i>
            </div>
        </div>
        <div class="dropdown-menu">
            <li><a href="CreatePage.html">Home</a></li>
            <li><a href="#">Product</a></li>
            <li><a href="#">Contact</a></li>
        </div>
    </header>

    <section class="desc">
        <div class="desc-text">
            <h5>NEW RE-STOCK</h5>
            <h1>Kafka on the shore</h1>
            <p>Kafka on the Shore (海辺のカフカ, Umibe no Kafuka) is a 2002 novel by Japanese author Haruki Murakami. Its 2005
                English translation was among "The 10 Best Books of 2005" from The New York Times and received the World
                Fantasy Award for 2006.</p>
            <input type="button" value="Buy Now">
        </div>
        <div class="desc-img">
            <img src="photo/kafka.jpg" alt="">
        </div>
    </section>

    <section>
        <div class="content">
            <h1>Best Selling Books</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero ad tempora non distinctio, eaque ratione
                odio!
            </p>
        </div>
        <div class="container">
            <div class="box">
                <img src="photo/kafka.jpg" alt="">
                <h4>Kafka on the shore</h4>
                <h5>$15.00</h5>
                <div class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </div>
            <div class="box">
                <img src="photo/kafka.jpg" alt="">
                <h4>Kafka on the shore</h4>
                <h5>$15.00</h5>
                <div class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </div>
            <div class="box">
                <img src="photo/kafka.jpg" alt="">
                <h4>Kafka on the shore</h4>
                <h5>$15.00</h5>
                <div class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </div>
            <div class="box">
                <img src="photo/kafka.jpg" alt="">
                <h4>Kafka on the shore</h4>
                <h5>$15.00</h5>
                <div class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </div>
            <div class="box">
                <img src="photo/kafka.jpg" alt="">
                <h4>Kafka on the shore</h4>
                <h5>$15.00</h5>
                <div class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
                </div>
            </div>
        </div>
        <div class="btn">
            <input type="button" value="Buy Now"> <a href="#"></a>
        </div>
    </section>

    <section class="about">
        <div class="about-content">
            <h2>About</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut temporibus vel accusamus soluta laboriosam
                minima odio modi tenetur, deserunt magni distinctio ipsam dolor facilis quaerat, necessitatibus
                voluptate nobis dicta officiis.</p>
        </div>
    </section>

</body>
<footer>
    <section class="contact">
        <div class="main-contact">
            <div class="contact-content">
                <li><a href="CreatePage.html">Home</a></li>
                <li><a href="#">Product</a></li>
                <li><a href="#">Contact</a></li>
            </div>
        </div>
        <div class="Copyright">
            <p>Copyright © 2023 Bluebird Store | Powered by Bluebird Store</p>
        </div>
    </section>
</footer>
<script>
    const toggleBtn = document.querySelector('.toggle-btn')
    const toggleBtnIcon = document.querySelector('.toggle-btn i')
    const dropdownMenu = document.querySelector('.dropdown-menu')

    toggleBtn.onclick = function () {
        dropdownMenu.classList.toggle('open')
        const isOpen = dropdownMenu.classList.contains('open')

        toggleBtnIcon.classList = isOpen
            ? 'fa-solid fa-xmark'
            : 'fa-solid fa-bars'
    }
</script>

</html>