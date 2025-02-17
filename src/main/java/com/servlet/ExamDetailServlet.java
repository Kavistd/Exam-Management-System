package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.model.ExamDetail;
import com.model.ExamDetailDBUtil;

//Servlet to handle requests related to exam details.
@WebServlet({"/ExamDetailServlet"})
public class ExamDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public ExamDetailServlet() {
   }

   //Handles POST requests to fetch exam details for a specific user.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();// Retrieve the current session
      String userName = (String)session.getAttribute("uid");// Get the username of the logged-in user from the session
   // Check if the user is logged in
      if (userName != null) {
         List<ExamDetail> examDetails = ExamDetailDBUtil.getExamDetails(userName);// Fetch exam details for the logged-in user
         request.setAttribute("examDetails", examDetails);// Set the exam details as a request attribute to be accessed in the JSP
         RequestDispatcher dis = request.getRequestDispatcher("Usedashboard.jsp");// Forward the request to the user dashboard page
         dis.forward(request, response);
      } else {
         response.sendRedirect("uslogin.jsp");// If the user is not logged in, redirect to the login page
      }

   }

   //Handles GET requests for deleting exam details or fetching all exam details.
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");// Get the action parameter to determine what operation to perform
   // Check if the action is to delete an exam detail
      if ("delete".equals(action)) {
         int examId = Integer.parseInt(request.getParameter("examId"));// Parse the exam ID from the request parameter
         boolean isDeleted = ExamDetailDBUtil.deleteExamDetail(examId);// Call the utility method to delete the exam detail from the database
         
      // Set a message indicating whether the deletion was successful or failed
         if (isDeleted) {
            request.setAttribute("message", "Exam deleted successfully!");
         } else {
            request.setAttribute("message", "Failed to delete the exam.");
         }
      }

      List<ExamDetail> examDetails = ExamDetailDBUtil.getAllExamDetails();// Fetch all exam details from the database
      request.setAttribute("examDetails", examDetails); // Set the list of exam details as a request attribute
   // Forward the request to the admin dashboard page
      RequestDispatcher dispatcher = request.getRequestDispatcher("admindashboard.jsp");
      dispatcher.forward(request, response);
   }
}
