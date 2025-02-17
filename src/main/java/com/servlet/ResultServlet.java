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

import com.model.Result;
import com.model.ResultDBUtil;

//Servlet for handling result retrieval for users.
@WebServlet({"/ResultServlet"})
public class ResultServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor
   public ResultServlet() {
   }
//Handles POST requests for fetching results for the logged-in user.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(); // Retrieve the current session
      String userName = (String)session.getAttribute("uid"); // Get the username from the session
   // Check if the user is logged in
      if (userName != null) {
         List<Result> results = ResultDBUtil.getResults(userName);// Fetch results associated with the user
         request.setAttribute("results", results);// Set the results as a request attribute to pass to the JSP
         RequestDispatcher dis = request.getRequestDispatcher("Usedashboard.jsp");// Forward the request to Usedashboard.jsp to display the results
         dis.forward(request, response);
      } else {
         response.sendRedirect("uslogin.jsp");// Redirect to the login page if the user is not logged in
      }

   }
}
