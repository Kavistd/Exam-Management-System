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

import com.model.User;
import com.model.UserDBUtil;

//Servlet that handles user-related operations such as displaying user details
@WebServlet({"/UserServlet", "/UserUpdateServlet"})
public class UserServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor.
   public UserServlet() {
   }

   //Handles POST requests.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Get the current session and retrieve the username.
      HttpSession session = request.getSession();
      String userName = (String)session.getAttribute("uid");
      if (userName != null) {
         List<User> userDetails = UserDBUtil.getUser(userName);// If the user is logged in, fetch user details from the database.
      // Set the user details as a request attribute and forward to the dashboard.
         request.setAttribute("userDetails", userDetails);
         RequestDispatcher dis = request.getRequestDispatcher("Usedashboard.jsp");
         dis.forward(request, response);
      } else {
         response.sendRedirect("uslogin.jsp"); // If the user is not logged in, redirect to the login page.
      }

   }

   //Handles GET requests.
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id = request.getParameter("id"); // Retrieve the user ID from the request parameter.
      List<User> userDetails = UserDBUtil.getUserDetails(id); // Fetch user details based on the provided ID.
      if (!userDetails.isEmpty()) {
    	  // If user details are found, set them as a request attribute and forward to the update page.
         request.setAttribute("user", userDetails.get(0));
         RequestDispatcher dis = request.getRequestDispatcher("userUpdate.jsp");
         dis.forward(request, response);
      } else {
    	// If user details are not found, set an error message and redirect to the dashboard.
         request.setAttribute("error", "User not found");
         response.sendRedirect("Usedashboard.jsp");
      }

   }
}
