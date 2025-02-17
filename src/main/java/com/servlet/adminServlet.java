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
import com.model.adminDBUtil;

//Servlet to manage admin operations including user management.
@WebServlet({"/adminServlet"})
public class adminServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;// Serial version UID for serialization

// Default constructor
   public adminServlet() {
   }

   //Handles POST requests for the admin dashboard.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();// Retrieve the current session
      String username = (String)session.getAttribute("uid");// Get the username of the logged-in admin from the session
      List<User> userList = adminDBUtil.getAllUsers();// Retrieve the list of all users from the database
      request.setAttribute("userList", userList);// Set the user list as a request attribute to be accessed in the JSP
      RequestDispatcher dispatcher = request.getRequestDispatcher("admindashboard.jsp");// Forward the request to the admin dashboard page
      dispatcher.forward(request, response);
   }

   //Handles GET requests for user actions such as delete and edit.
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");// Get the action parameter to determine what operation to perform
      String id = request.getParameter("id");// Get the user ID parameter from the request
   // Check if the action is to delete a user
      if ("delete".equals(action)) {
         adminDBUtil.deleteUser(id);// Call the utility method to delete the user from the database
      } else if ("edit".equals(action)) {
         request.setAttribute("user", adminDBUtil.getUserById(id)); // Retrieve the user details by ID and set it as a request attribute
         RequestDispatcher dispatcher = request.getRequestDispatcher("userUpdate.jsp");// Forward the request to the user update page
         dispatcher.forward(request, response);
         return;
      }

      response.sendRedirect("admindashboard.jsp");// Redirect to the admin dashboard after performing the action
   }
}
