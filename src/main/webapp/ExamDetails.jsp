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

        tr:nth-child(even) {background-color: #f2f2f2;}
    </style>
</head>
<body>
    <h2>Exam Details</h2><!-- user side -->

    <c:if test="${not empty examDetails}">
        <table>
            <tr>
                <th>Exam ID</th>
                <th>Type</th>
                <th>Duration</th>
                <th>Structure</th>
                <th>User Name</th>
            </tr>
            <c:forEach var="exam" items="${examDetails}">
                <tr>
                    <td>${exam.examId}</td>
                    <td>${exam.type}</td>
                    <td>${exam.duration}</td>
                    <td>${exam.structure}</td>
                    <td>${exam.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty examDetails}">
        <p>No exam details found.</p>
    </c:if>



</body>
</html>
