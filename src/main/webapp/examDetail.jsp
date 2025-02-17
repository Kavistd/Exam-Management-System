<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam Details</title>
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

        table {
            margin: auto;
            width: 60%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a, input[type="submit"] {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px 0;
            display: inline-block;
        }

        a:hover, input[type="submit"]:hover {
            background-color: #45a049;
        }

        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Exam Details</h2>

<c:if test="${not empty message}">
    <p style="text-align: center; color: green;">${message}</p>
</c:if>

<c:if test="${not empty examDetails}">
    <table>
        <tr>
            <th>Exam ID</th>
            <th>Type</th>
            <th>Duration</th>
            <th>Structure</th>
            <th>User Name</th>
            <th>Action</th> <!-- Action column for Edit/Delete -->
        </tr>

        <c:forEach var="exam" items="${examDetails}">
            <tr>
                <td>${exam.examId}</td>
                <td>${exam.type}</td>
                <td>${exam.duration}</td>
                <td>${exam.structure}</td>
                <td>${exam.userName}</td>
                <td>
                    <!-- Edit Exam -->
                    <a href="editExam.jsp?examId=${exam.examId}&type=${exam.type}&duration=${exam.duration}&structure=${exam.structure}&userName=${exam.userName}">Update</a>

                    
                    <!-- Delete Exam -->
                    <a href="ExamDetailServlet?action=delete&examId=${exam.examId}"
                       onclick="return confirm('Are you sure you want to delete this exam?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<c:if test="${empty examDetails}">
    <p style="text-align: center;">No exam details found.</p>
</c:if>

<!-- Insert New Exam Button -->
<div class="center">
    <form action="insertExam.jsp" method="get">
        <input type="submit" value="Insert New Exam">
    </form>
</div>

</body>
</html>
