<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Exam</title>
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

<form action="UpdateExamServlet" method="post">
    <h2>Edit Exam Details</h2>
    <input type="hidden" name="examId" value="${param.examId}">

    <label>Type:</label>
    <input type="text" name="type" value="${param.type}" required>

    <label>Duration:</label>
    <input type="text" name="duration" value="${param.duration}" required>

    <label>Structure:</label>
    <input type="text" name="structure" value="${param.structure}" required>

    <label>User Name:</label>
    <input type="text" name="userName" value="${param.userName}" required>

    <input type="submit" value="Update">
</form>

</body>
</html>
