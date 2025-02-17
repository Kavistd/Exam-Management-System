<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success!</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(135deg, rgba(59, 88, 248, 0.8), rgba(51, 78, 212, 0.8));
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .background-shapes {
            position: absolute;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .circle {
            position: absolute;
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 50%;
            filter: blur(40px);
        }

        .circle.one {
            width: 200px;
            height: 200px;
            top: 10%;
            left: 15%;
        }

        .circle.two {
            width: 300px;
            height: 300px;
            bottom: 5%;
            right: 10%;
        }

        .success-container {
            width: 400px;
            padding: 50px;
            backdrop-filter: blur(12px) saturate(150%);
            background: rgba(255, 255, 255, 0.1);
            border: 1px solid rgba(255, 255, 255, 0.3);
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeIn 1.2s ease-in-out;
        }

        @keyframes fadeIn {
            0% {
                transform: scale(0.9);
                opacity: 0;
            }
            100% {
                transform: scale(1);
                opacity: 1;
            }
        }

        .success-icon {
            width: 80px;
            height: 80px;
            background: linear-gradient(135deg, #3b58f8, #1d3bcf);
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 3rem;
            color: white;
            margin-bottom: 20px;
            animation: bounce 1.5s infinite ease-in-out;
        }

        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }

        h1 {
            font-size: 2.5rem;
            color: #fff;
            margin-bottom: 10px;
        }

        p {
            font-size: 1rem;
            color: rgba(255, 255, 255, 0.8);
            margin-bottom: 30px;
            line-height: 1.5;
        }

        .success-btn {
            padding: 15px 40px;
            background: linear-gradient(135deg, #3b58f8, #1d3bcf);
            color: white;
            border: none;
            border-radius: 30px;
            font-size: 1rem;
            font-weight: 600;
            letter-spacing: 1px;
            text-transform: uppercase;
            cursor: pointer;
            transition: transform 0.3s ease, background-color 0.3s ease;
            text-decoration: none;
        }

        .success-btn:hover {
            transform: scale(1.1);
            background-color: #1d3bcf;
        }

        /* Done button styling */
        .done-btn {
            display: inline-block;
            padding: 15px 30px;
            margin-top: 20px;
            background: white; /* White background */
            color: #3b58f8; /* Blue text */
            border: none;
            border-radius: 30px;
            font-size: 1rem;
            font-weight: 600;
            text-transform: uppercase;
            cursor: pointer;
            text-decoration: none;
            transition: transform 0.3s ease, background-color 0.3s ease, color 0.3s ease;
        }

        .done-btn:hover {
            background-color: rgba(255, 255, 255, 0.9); /* Slightly off-white on hover */
            color: #1d3bcf; /* Darker blue text on hover */
            transform: scale(1.1);
        }

    </style>
</head>
<body>
    <div class="background-shapes">
        <div class="circle one"></div>
        <div class="circle two"></div>
    </div>

    <div class="success-container">
        <div class="success-icon">✔</div>
        <h1>Success!</h1>
        <p>Your operation was successfully completed. You're now ready to explore new features or return to the dashboard.</p>
        
        <!-- Done Button -->
        <a href="admindashboard.jsp" class="done-btn">Done</a> <!-- Link to the desired page -->
    </div>
</body>
</html>
