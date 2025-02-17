<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    form {
        width: 300px;
        margin: 50px auto;
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="number"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    /* Updated Button Styles */
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;  /* Same blue color as the image */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3; /* Slightly darker blue on hover */
    }
</style>
</head>
<body>
    <h2 style="text-align: center;">Update User Details</h2>

    <form action="updateUserServlet" method="post">
        <!-- Hidden field to store the ID -->
        <input type="hidden" name="id" value="${user.id}">

        <!-- Form fields populated with existing user data -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="${user.phone}" required>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.userName}" readonly>
        
        <label for="username">Password:</label>
        <input type="text" id="password" name="password" value="${user.password}" required>

        <input type="submit" value="Update User">
    </form>
</body>
</html>
