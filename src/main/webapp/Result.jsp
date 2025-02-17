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
<!-- Display Results Table -->
    <c:if test="${not empty results}">
        <h2>Results</h2>
        <table>
            <tr>
                <th>Result Code</th>
                <th>Credit Points</th>
                <th>Grade</th>
                <th>Username</th>
                <th>Action</th>
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result.resultCode}</td>
                    <td>${result.creditPoints}</td>
                    <td>${result.grade}</td>
                    <td>${result.userName}</td>
                    <td>
                        <!-- Update Button -->
                        <form action="updateResult.jsp" method="get" style="display:inline;">
                            <input type="hidden" name="resultCode" value="${result.resultCode}">
                            <input type="hidden" name="creditPoints" value="${result.creditPoints}">
                            <input type="hidden" name="grade" value="${result.grade}">
                            <input type="hidden" name="userName" value="${result.userName}">
                            <input type="submit" value="Update">
                        </form>

                        <!-- Delete Button -->
                        <form action="AdminResultServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="resultCode" value="${result.resultCode}">
                            <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this result?')">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>



<!-- Insert New Result Button -->
<div class="center">
    <form action="insertResult.jsp" method="get">
        <input type="submit" value="Insert New Result">
    </form>
</div>

</body>
</html>
