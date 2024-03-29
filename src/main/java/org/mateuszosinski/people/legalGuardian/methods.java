package org.mateuszosinski.people.legalGuardian;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.enums.DegreeOfRelationships;
import org.mateuszosinski.people.LegalGuardian;
import org.mateuszosinski.people.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.student.methods.showStudents;

public class methods {

    public static int showLegalGuardians(ArrayList<DatabaseObject> database) {
        int legalGuardiansCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof LegalGuardian) {
                System.out.println(databaseObject.toString());
                legalGuardiansCount++;
            }
        }

        if(legalGuardiansCount == 0) {
            System.out.println("There are no legalGuardians!");
        }

        return legalGuardiansCount;
    }

    public static void showLegalGuardiansBasicInfo(ArrayList<DatabaseObject> database) {
        int legalGuardiansCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof LegalGuardian) {
                System.out.println(((LegalGuardian) databaseObject).basicPersonInformation());
                legalGuardiansCount++;
            }
        }

        if(legalGuardiansCount == 0) {
            System.out.println("There are no legalGuardians!");
        }
    }

    public static void showLegalGuardiansContactDetails(ArrayList<DatabaseObject> database) {
        int legalGuardiansCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof LegalGuardian) {
                System.out.println(((LegalGuardian) databaseObject).getContactDetails());
                legalGuardiansCount++;
            }
        }

        if(legalGuardiansCount == 0) {
            System.out.println("There are no legalGuardians!");
        }
    }

    public static void createLegalGuardian(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Provide firstname");
            String firstname = scanner.nextLine();
            if (!firstname.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("Firstname should only contain alphabetic characters.");
            }

            System.out.println("Provide lastname");
            String lastname = scanner.nextLine();
            if (!firstname.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("Firstname should only contain alphabetic characters.");
            }

            System.out.println("Provide phone number");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches("^[0-9]{9,12}$")) {
                throw new IllegalArgumentException("Invalid phone number format.");
            }

            System.out.println("Provide the birthdate, in format year-month-day [yyyy-mm-dd]");
            LocalDate birthdate = LocalDate.parse(scanner.nextLine());

            System.out.println("Provide degree of relationship");
            for (DegreeOfRelationships degreeOfRelationship : DegreeOfRelationships.values()) {
                System.out.println(degreeOfRelationship + " ");
            }

            String degreeOfRelationshipInput = scanner.nextLine();
            DegreeOfRelationships selectedDegreeOfRelationship = DegreeOfRelationships.valueOf(degreeOfRelationshipInput.toUpperCase());

            LegalGuardian legalGuardian = new LegalGuardian(firstname, lastname, phoneNumber, birthdate, selectedDegreeOfRelationship);
            System.out.println("Created legal guardian successfully!");
            database.add(legalGuardian);

            // Assign legal guardian to student
            System.out.println("Select student by DatabaseObjectId");
            int numberOfStudents = showStudents(database);

            if (numberOfStudents == 0) throw new Exception("There are no students! Create student and then assign legal guardian in student menu!");

            int pickedDatabaseStudentObject = scanner.nextInt();
            DatabaseObject studentDatabaseObject = database.get(pickedDatabaseStudentObject - 1);
            if(!(studentDatabaseObject instanceof Student))  throw new IllegalAccessException("It is not a student!");

            Student student = (Student) studentDatabaseObject;
            student.setLegalGuardian(legalGuardian);
            System.out.println("Legal guardian assigned correctly to the user!");
        } catch (Exception exception) {
            System.out.println("Could not create legal guardian!" + exception);
        }
    }
}
