package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;

//Utility class for database operations related to the 'User' table.
public class UserDBUtil {
	// Variables for managing database connections and queries.
   private static boolean isSuccess;
   private static Connection con = null;
   private static Statement stmt = null;
   private static ResultSet rs = null;

   public UserDBUtil() {
   }

   //Validates user credentials by checking username and password in the database.
   public static boolean validate(String username, String password) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from user where username='" + username + "' and password='" + password + "'";
         rs = stmt.executeQuery(sql);
         if (rs.next()) {
            isSuccess = true;
         } else {
            isSuccess = false;
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return isSuccess;
   }

   //Retrieves user details based on the provided username.
   public static List<User> getUser(String userName) {
      ArrayList<User> users = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from user where username='" + userName + "'";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            User user = new User(id, name, email, phone, username, password);
            users.add(user);
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      return users;
   }

   //Inserts a new user into the database.
   public static boolean insertUser(String name, String email, String phone, String userName, String password) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "INSERT INTO user VALUES (0, '" + name + "', '" + email + "', '" + phone + "', '" + userName + "', '" + password + "')";
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
         } else {
            isSuccess = false;
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return isSuccess;
   }

   //Updates the details of an existing user in the database.
   public static boolean updateUser(String id, String name, String email, String phone, String username, String password) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "update user set name='" + name + "',email='" + email + "',phone='" + phone + "',username='" + username + "',password='" + password + "' where id='" + id + "'";
         int rs = stmt.executeUpdate(sql);
         isSuccess = rs > 0;
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return isSuccess;
   }

   //Retrieves user details based on the provided user ID.
   public static List<User> getUserDetails(String Id) {
      int convertedID = Integer.parseInt(Id);
      ArrayList<User> users = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from user where id='" + convertedID + "'";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            User user = new User(id, name, email, phone, username, password);
            users.add(user);
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      return users;
   }

   //Deletes a user from the database based on the provided ID.
   public static boolean deleteUser(String id) {
      int convId = Integer.parseInt(id);

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "delete from user where id='" + convId + "'";
         int r = stmt.executeUpdate(sql);
         isSuccess = r > 0;
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return isSuccess;
   }

   //Retrieves all exam papers from the database.
   public static List<ExamPaper> getExamPapers() {
      List<ExamPaper> examPapers = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT paperId, question, answer, examID FROM exam_paper";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int paperId = rs.getInt("paperId");
            String question = rs.getString("question");
            String answer = rs.getString("answer");
            int examId = rs.getInt("examId");
            ExamPaper examPaper = new ExamPaper(paperId, question, answer, examId);
            examPapers.add(examPaper);
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return examPapers;
   }

   //Retrieves all exam details from the database.
   public static List<ExamDetail> getExamDetails() {
      List<ExamDetail> examDetails = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT examId, examName, examDate, duration FROM exam_details";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int examId = rs.getInt("examId");
            String examName = rs.getString("examName");
            String examDate = rs.getString("examDate");
            int duration = rs.getInt("duration");
            ExamDetail examDetail = new ExamDetail(examId, examName, examDate, duration);
            examDetails.add(examDetail);
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return examDetails;
   }

   //Retrieves all results for a specific user by username.
   public static List<Result> getResultsByUserName(String userName) {
      List<Result> results = new ArrayList();

      try {
         con = DBConnect.getConnection();
         String sql = "SELECT * FROM result WHERE userName = ?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, userName);
         rs = stmt.executeQuery();

         while(rs.next()) {
            int resultCode = rs.getInt("result_code");
            int creditPoints = rs.getInt("credit_points");
            String grade = rs.getString("grade");
            Result result = new Result(resultCode, creditPoints, grade, userName);
            results.add(result);
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return results;
   }

   public static boolean updateUser(int id, String name, String email, String phone, String username) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "UPDATE user SET name=?, email=?, phone=?, username=? WHERE id=?";
         PreparedStatement preparedStatement = con.prepareStatement(sql);
         preparedStatement.setString(1, name);
         preparedStatement.setString(2, email);
         preparedStatement.setString(3, phone);
         preparedStatement.setString(4, username);
         preparedStatement.setInt(5, id);
         int rowsUpdated = preparedStatement.executeUpdate();
         return rowsUpdated > 0;
      } catch (Exception var8) {
         var8.printStackTrace();
         return false;
      }
   }
}
