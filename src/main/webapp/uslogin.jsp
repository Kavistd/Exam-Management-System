<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
        }

        .container {
            display: flex;
            width: 800px;
            height: 500px;
            background: #fff;
            box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .signin-signup {
            width: 50%;
            padding: 50px 30px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #fff;
        }

        .signin-signup h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .signin-signup input {
            width: 100%;
            padding: 12px;
            margin-bottom: 10px;
            border-radius: 30px;
            border: 1px solid #ddd;
            outline: none;
        }

        .signin-signup input[type="submit"] {
            background-color: rgb(59, 88, 247); /* Updated Blue color */
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .signin-signup input[type="submit"]:hover {
            background-color: rgb(50, 75, 210); /* Slightly darker blue for hover */
        }

        .signup-panel {
            width: 50%;
            background: linear-gradient(to right, rgb(59, 88, 247), rgb(50, 75, 210)); /* Updated to gradient with the new color */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            color: #fff;
            border-top-right-radius: 10px;
            border-bottom-right-radius: 10px;
        }

        .signup-panel img {
            width: 100px; /* Adjust size as needed */
            margin-bottom: 20px;
        }

        .signup-panel p {
            font-size: 14px;
            margin-bottom: 30px;
        }

        /* Register button styling */
        .signup-panel a {
            display: inline-block;
            padding: 12px 24px;
            margin-top: 10px;
            background-color: #fff;
            color: rgb(59, 88, 247);
            text-decoration: none;
            border-radius: 30px;
            transition: background-color 0.3s ease;
        }

        .signup-panel a:hover {
            background-color: rgba(255, 255, 255, 0.9);
        }

    </style>
</head>
<body>
    <div class="container">
        <!-- Sign In Section -->
        <div class="signin-signup">
            <h2>User Login</h2>
            <form action="UseLoginServlet" method="post">
                <input type="text" name="uid" placeholder="Username" required><br>
                <input type="password" name="pass" placeholder="Password" required><br>
                <input type="submit" name="submit" value="Login">
            </form>
        </div>

        <!-- Sign Up Section -->
        <div class="signup-panel">
            <img src="https://img.icons8.com/ios-filled/100/ffffff/user.png" alt="User Logo"> <!-- User Logo -->
            <p>Enter your credentials to access the user dashboard</p>
            <!-- Register Button -->
            <a href="userinsert.jsp">Register</a> <!-- Link to the registration page -->
        </div>
    </div>
</body>
</html>
