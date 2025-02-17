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

import com.model.ExamPaper;
import com.model.ExamPaperDBUtil;
import com.model.UserDBUtil;

//Servlet for handling exam paper operations such as retrieving and updating answers.
@WebServlet({"/ExamPaperServlet"})
public class ExamPaperServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public ExamPaperServlet() {
   }

   //Handles POST requests for retrieving and updating exam papers.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();// Obtain the current session
      String userName = (String)session.getAttribute("uid");// Get the username from the session to check if the user is logged in
      String saveAction = request.getParameter("save"); // Get the action parameter to determine if a save operation is requested
   // Check if the user is logged in
      if (userName != null) {
         List<ExamPaper> examPapers = UserDBUtil.getExamPapers();// Retrieve the list of exam papers for the user
         request.setAttribute("examPapers", examPapers);// Set the list of exam papers as a request attribute for the JSP page
      // Forward the request to the Usedashboard.jsp page
         RequestDispatcher dis = request.getRequestDispatcher("Usedashboard.jsp");
         dis.forward(request, response);
      } else {
         response.sendRedirect("uslogin.jsp");// If the user is not logged in, redirect to the login page
      }

   // Check if there is a save action request

      if (saveAction != null) {
         int paperId = Integer.parseInt(saveAction);// Parse the paper ID from the save action parameter
         String newAnswer = request.getParameter("answer_" + paperId);// Retrieve the new answer for the exam paper using the parameter name
         boolean isUpdated = ExamPaperDBUtil.updateAnswer(paperId, newAnswer);// Update the answer in the database
      // Check if the update was successful
         if (isUpdated) {
            response.sendRedirect("Usedashboard.jsp");// Redirect to the Usedashboard.jsp page if successful
         } else {
            response.getWriter().println("Error updating the answer."); // If the update failed, write an error message to the response
         }
      }

   }
}
