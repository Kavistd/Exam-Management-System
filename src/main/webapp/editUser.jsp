<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User Details</h1>

    <form action="updateUserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}">
        Name: <input type="text" name="name" value="${user.name}"><br>
        Email: <input type="text" name="email" value="${user.email}"><br>
        Phone: <input type="text" name="phone" value="${user.phone}"><br>
        Username: <input type="text" name="username" value="${user.userName}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>