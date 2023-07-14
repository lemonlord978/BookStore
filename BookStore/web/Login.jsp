<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bluebird</title>
        <link rel="icon" href="https://cdn.dribbble.com/users/1189548/screenshots/4884012/media/486695de6b18ec97632abfe85851ca52.jpg">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="loginpage/css/navbar.css"/>
        <link rel="stylesheet" href="loginpage/css/authentication.css"/>
        <link rel="stylesheet" href="loginpage/css/footer.css"/>
        <link rel="stylesheet" href="loginpage/css/Log.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <input class="status" type="hidden" id="status"
               value="<%=request.getAttribute("status")%>">
        
        <!--authentication-->
        <section id="authentication" class="authentication">
            <h1>MY ACCOUNT</h1>
            <c: if test="${not empty status}">
                <p class="text-center text text-fails">${status}</p>
                <p></p>
            </c:>
                
                
            <!--login-->
            <div class="authentication_container">
                <div class="login_container">
                    <h2>LOGIN</h2>
                    <form action="loginS" method="post">
                        <h4>Username</h4>
                        <input class="input" type="text" name="username" value="" />
                        <h4>Password</h4>
                        <input class="input" type="password" name="password" value="" /> 
                        <div>
                            <input type="checkbox" name="remMe" value="remember" checked="checked" />
                            <span>Remember me</span>
                        </div>
                        <input  type="Submit" value="LOG IN"> 
                        <br>
                    </form>  
                </div>

                <!--Register-->
                <div class="register_container">
                    <h2>REGISTER</h2>

                    <form action="register" method="post">
                        <h4>Username</h4>
                        <input class="input" type="text" name="username" required="required" />
                        <h4>Password</h4>
                        <input class="input" type="password" name="password" required="required"/> 
                        <h4>Password Repeat</h4>
                        <input class="input" type="password" name="password_repeat" required="required"/> 
                        <h4>Address</h4>
                        <input class="input" type="text" name="Address" required="required"/>
                        <br>
                        <input type="Submit" value="REGISTER"> 
                    </form>  
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

        <script type="text/javascript" src="loginpage/login.js"></script>
    </body>
</html>

