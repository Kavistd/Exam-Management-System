package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ExamPaperDBUtil;

//Servlet for handling updates to exam papers.
@WebServlet({"/UpdatePaperServlet"})
public class UpdatePaperServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public UpdatePaperServlet() {
   }

   //Handles POST requests for updating an exam paper.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int paperId = Integer.parseInt(request.getParameter("paperId"));
	      String question = request.getParameter("question");
	      String answer = request.getParameter("answer");
	      int examId = Integer.parseInt(request.getParameter("examId"));
	      boolean isUpdated = ExamPaperDBUtil.updateExamPaper(paperId, question, answer, examId);
	      if (isUpdated) {
	         response.sendRedirect("adminsuccess.jsp");
	      } else {
	         response.sendRedirect("adminunsuccess.jsp");
	      }

	   }
}
