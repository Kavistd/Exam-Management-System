package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ExamDetailDBUtil;

//Servlet for handling the insertion of exam details.
@WebServlet({"/InsertExamServlet"})
public class InsertExamServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public InsertExamServlet() {
   }

   //Handles POST requests for inserting exam details.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // Retrieve parameters from the request
      String type = request.getParameter("type");// Type of the exam
      String duration = request.getParameter("duration"); // Duration of the exam
      String structure = request.getParameter("structure");// Structure of the exam
      String userName = request.getParameter("userName");// User who created the exam

      RequestDispatcher dispatcher;// Initialize RequestDispatcher
      try {
         boolean isInserted = ExamDetailDBUtil.insertExam(type, duration, structure, userName);// Attempt to insert the exam details into the database
      // Check if the insertion was successful
         if (isInserted) {
        	// Set a success message and forward to the admin dashboard
            request.setAttribute("message", "Exam inserted successfully.");
            dispatcher = request.getRequestDispatcher("admindashboard.jsp");
            dispatcher.forward(request, response);
         } else {
        	// Set a failure message and forward back to the insert exam page
            request.setAttribute("message", "Failed to insert exam details.");
            dispatcher = request.getRequestDispatcher("insertExam.jsp");
            dispatcher.forward(request, response);
         }
      } catch (Exception var9) {
    	// Handle exceptions and log the error
         var9.printStackTrace();// Print the stack trace for debugging
      // Set an error message and forward to the insert exam page
         request.setAttribute("message", "An error occurred: " + var9.getMessage());
         dispatcher = request.getRequestDispatcher("insertExam.jsp");
         dispatcher.forward(request, response);
      }

   }
}
