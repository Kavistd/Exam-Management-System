<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Results Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        h2, h3 {
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
    <h2>Results</h2>

    <c:if test="${not empty results}">
        <table>
            <tr>
                <th>Result Code</th>
                <th>Credit Points</th>
                <th>Grade</th>
                <th>User Name</th>
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result.resultCode}</td>
                    <td>${result.creditPoints}</td>
                    <td>${result.grade}</td>
                    <td>${result.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
