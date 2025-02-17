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

import com.model.UserDBUtil;

//Servlet for user login handling.
@WebServlet({"/UseLoginServlet"})
public class UseLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

// Default constructor.
   public UseLoginServlet() {
   }

   //Handles POST requests for user login.
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();// Prepare a PrintWriter to send responses to the client.
      response.setContentType("text/html");// Set the response content type to HTML.
   // Retrieve login credentials from the request parameters.
      String userName = request.getParameter("uid");
      String password = request.getParameter("pass");
      boolean isTrue = UserDBUtil.validate(userName, password); // Validate the user's credentials using the UserDBUtil class.
      if (isTrue) {
         HttpSession session = request.getSession();// If validation is successful, create a new session and store the username.
         session.setAttribute("uid", userName);
         RequestDispatcher dis = request.getRequestDispatcher("Usedashboard.jsp"); // Forward the request to the user dashboard.
         dis.forward(request, response);
      } else {
    	  // If login fails, display an alert and redirect to the login page.
         out.println("<script type='text/javascript'>");
         out.println("alert('Your username or password is incorrect');");
         out.println("location='uslogin.jsp'");
         out.println("</script>");
      }

   }
}
