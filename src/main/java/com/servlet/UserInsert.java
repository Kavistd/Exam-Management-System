package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.UserDBUtil;

//Servlet for inserting a new user into the system.
@WebServlet({"/UserInsert"})
public class UserInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // Default constructor.
   public UserInsert() {
   }

   //Handles POST requests for user creation.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Retrieve form parameters for the new user.
	  String name = request.getParameter("name");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      String username = request.getParameter("userName");
      String password = request.getParameter("password");
      boolean isInserted = UserDBUtil.insertUser(name, email, phone, username, password);// Call the utility method to insert the user into the database.
      RequestDispatcher dis; // Define a RequestDispatcher to forward the request based on the operation result.
      if (isInserted) {
         dis = request.getRequestDispatcher("uslogin.jsp");// If insertion is successful, forward to the success page.
         dis.forward(request, response);
      } else {
         dis = request.getRequestDispatcher("userunsuccess.jsp");// If insertion fails, forward to the failure page.
         dis.forward(request, response);
      }

   }
}
