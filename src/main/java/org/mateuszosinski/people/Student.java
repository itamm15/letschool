package org.mateuszosinski.people;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {
   private static int numberOfStudents = 1;
   private final int studentId;
   private LocalDate enrollmentDate;
   private List<LegalGuardian> legalGuardians;


   public Student(String firstname, String lastname, String phoneNumber, LocalDate birthdate, LocalDate enrollmentDate, List<LegalGuardian> legalGuardians) {
      super(firstname, lastname, phoneNumber, birthdate);
      this.enrollmentDate = enrollmentDate;
      this.legalGuardians = legalGuardians;

      this.studentId = numberOfStudents;
      numberOfStudents++;
   }

   public Student(String firstname, String lastname, String phoneNumber, LocalDate birthdate, LocalDate enrollmentDate) {
      super(firstname, lastname, phoneNumber, birthdate);
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

   public List<LegalGuardian> getLegalGuardians() {
      return legalGuardians;
   }

   public void setLegalGuardians(List<LegalGuardian> legalGuardians) {
      this.legalGuardians = legalGuardians;
   }

   @Override
   public String toString() {
      return "Student{" +
              "studentId=" + studentId +
              ", enrollmentDate=" + enrollmentDate +
              ", legalGuardians=" + legalGuardians +
              '}';
   }
}
