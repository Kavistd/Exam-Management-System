package com.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;

//Utility class for interacting with the 'result' database table.
public class ResultDBUtil {
	// Database connection, statement, and result set objects for query execution.
   private static Connection con = null;
   private static Statement stmt = null;
   private static ResultSet rs = null;

   public ResultDBUtil() {
   }

   //Retrieves a list of results for a specific user.
   public static List<Result> getResults(String userName) {
      ArrayList<Result> results = new ArrayList();

      try {
    	// Establish connection to the database.
         con = DBConnect.getConnection();
         stmt = con.createStatement();
        // SQL query to retrieve results for the specified user.
         String sql = "select * from result where userName='" + userName + "'";
         rs = stmt.executeQuery(sql);

      // Iterate through the result set and populate the list.
         while(rs.next()) {
            String resultCode = rs.getString(1);
            int creditPoints = rs.getInt(2);
            String grade = rs.getString(3);
         // Create a Result object and add it to the list.
            Result result = new Result(resultCode, creditPoints, grade, userName);
            results.add(result);
         }
      } catch (Exception var7) {
    	// Handle any exceptions and print the stack trace for debugging.
         var7.printStackTrace();
      }

      return results;
   }

   //Updates an existing result record in the database.
   public static boolean updateResult(String resultCode, int creditPoints, String grade, String userName) {
      boolean isUpdated = false;

      try {
    	// Establish connection and prepare the SQL update statement.
         Connection con = DBConnect.getConnection();
         String sql = "UPDATE result SET credit_points = ?, grade = ?, userName = ? WHERE result_code = ?";
         PreparedStatement pstmt = con.prepareStatement(sql);
      // Set the parameters for the prepared statement.
         pstmt.setInt(1, creditPoints);
         pstmt.setString(2, grade);
         pstmt.setString(3, userName);
         pstmt.setString(4, resultCode);
         
         // Execute the update and check if rows were affected.
         int rowsAffected = pstmt.executeUpdate();
         isUpdated = rowsAffected > 0;
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      return isUpdated;
   }

   //Retrieves all result records from the database.
   public static List<Result> getAllResults() {
      List<Result> results = new ArrayList();

      try {
    	// Establish connection and execute the SQL query.
         con = DBConnect.getConnection();
         String sql = "SELECT * FROM result";
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);

      // Populate the list with result data from the result set.
         while(rs.next()) {
            String resultCode = rs.getString("result_code");
            int creditPoints = rs.getInt("credit_points");
            String grade = rs.getString("grade");
            String userName = rs.getString("userName");
            Result result = new Result(resultCode, creditPoints, grade, userName);
            results.add(result);
         }
      } catch (Exception var15) {
         var15.printStackTrace();
      } finally {
    	  // Close the connection to release resources.
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception var14) {
            var14.printStackTrace();
         }

      }

      return results;
   }

   //Deletes a result record from the database.
   public static boolean deleteResult(String resultCode) {
      boolean isDeleted = false;

      try {
    	// Establish connection and prepare the delete statement.
         con = DBConnect.getConnection();
         String sql = "DELETE FROM result WHERE result_code = ?";
         PreparedStatement pstmt = con.prepareStatement(sql);
         // Set the result code parameter.
         pstmt.setString(1, resultCode);
         // Execute the delete operation and check if it was successful.
         int rowsAffected = pstmt.executeUpdate();
         isDeleted = rowsAffected > 0;
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
    	// Ensure the connection is closed to free resources.
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception var12) {
            var12.printStackTrace();
         }

      }

      return isDeleted;
   }

   //Inserts a new result record into the database.
   public static boolean insertResult(String resultCode, int creditPoints, String grade, String userName) {
      boolean isInserted = false;

      try {
    	// Establish connection and prepare the insert statement.
         con = DBConnect.getConnection();
         String sql = "INSERT INTO result (result_code, credit_points, grade, userName) VALUES (?, ?, ?, ?)";
         PreparedStatement pstmt = con.prepareStatement(sql);
         // Set the parameters for the insert operation.
         pstmt.setString(1, resultCode);
         pstmt.setInt(2, creditPoints);
         pstmt.setString(3, grade);
         pstmt.setString(4, userName);
      // Execute the insert operation and check if it was successful.
         int rowsAffected = pstmt.executeUpdate();
         isInserted = rowsAffected > 0;
      } catch (Exception var16) {
         var16.printStackTrace();
      } finally {
    	// Ensure the connection is closed to free resources.
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception var15) {
            var15.printStackTrace();
         }

      }

      return isInserted;
   }
}
