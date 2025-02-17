package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.model.ExamPaper;
import com.model.ExamPaperDBUtil;

//Servlet that handles admin-related actions for managing exam papers
//Provides functionality for deleting exam papers and retrieving exam paper details.
@WebServlet({"/AdminExamPaperServlet"})
public class AdminExamPaperServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public AdminExamPaperServlet() {
   }

   //Handles POST requests to manage exam papers.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Retrieve the action parameter from the request
	   String action = request.getParameter("action");
	// Check if the action is to delete an exam paper
      if ("delete".equals(action)) {
         int paperId = Integer.parseInt(request.getParameter("paperId"));// Parse the paper ID from the request
         boolean success = ExamPaperDBUtil.deleteExamPaper(paperId);// Attempt to delete the exam paper and capture success status
         
      // Redirect to admin dashboard if successful, otherwise print an error message
         if (success) {
            response.sendRedirect("admindashboard.jsp");
         } else {
            response.getWriter().println("Error deleting paper.");
         }
      } else {
    	// If not a delete action, retrieve exam paper details
         List<ExamPaper> examPapers = ExamPaperDBUtil.getExamPaperDetails();
         request.setAttribute("examPapers", examPapers);// Set the exam papers as a request attribute
         RequestDispatcher dis = request.getRequestDispatcher("admindashboard.jsp");// Forward the request and response to the admin dashboard
         dis.forward(request, response);
      }

   }

   //Handles GET requests to retrieve and display exam papers
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // Retrieve exam paper details for displaying
      List<ExamPaper> examPapers = ExamPaperDBUtil.getExamPaperDetails();
      request.setAttribute("examPapers", examPapers);// Set the exam papers as a request attribute
      // Forward the request and response to the admin dashboard
      RequestDispatcher dis = request.getRequestDispatcher("admindashboard.jsp");
      dis.forward(request, response);
   }
}
