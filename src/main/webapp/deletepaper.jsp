<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Paper</title>
</head>
<body>

    <%
    String paperId = request.getParameter("paperId");
    String question = request.getParameter("question");
    String answer = request.getParameter("answer");
%>

<h1>Delete Exam Paper</h1>

<form action="DeleteExamPaperServlet" method="post">
    <table>
        <tr>
            <td>Paper ID</td>
            <td><input type="text" name="paperId" value="<%= paperId %>" readonly></td>
        </tr>
        <tr>
            <td>Question</td>
            <td><input type="text" name="question" value="<%= question %>" readonly></td>
        </tr>
        <tr>
            <td>Answer</td>
            <td><input type="text" name="answer" value="<%= answer %>" readonly></td>
        </tr>
    </table>
    <br>
    <input type="submit" name="submit" value="Delete Paper">
</form>


</body>
</html>
