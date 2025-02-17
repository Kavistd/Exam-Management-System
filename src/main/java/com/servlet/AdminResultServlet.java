package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.model.Result;
import com.model.ResultDBUtil;

//Servlet to handle admin operations related to results.
@WebServlet({"/AdminResultServlet"})
public class AdminResultServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public AdminResultServlet() {
   }

   //Handles GET requests to retrieve all results and forward them to the admin dashboard.
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
    	// Retrieve all results from the database
         List<Result> results = ResultDBUtil.getAllResults();
         request.setAttribute("results", results);// Set the results as a request attribute
      // Forward the request to the admin dashboard JSP page
         RequestDispatcher dis = request.getRequestDispatcher("admindashboard.jsp");
         dis.forward(request, response);
      } catch (Exception var5) {
         var5.printStackTrace();// Print the stack trace for debugging
         response.sendRedirect("adminunsuccess.jsp");// Redirect to an error page if an exception occurs
      }

   }

   //Handles POST requests for actions related to results.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Retrieve the action parameter from the request
	   String action = request.getParameter("action");
	// Check if the action is to delete a result
      if ("delete".equals(action)) {
         String resultCode = request.getParameter("resultCode");// Get the result code to delete
         
      // Call the method to delete the result and check if it was successful
         boolean isDeleted = ResultDBUtil.deleteResult(resultCode);
         if (isDeleted) {
            response.sendRedirect("admindashboard.jsp");// Redirect to the admin dashboard if deletion was successful
         } else {
            response.getWriter().write("Failed to delete result.");// If deletion failed, write an error message to the response
         }
      }

   }
}
