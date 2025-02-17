package com.model;

//This class represents an Exam Paper entity, containing information about
public class ExamPaper {
   private int paperId;
   private String question;
   private String answer;
   private int examId;

   //Constructor to initialize the ExamPaper object with all properties.
   public ExamPaper(int paperId, String question, String answer, int examId) {
      this.paperId = paperId;
      this.question = question;
      this.answer = answer;
      this.examId = examId;
   }

   public int getPaperId() {
      return this.paperId;
   }

   public String getQuestion() {
      return this.question;
   }

   public String getAnswer() {
      return this.answer;
   }

   public int getExamId() {
      return this.examId;
   }
}
