<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><!-- user -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam Papers</title>
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
    
    
    <c:if test="${not empty examPapers}">
    <h2>Exam Papers</h2>
    <form action="ExamPaperServlet" method="post">
        <table>
            <tr>
                <th>Paper ID</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Exam ID</th>
                <th>Action</th>
                
            </tr>
            <c:forEach var="examPaper" items="${examPapers}">
                <tr>
                    <td>${examPaper.paperId}</td>
                    <td>${examPaper.question}</td>
                    <td>
                        <!-- Answer Input Field -->
                        <input type="text" name="answer_${examPaper.paperId}" 
                               value="${examPaper.answer}" placeholder="Enter Answer">
                    </td>
                    <td>${examPaper.examId}</td>
                    <td>
                        <!-- Save Button for each row -->
                        <button type="submit" name="save" value="${examPaper.paperId}">
                            Save
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>

</body>
</html>
