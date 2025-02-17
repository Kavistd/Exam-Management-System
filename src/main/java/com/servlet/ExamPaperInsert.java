package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ExamPaperDBUtil;

//Servlet for inserting exam paper details into the database.
@WebServlet({"/ExamPaperInsert"})
public class ExamPaperInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public ExamPaperInsert() {
   }

   //Handles POST requests for inserting an exam paper.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         String paperIdParam = request.getParameter("paperId");// Retrieve the paper ID from the request parameters
      // Validate that the paper ID is not null or empty
         if (paperIdParam == null || paperIdParam.trim().isEmpty()) {
            throw new IllegalArgumentException("Paper ID is missing or invalid");
         }

         int paperId = Integer.parseInt(paperIdParam);// Parse the paper ID to an integer
         // Retrieve the question and answer from the request parameters
         String question = request.getParameter("question");
         String answer = request.getParameter("answer");
         String examIdParam = request.getParameter("examId"); // Retrieve the exam ID from the request parameters
      // Validate that the exam ID is not null or empty
         if (examIdParam == null || examIdParam.trim().isEmpty()) {
            throw new IllegalArgumentException("Exam ID is missing or invalid");
         }

         int examId = Integer.parseInt(examIdParam);// Parse the exam ID to an integer
      // Call the utility method to insert the exam paper into the database
         boolean isTrue = ExamPaperDBUtil.insertExamPaper(paperId, question, answer, examId);
         RequestDispatcher dis;
      // Forward the request based on the success of the insertion
         if (isTrue) {
            dis = request.getRequestDispatcher("admindashboard.jsp");// Redirect to admin dashboard if insertion was successful
            dis.forward(request, response);
         } else {
            dis = request.getRequestDispatcher("adminunsuccess.jsp");// Redirect to an unsuccessful page if insertion failed
            dis.forward(request, response);
         }
      } catch (NumberFormatException var11) {
    	// Handle number format exceptions when parsing paper ID or exam ID
         var11.printStackTrace();
         response.getWriter().write("Invalid number format for Paper ID or Exam ID");
      } catch (IllegalArgumentException var12) {
    	// Handle invalid argument exceptions for missing parameters
         var12.printStackTrace();
         response.getWriter().write(var12.getMessage());
      } catch (Exception var13) {
    	// Handle any other exceptions that may occur
         var13.printStackTrace();
         response.getWriter().write("An error occurred during insertion.");
      }

   }
}
