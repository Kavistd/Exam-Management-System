package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.adminDBUtil;

//Servlet for handling user updates.
@WebServlet({"/updateUserServlet"})
public class updateUserServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // Default constructor
   public updateUserServlet() {
   }

   //Handles POST requests to update user details.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));// Retrieve and parse the user ID from the request parameter
   // Retrieve other user details from request parameters
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      String username = request.getParameter("username");
      String password= request.getParameter("password");
      boolean isUpdated = adminDBUtil.updateUser(id, name, email, phone, username, password);// Call the utility method to update user information in the database
      // Check if the update operation was successful
      if (isUpdated) {
         response.sendRedirect("usersuccess.jsp");// Redirect to success page if the update was successful
      } else {
         response.getWriter().println("Error updating user details");// Display an error message if the update failed
      }

   }
}
