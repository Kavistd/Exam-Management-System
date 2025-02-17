package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;

//Utility class to interact with the 'exam_paper' table in the database.
public class ExamPaperDBUtil {
	// Database connection and statement objects
   private static Connection con = null;
   private static Statement stmt = null;
   private static ResultSet rs = null;

   public ExamPaperDBUtil() {
   }

   //Retrieves all exam paper records from the database.
   public static List<ExamPaper> getExamPaperDetails() {
      List<ExamPaper> examPapers = new ArrayList();

      try {
    	  // Establish a database connection
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT * FROM exam_paper";// SQL query to fetch all papers
         rs = stmt.executeQuery(sql);

      // Iterate over the result set and create ExamPaper objects
         while(rs.next()) {
            int paperId = rs.getInt("paperId");
            String question = rs.getString("question");
            String answer = rs.getString("answer");
            int examId = rs.getInt("examID");
            ExamPaper paper = new ExamPaper(paperId, question, answer, examId);
            System.out.println(paper);
            examPapers.add(paper);
         }
      } catch (Exception var15) {
         var15.printStackTrace(); // Log the exception
      } finally {
    	// Close resources to prevent memory leaks
         try {
            if (rs != null) {
               rs.close();
            }

            if (stmt != null) {
               stmt.close();
            }

            if (con != null) {
               con.close();
            }
         } catch (Exception var14) {
            var14.printStackTrace();// Log closing exceptions
         }

      }

      return examPapers;
   }

   //Updates the answer of a specific exam paper in the database.
   public static boolean updateAnswer(int paperId, String answer) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "UPDATE exam_paper SET answer = '" + answer + "' WHERE paperId = " + paperId;
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
         }
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         try {
            if (stmt != null) {
               stmt.close();
            }

            if (con != null) {
               con.close();
            }
         } catch (Exception var12) {
            var12.printStackTrace();
         }

      }

      return isSuccess;
   }

   //Inserts a new exam paper record into the database.
   public static boolean insertExamPaper(int paperId, String question, String answer, int examId) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "INSERT INTO exam_paper (paperId, question, answer, examID) VALUES (" + paperId + ", '" + question + "', '" + answer + "', " + examId + ")";
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
         }
      } catch (Exception var15) {
         var15.printStackTrace();
      } finally {
         try {
            if (stmt != null) {
               stmt.close();
            }

            if (con != null) {
               con.close();
            }
         } catch (Exception var14) {
            var14.printStackTrace();
         }

      }

      return isSuccess;
   }

   //Updates an existing exam paper record with new values.
   public static boolean updateExamPaper(int paperId, String question, String answer, int examId) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "UPDATE exam_paper SET question = '" + question + "', answer = '" + answer + "', examID = " + examId + " WHERE paperId = " + paperId;
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
         }
      } catch (Exception var15) {
         var15.printStackTrace();
      } finally {
         try {
            if (stmt != null) {
               stmt.close();
            }

            if (con != null) {
               con.close();
            }
         } catch (Exception var14) {
            var14.printStackTrace();
         }

      }

      return isSuccess;
   }

   //Deletes an exam paper record from the database.
   public static boolean deleteExamPaper(int paperId) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "DELETE FROM exam_paper WHERE paperId = " + paperId;
         System.out.println("Executing query: " + sql);// Debugging print
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
            System.out.println("Paper deleted successfully.");
         } else {
            System.out.println("No paper found with the given ID.");
         }
      } catch (Exception var12) {
         var12.printStackTrace();
      } finally {
         try {
            if (stmt != null) {
               stmt.close();
            }

            if (con != null) {
               con.close();
            }
         } catch (Exception var11) {
            var11.printStackTrace();
         }

      }

      return isSuccess;
   }
}
