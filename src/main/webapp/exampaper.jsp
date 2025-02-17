<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><!-- admins -->
<html>
<head>
<meta charset="UTF-8">
<title>Exam Paper</title>

<style type="text/css">
    body{
        font-family: Hind SemiBold;
    }

    table, th, td {
        border: 1px solid black;
    }
</style>
</head>
<body>

    <table>
    <c:forEach var="examPapers" items="${examPapers}">

    <c:set var="paperId" value="${examPapers.paperId}"/>
    <c:set var="question" value="${examPapers.question}"/>
    <c:set var="answer" value="${examPapers.answer}"/>

    <tr>
        <td>Paper ID</td>
        <td>${paper.paperId}</td>
    </tr>
    <tr>
        <td>Question</td>
        <td>${paper.question}</td>
    </tr>
    <tr>
        <td>Answer</td>
        <td>${paper.answer}</td>
    </tr>

    </c:forEach>
    </table>

    <c:url value="updatepaper.jsp" var="paperupdate">
        <c:param name="paperId" value="${paperId}"/>
        <c:param name="question" value="${question}"/>
        <c:param name="answer" value="${answer}"/>
    </c:url>

    <a href="${paperupdate}">
    <input type="button" name="update" value="Update Paper">
    </a>

    <br>
    <c:url value="deletepaper.jsp" var="paperdelete">
        <c:param name="paperId" value="${paperId}" />
        <c:param name="question" value="${question}" />
        <c:param name="answer" value="${answer}" />
    </c:url>
    <a href="${paperdelete}">
    <input type="button" name="delete" value="Delete Paper">
    </a>

</body>
</html>
