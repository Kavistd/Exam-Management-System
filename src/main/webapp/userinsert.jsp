<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert User</title>
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
        input[type="number"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff; 
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            font-size: 0.9em;
            margin-top: -10px;
            margin-bottom: 10px;
        }
    </style>
    <script>
        function validateEmail(email) {
            const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$/;
            return emailRegex.test(email);
        }

        function validatePhone(phone) {
            const phoneRegex = /^[0-9]{10}$/; // Adjust the regex as needed for your requirements
            return phoneRegex.test(phone);
        }

        function validateForm() {
            const emailField = document.forms["userForm"]["email"];
            const phoneField = document.forms["userForm"]["phone"];
            const emailError = document.getElementById("emailError");
            const phoneError = document.getElementById("phoneError");

            let valid = true; // Track overall form validity

            // Email validation
            if (!validateEmail(emailField.value)) {
                emailError.textContent = "Invalid email format.";
                valid = false;
            } else {
                emailError.textContent = ""; // Clear any previous error
            }

            // Phone number validation
            if (!validatePhone(phoneField.value)) {
                phoneError.textContent = "Phone number must be 10 digits.";
                valid = false;
            } else {
                phoneError.textContent = ""; // Clear any previous error
            }

            return valid; // Return overall validity
        }
    </script>
</head>
<body>
    <h2>Insert User</h2>
    <form name="userForm" action="UserInsert" method="post" onsubmit="return validateForm()">
        Name <input type="text" name="name" required><br>
        Email <input type="text" name="email" required>
        <span id="emailError" class="error"></span><br>
        Phone Number <input type="text" name="phone" required>
        <span id="phoneError" class="error"></span><br>
        User Name <input type="text" name="userName" required><br>
        Password <input type="password" name="password" required><br>
        
        <input type="submit" name="submit" value="Create User">
    </form>
</body>
</html>