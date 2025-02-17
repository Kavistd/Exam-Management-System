package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.ResultDBUtil;

//Servlet for handling the insertion of result details.
@WebServlet({"/InsertResultServlet"})
public class InsertResultServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public InsertResultServlet() {
   }

   //Handles POST requests for inserting result details.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Retrieve parameters from the request
      String resultCode = request.getParameter("resultCode");// Unique identifier for the result
      int creditPoints = Integer.parseInt(request.getParameter("creditPoints"));// Credit points associated with the result
      String grade = request.getParameter("grade");// Grade awarded for the result
      String userName = request.getParameter("userName");// User who is inserting the result
      boolean isInserted = ResultDBUtil.insertResult(resultCode, creditPoints, grade, userName);// Attempt to insert the result details into the database
   // Check if the insertion was successful
      if (isInserted) {
         response.sendRedirect("AdminResultServlet");// Redirect to AdminResultServlet if insertion was successful
      } else {
         response.getWriter().write("Failed to insert the result.");// Write an error message to the response if insertion failed
      }

   }
}
