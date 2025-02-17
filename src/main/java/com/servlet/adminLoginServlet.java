package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.adminDBUtil;

//Servlet to handle admin login functionality.
@WebServlet({"/adminLoginServlet"})
public class adminLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L; // Serial version UID for serialization

// Default constructor
   public adminLoginServlet() {
   }

   //Handles POST requests for admin login.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();// Get the output writer to send response messages
      response.setContentType("text/html");// Set the response content type to HTML
   // Retrieve the username and password parameters from the request
      String userName = request.getParameter("uid");
      String password = request.getParameter("pass");
      boolean isTrue = adminDBUtil.validate(userName, password);// Validate the username and password using the adminDBUtil
   // Check if the validation was successful
      if (isTrue) {
         HttpSession session = request.getSession();// Create a session for the logged-in admin
         session.setAttribute("uid", userName);// Store the username in the session for later use
      // Forward the request to the admin dashboard page
         RequestDispatcher dis = request.getRequestDispatcher("admindashboard.jsp");
         dis.forward(request, response);
      } else {
    	// If validation fails, send an error message and redirect back to the login page
         out.println("<script type='text/javascript'>");
         out.println("alert('Your username or password is incorrect');");
         out.println("location='adminlogin.jsp';");// Redirect to the login page
         out.println("</script>");
      }

   }
}
