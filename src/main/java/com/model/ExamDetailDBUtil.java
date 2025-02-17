package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;

//Utility class to manage database operations related to ExamDetail.
public class ExamDetailDBUtil {
	// Database connection objects.
   private static Connection con = null;// Database connection.
   private static Statement stmt = null;// Statement for executing SQL queries.
   private static ResultSet rs = null; // Result set to store query results.

   public ExamDetailDBUtil() {
   }

   //Retrieves a list of exam details for a specific user.
   public static List<ExamDetail> getExamDetails(String userName) {
      List<ExamDetail> examDetails = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT * FROM exam_detail WHERE userName='" + userName + "'";
         rs = stmt.executeQuery(sql);

      // Extract exam details from result set and add to the list.
         while(rs.next()) {
            int examId = rs.getInt("examId");
            String type = rs.getString("type");
            String duration = rs.getString("duration");
            String structure = rs.getString("structure");
            ExamDetail examDetail = new ExamDetail(examId, type, duration, structure, userName);
            examDetails.add(examDetail);
         }
      } catch (Exception var8) {
         var8.printStackTrace();// Log any exceptions encountered.
      }

      return examDetails;
   }

   //Retrieves all exam details from the database.
   public static List<ExamDetail> getAllExamDetails() {
      List<ExamDetail> examDetails = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT * FROM exam_detail";
         rs = stmt.executeQuery(sql);

      // Extract exam details from result set and add to the list.
         while(rs.next()) {
            int examId = rs.getInt("examId");
            String type = rs.getString("type");
            String duration = rs.getString("duration");
            String structure = rs.getString("structure");
            String userName = rs.getString("userName");
            ExamDetail examDetail = new ExamDetail(examId, type, duration, structure, userName);
            examDetails.add(examDetail);
         }
      } catch (Exception var8) {
         var8.printStackTrace();// Log any exceptions encountered.
      }

      return examDetails;
   }

   //Inserts a new exam detail into the database.
   public static boolean insertExam(String type, String duration, String structure, String userName) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         String sql = "INSERT INTO exam_detail (type, duration, structure, userName) VALUES (?, ?, ?, ?)";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, type);
         pstmt.setString(2, duration);
         pstmt.setString(3, structure);
         pstmt.setString(4, userName);
         int rowsInserted = pstmt.executeUpdate();
         isSuccess = rowsInserted > 0;// Check if insertion was successful.
      } catch (Exception var16) {
         System.out.println("Insert operation failed: " + var16.getMessage());
         var16.printStackTrace();// Log the exception details.
      } finally {
    	// Ensure the connection is closed to avoid memory leaks.
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception var15) {
            var15.printStackTrace();// Log any errors encountered while closing the connection.
         }

      }

      return isSuccess;
   }

   //Updates an existing exam detail in the database.
   public static boolean updateExamDetail(int examId, String type, String duration, String structure, String userName) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         String sql = "UPDATE exam_detail SET type = ?, duration = ?, structure = ?, userName = ? WHERE examId = ?";
         PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setString(1, type);
         pstmt.setString(2, duration);
         pstmt.setString(3, structure);
         pstmt.setString(4, userName);
         pstmt.setInt(5, examId);
         int rowsAffected = pstmt.executeUpdate();
         isSuccess = rowsAffected > 0;// Check if the update was successful.
      } catch (Exception var9) {
         var9.printStackTrace();// Log any exceptions encountered.
      }

      return isSuccess;
   }

   //Deletes an exam detail from the database.
   public static boolean deleteExamDetail(int examId) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "DELETE FROM exam_detail WHERE examId = " + examId;
         int result = stmt.executeUpdate(sql);
         return result > 0;// Return true if a row was deleted.
      } catch (Exception var3) {
         var3.printStackTrace();// Log any exceptions encountered.
         return false;
      }
   }
}
