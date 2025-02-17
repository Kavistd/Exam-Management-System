package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ExamDetailDBUtil;

//Servlet for handling exam detail updates.
@WebServlet({"/UpdateExamServlet"})
public class UpdateExamServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public UpdateExamServlet() {
   }

   //Handles POST requests for updating exam details.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int examId = Integer.parseInt(request.getParameter("examId"));// Retrieve the exam ID from the request parameter and parse it to an integer
   // Get other exam details from the request parameters
      String type = request.getParameter("type");
      String duration = request.getParameter("duration");
      String structure = request.getParameter("structure");
      String userName = request.getParameter("userName");
      boolean isUpdated = ExamDetailDBUtil.updateExamDetail(examId, type, duration, structure, userName); // Call the utility method to update exam details in the database
      RequestDispatcher dispatcher;// Dispatcher for forwarding requests
   // Check if the update operation was successful
      if (isUpdated) {
    	// If successful, set a success message and forward to the admin dashboard
         request.setAttribute("message", "Exam details updated successfully.");
         dispatcher = request.getRequestDispatcher("admindashboard.jsp");
         dispatcher.forward(request, response);
      } else {
    	// If unsuccessful, set an error message and forward to the edit exam page
         request.setAttribute("message", "Failed to update exam details.");
         dispatcher = request.getRequestDispatcher("adminunsuccess.jsp");
         dispatcher.forward(request, response);
      }

   }
}
