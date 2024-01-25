package org.mateuszosinski.people;

import java.time.LocalDate;

public class Student extends Person {
   private static int numberOfStudents = 1;
   private final int studentId;
   private LocalDate enrollmentDate;
   private LegalGuardian legalGuardian;


   public Student(String firstname, String lastname, String phoneNumber, LocalDate birthdate, LocalDate enrollmentDate, LegalGuardian legalGuardian) {
      super(firstname, lastname, phoneNumber, birthdate);
      this.enrollmentDate = enrollmentDate;
      this.legalGuardian = legalGuardian;

      this.studentId = numberOfStudents;
      numberOfStudents++;
   }

   public Student(String firstname, String lastname, String phoneNumber, LocalDate birthdate, LocalDate enrollmentDate) {
      super(firstname, lastname, phoneNumber, birthdate);

      // VALIDATION
      if (enrollmentDate.isBefore(birthdate)) {
         throw new IllegalArgumentException(("Enrollment date can not be before birthdate!"));
      }

      // ASSIGNMENTS
      this.enrollmentDate = enrollmentDate;

      this.studentId = numberOfStudents;
      numberOfStudents++;
   }

   public int getStudentId() {
      return studentId;
   }

   public static int getNumberOfStudents() {
      return numberOfStudents;
   }

   public LegalGuardian getLegalGuardian() {
      return legalGuardian;
   }

   public void setLegalGuardian(LegalGuardian legalGuardian) {
      this.legalGuardian = legalGuardian;
   }

   @Override
   public String toString() {
      return "Student{" +
              "studentId=" + studentId +
              "fullname=" + getFirstname() + " " + getLastname() +
              ", enrollmentDate=" + enrollmentDate +
              ", legalGuardian=" + legalGuardian +
              ", databaseObjectId = " + getId() +
              '}';
   }
}