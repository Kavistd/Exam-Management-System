<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
        }

        .sidebar {
            width: 250px;
            background-color: #343a40;
            color: white;
            padding: 20px;
            height: 100vh;
        }

        .sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            margin: 15px 0;
        }

        .sidebar ul li a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px;
            border-radius: 4px;
            transition: background 0.3s;
        }

        .sidebar ul li a:hover {
            background-color: #495057;
        }

        .main-content {
            flex: 1;
            padding: 20px;
            margin-left: 20px;
        }

        h2, h3 {
            text-align: center;
            color: #333;
        }

        .cards {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

          .card {
            background-color: #343a40;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 200px;
        }

        .card h3 {
            margin: 10px 0;
        }
        
        .card p{
        	color: white;
        }.card h3{
        	color: white;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4B5EFF; /* Changed to blue from the image */
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type="submit"], a {
            padding: 10px 15px;
            font-size: 16px;
            background-color: #4B5EFF; /* Changed to blue from the image */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 20px auto;
            display: block;
            text-align: center;
            text-decoration: none;
            width: 200px;
            transition: background 0.3s;
        }

        input[type="submit"]:hover, a:hover {
            background-color: #3A4ECC; /* Darker blue shade */
        }
        
        .styled-button {
    	padding: 10px 20px; /* Adjust padding for button size */
    	background-color: #3b58f8; /* Solid blue color */
    	color: white; /* White text color */
   		border: none; /* No border */
    	border-radius: 0; /* Square corners (rectangular) */
    	font-size: 1rem; /* Font size */
    	font-weight: 600; /* Bold text */
    	text-transform: uppercase; /* Uppercase text */
    	cursor: pointer; /* Pointer cursor on hover */
    	transition: background-color 0.3s ease; /* Transition effects */
		}

		.styled-button:hover {
   		 background-color: #2d4abf; /* Darker blue on hover */
		}
    </style>
</head>
<body>
    <div class="sidebar">
        <h2 style="color: white;">User Dashboard</h2>
        <br>
               <br>
                      <br>
        <ul>
            <li><form action="UserServlet" method="post" style="text-align: center;">
                <input type="submit" value="View User Details">
            </form></li>

            <li><form action="ExamDetailServlet" method="post" style="text-align: center;">
                <input type="submit" value="Exam Details">
            </form></li>
            
            <li><form action="ExamPaperServlet" method="post">
                <input type="submit" value="Exam Paper">
            </form></li>
            
            <li><form action="ResultServlet" method="post" style="text-align: center;">
                <input type="submit" value="View Results">
            </form></li>

          <li>
    <form action="index.jsp" style="text-align: center;">
        <input type="submit" value="Logout" 
               style="background-color: red; 
                      color: white; 
                      border: none; 
                      padding: 10px 20px; 
                      border-radius: 5px; 
                      cursor: pointer; 
                      font-size: 1rem; 
                      transition: background-color 0.3s ease;">
    </form>
</li>

        </ul>
    </div>
    <div class="main-content">
        <h2>Welcome to User Dashboard</h2>
        <br>
        <br>
        <br>

        <div class="cards">
            <div class="card">
                <h3>Total Users</h3>
                <p>4</p>
            </div>
            <div class="card">
                <h3>Total Exam Papers</h3>
                <p>3</p>
            </div>
            <div class="card">
                <h3>Total Results</h3>
                <p>4</p>
            </div>
            <div class="card">
                <h3>Pending Approvals</h3>
                <p>5</p>
            </div>
        </div>

        <c:if test="${not empty userDetails}">
            <h3>Your Details</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Username</th>
                    <th>Action</th> <!-- Action Column for Updates -->
                </tr>
                <c:forEach var="user" items="${userDetails}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.userName}</td>
                        <td>
                            <form action="UserServlet" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="submit" class="action-btn" value="Update">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

              
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
					<button type="submit" name="save" value="${examPaper.paperId}" class="styled-button">
   						Save
					</button>
					
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>


        
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


<c:if test="${empty examDetails}">
    <p style="text-align: center;">No exam details found.</p>
</c:if>

</c:if>





        <c:if test="${not empty results}">
            <h3>Your Results</h3>
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
                        <td>
                            <form action="updateResult.jsp" method="get" style="display:inline;">
                                <input type="hidden" name="resultCode" value="${result.resultCode}">
                                <input type="hidden" name="creditPoints" value="${result.creditPoints}">
                                <input type="hidden" name="grade" value="${result.grade}">
                           
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:if>
    </div>
</body>
</html>
