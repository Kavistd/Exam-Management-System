
package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;

//Utility class to manage database operations related to admins and users.
public class adminDBUtil {
	
	// Static fields used for database operations.
	
   private static boolean isSuccess;// Tracks if a database operation was successful.
   private static Connection con = null;// Database connection.
   private static Statement stmt = null;// Statement for executing SQL queries.
   private static ResultSet rs = null;// Result set to store query results.

// Default constructor.
   public adminDBUtil() {
   }
   //Validates an admin's credentials.
   public static boolean validate(String username, String password) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from admin where username='" + username + "' and password='" + password + "'";
         rs = stmt.executeQuery(sql);
         if (rs.next()) {
            isSuccess = true;// Set to true if a matching record is found.
         } else {
            isSuccess = false;// Logs exceptions to the console.
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return isSuccess;
   }
   
   //Retrieves all users from the database.
   public static List<User> getAllUsers() {
      ArrayList<User> users = new ArrayList();

      try {
         Connection con = DBConnect.getConnection();
         Statement stmt = con.createStatement();
         String sql = "SELECT * FROM user";
         ResultSet rs = stmt.executeQuery(sql);
         
      // Iterate through the result set and create User objects.
         while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id, name, email, phone, username, password);
            users.add(user);
         }
      } catch (Exception var12) {
         var12.printStackTrace();
      }

      return users;
   }
   
   //Deletes a user from the database.
   public static boolean deleteUser(String id) {
      try {
         Connection con = DBConnect.getConnection();
         String sql = "DELETE FROM user WHERE id=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, id);
         int result = stmt.executeUpdate();
         return result > 0;
      } catch (Exception var5) {
         var5.printStackTrace();
         return false;
      }
   }
   
   //Retrieves a user by ID.
   public static User getUserById(String id) {
      User user = null;

      try {
         Connection con = DBConnect.getConnection();
         String sql = "SELECT * FROM users WHERE id=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, id);
         ResultSet rs = stmt.executeQuery();
         if (rs.next()) {
            int userId = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String username = rs.getString("userName");
            user = new User(userId, name, email, phone, username, username);
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      return user;
   }

   //Updates a user's details.
   public static boolean updateUser(int id, String name, String email, String phone, String username, String password) {
      boolean isSuccess = false;

      try {
         Connection con = DBConnect.getConnection();
         String sql = "UPDATE user SET name=?, email=?, phone=?, userName=?, password=? WHERE id=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, name);
         stmt.setString(2, email);
         stmt.setString(3, phone);
         stmt.setString(4, username);
         stmt.setString(5,password);
         stmt.setInt(6, id);
         int rowsAffected = stmt.executeUpdate();
         if (rowsAffected > 0) {
            isSuccess = true;
         }

         stmt.close();
         con.close();
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      return isSuccess;
   }

   //Retrieves admin details by username.
   public static List<admin> getAdmin(String userName) {
      ArrayList<admin> admins = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from admin where username='" + userName + "'";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            admin adminUser = new admin(id, name, email, phone, username, password);
            admins.add(adminUser);
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      return admins;
   }

   //Inserts a new admin into the database.
   public static boolean insertAdmin(String name, String email, String phone, String username, String password) {
      boolean isSuccess = false;

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "insert into admin values (0,'" + name + "','" + email + "','" + phone + "','" + username + "','" + password + "')";
         int rs = stmt.executeUpdate(sql);
         if (rs > 0) {
            isSuccess = true;
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return isSuccess;
   }

   
   public static boolean updateAdmin(String id, String name, String email, String phone, String username, String password) {
      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "update admin set name='" + name + "',email='" + email + "',phone='" + phone + "',username='" + username + "',password='" + password + "' where id='" + id + "'";
         int rs = stmt.executeUpdate(sql);
         isSuccess = rs > 0;
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return isSuccess;
   }

   public static List<admin> getAdminDetails(String Id) {
      int convertedID = Integer.parseInt(Id);
      ArrayList<admin> admins = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "select * from admin where id='" + convertedID + "'";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            admin adminUser = new admin(id, name, email, phone, username, password);
            admins.add(adminUser);
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      return admins;
   }

   public static boolean deleteAdmin(String id) {
      try {
         con = DBConnect.getConnection();
         String sql = "delete from admin where id=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, id);
         int rs = ps.executeUpdate();
         isSuccess = rs > 0;
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return isSuccess;
   }

 //Retrieves all admins from the database.
   public static List<admin> getAllAdmins() {
      ArrayList<admin> admins = new ArrayList();

      try {
         con = DBConnect.getConnection();
         stmt = con.createStatement();
         String sql = "SELECT * FROM admin";
         rs = stmt.executeQuery(sql);

         while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String phone = rs.getString(4);
            String username = rs.getString(5);
            String password = rs.getString(6);
            admin adminUser = new admin(id, name, email, phone, username, password);
            admins.add(adminUser);
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      return admins;
   }
}
