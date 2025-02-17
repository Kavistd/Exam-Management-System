<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Unsuccess!</title>
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
            background: linear-gradient(135deg, rgba(255, 77, 77, 0.8), rgba(204, 51, 51, 0.8));
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
            width: 180px;
            height: 180px;
            top: 15%;
            left: 20%;
        }

        .circle.two {
            width: 280px;
            height: 280px;
            bottom: 10%;
            right: 15%;
        }

        .unsuccess-container {
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

        .unsuccess-icon {
            width: 80px;
            height: 80px;
            background: linear-gradient(135deg, #ff4d4d, #cc3333);
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 3rem;
            color: white;
            margin-bottom: 20px;
            animation: shake 1.5s infinite ease-in-out;
        }

        @keyframes shake {
            0%, 100% {
                transform: translateX(0);
            }
            25% {
                transform: translateX(-5px);
            }
            75% {
                transform: translateX(5px);
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

        .unsuccess-btn {
            padding: 15px 40px;
            background: linear-gradient(135deg, #ff4d4d, #cc3333);
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

        .unsuccess-btn:hover {
            transform: scale(1.1);
            background-color: #cc3333;
        }

        /* Try Again button styling */
        .try-again-btn {
            display: inline-block;
            padding: 15px 30px;
            margin-top: 20px;
            background: white; /* White background */
            color: #cc3333; /* Dark red text */
            border: none;
            border-radius: 30px;
            font-size: 1rem;
            font-weight: 600;
            text-transform: uppercase;
            cursor: pointer;
            text-decoration: none;
            transition: transform 0.3s ease, background-color 0.3s ease, color 0.3s ease;
        }

        .try-again-btn:hover {
            background-color: rgba(255, 255, 255, 0.9); /* Slightly off-white on hover */
            color: #a02929; /* Darker red text on hover */
            transform: scale(1.1);
        }

    </style>
</head>
<body>
    <div class="background-shapes">
        <div class="circle one"></div>
        <div class="circle two"></div>
    </div>

    <div class="unsuccess-container">
        <div class="unsuccess-icon">❌</div>
        <h1>Unsuccessful!</h1>
        <p>Something went wrong. Please try again or contact support for help.</p>
        
        <!-- Try Again Button -->
        <a href="admindashboard.jsp" class="try-again-btn">Try Again</a> <!-- Link to the desired page -->
    </div>
</body>
</html>
