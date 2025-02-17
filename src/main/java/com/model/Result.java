package com.model;

public class Result {
   private String resultCode;
   private int creditPoints;
   private String grade;
   private String userName;

   public Result(String resultCode, int creditPoints, String grade, String userName) {
      this.resultCode = resultCode;
      this.creditPoints = creditPoints;
      this.grade = grade;
      this.userName = userName;
   }

   public Result(int resultCode2, int creditPoints2, String grade2, String userName2) {
   }

   public String getResultCode() {
      return this.resultCode;
   }

   public void setResultCode(String resultCode) {
      this.resultCode = resultCode;
   }

   public int getCreditPoints() {
      return this.creditPoints;
   }

   public void setCreditPoints(int creditPoints) {
      this.creditPoints = creditPoints;
   }

   public String getGrade() {
      return this.grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }
}
