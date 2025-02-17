package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ResultDBUtil;

//Servlet for handling updates to student results.
@WebServlet({"/UpdateResultServlet"})
public class UpdateResultServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public UpdateResultServlet() {
   }

   //Handles POST requests for updating a result.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String resultCode = request.getParameter("resultCode");
	      int creditPoints = Integer.parseInt(request.getParameter("creditPoints"));
	      String grade = request.getParameter("grade");
	      String userName = request.getParameter("userName");
	      boolean isUpdated = ResultDBUtil.updateResult(resultCode, creditPoints, grade, userName);
	      if (isUpdated) {
	         response.sendRedirect("adminsuccess.jsp");
	      } else {
	         response.sendRedirect("adminunsuccess.jsp");
	      }

	   }
}
