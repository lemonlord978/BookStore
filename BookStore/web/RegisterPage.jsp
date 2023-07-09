<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/registerStyle.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <h1>Register</h1>
        <form class="register">
            <div>
                <div id="name">
                    <div id="fname" class="text-field">
                        <input name="user" type="text" required>
                        <span></span>
                        <label>First name</label>
                    </div>
                    <div id="lname" class="text-field">
                        <input name="user" type="text" required>
                        <span></span>
                        <label>Last name</label>
                    </div>
                </div>
                <div class="text-field">
                    <input name="user" type="text" required>
                    <span></span>
                    <label>Username</label>
                </div>
                <div class="text-field">
                    <input name="email" type="email" required>
                    <span></span>
                    <label>Your email</label>
                </div>
                <div class="text-field">
                    <input name="tel" type="tel" pattern="(09|03|07|08|05)+([0-9]{8})" required>
                    <span></span>
                    <label>Telephone</label>
                </div>
                <div class="text-field">
                    <input name="pass" type="password" required>
                    <span></span>
                    <label>Password</label>
                </div>
                <div>
                    <input type="submit" value="Sign in">
                </div>
            </div>
        </form>
    </div>
</body>

</html>