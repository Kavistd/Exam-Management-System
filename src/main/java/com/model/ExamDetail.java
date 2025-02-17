package com.model;

//Class representing details of an exam.
public class ExamDetail {
   private int examId;
   private String type;
   private String duration;
   private String structure;
   private String userName;

   //Constructor to initialize all fields of the ExamDetail class.
   public ExamDetail(int examId, String type, String duration, String structure, String userName) {
      this.examId = examId;
      this.type = type;
      this.duration = duration;
      this.structure = structure;
      this.userName = userName;
   }

   public ExamDetail(int examId, String examName, String examDate, int duration) {
   }

   public int getExamId() {
      return this.examId;
   }

   public String getType() {
      return this.type;
   }

   public String getDuration() {
      return this.duration;
   }

   public String getStructure() {
      return this.structure;
   }

   public String getUserName() {
      return this.userName;
   }
}
