<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
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
            background-color: #3b58f8; /* Blue color for the login button */
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .signin-signup input[type="submit"]:hover {
            background-color: #334ed4; /* Slightly darker blue for hover */
        }

        .signup-panel {
            width: 50%;
            background: linear-gradient(to right, #3b58f8, #334ed4); /* Updated to blue gradient */
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

        .signup-panel h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }

        .signup-panel p {
            font-size: 14px;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Sign In Section -->
        <div class="signin-signup">
            <h2>Admin Login</h2>
            <form action="adminLoginServlet" method="post">
                <input type="text" name="uid" placeholder="Username" required><br>
                <input type="password" name="pass" placeholder="Password" required><br>
                <input type="submit" name="submit" value="Login">
            </form>
        </div>

        <!-- Sign Up Section -->
        <div class="signup-panel">
           <img src="https://img.icons8.com/ios-filled/100/ffffff/admin-settings-male.png" alt="Admin Logo"> <!-- New Admin Logo -->
            <p>Enter your credentials to access the admin dashboard</p>
        </div>
    </div>
</body>
</html>
