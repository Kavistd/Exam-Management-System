package com.model;

//Represents a User with personal and login details.
public class User {
   private int id;
   private String name;
   private String email;
   private String phone;
   private String userName;
   private String password;

   public User(int id, String name, String email, String phone, String userName, String password) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.userName = userName;
      this.password = password;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getPassword() {
      return this.password;
   }
}
