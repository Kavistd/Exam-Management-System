<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Results</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .action-buttons a {
            padding: 5px 10px;
            margin-right: 5px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 3px;
        }

        .action-buttons a.delete {
            background-color: #e74c3c;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">All Results</h2>
    <table>
        <tr>
            <th>Result Code</th>
            <th>Credit Points</th>
            <th>Grade</th>
            <th>UserName</th>
            <th>Action</th>
        </tr>
        <c:forEach var="result" items="${resultList}">
            <tr>
                <td>${result.resultCode}</td>
                <td>${result.creditPoints}</td>
                <td>${result.grade}</td>
                <td>${result.userName}</td>
                <td class="action-buttons">
                    <a href="EditResultServlet?id=${result.resultCode}">Edit</a>
                    <a href="DeleteResultServlet?id=${result.resultCode}" class="delete" 
                       onclick="return confirm('Are you sure you want to delete this result?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
