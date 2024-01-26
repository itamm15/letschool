package org.mateuszosinski.people.student;

import org.mateuszosinski.classrooms.Classroom;
import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.people.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.classrooms.classroom.methods.showClassrooms;

public class methods {
    public static void showStudents(ArrayList<DatabaseObject> database) {
        int studentsCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Student) {
                System.out.println(databaseObject.toString());
                studentsCount++;
            }
        }

        if(studentsCount == 0) {
            System.out.println("There are no students!");
        }
    }

    public static void showStudentsContactDetails(ArrayList<DatabaseObject> database) {
        int studentsCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Student) {
                System.out.println(((Student) databaseObject).getContactDetails());
                studentsCount++;
            }
        }

        if(studentsCount == 0) {
            System.out.println("There are no students!");
        }
    }

    public static void createStudent(ArrayList<DatabaseObject> database) {
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

            System.out.println("Provide the enrollmentDate, in format year-month-day [yyyy-mm-dd]");
            LocalDate enrollmentDate = LocalDate.parse(scanner.nextLine());

            Student student = new Student(firstname, lastname, phoneNumber, birthdate, enrollmentDate);
            System.out.println("Student created successfully!");
            database.add(student);
        } catch (Exception exception) {
            System.out.println("Could not create Student!" + exception);
        }
    }

    public static void deleteStudent(ArrayList<DatabaseObject> database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a student by databaseObject");
        showStudents(database);
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject student = database.get(pickedDatabaseObject - 1);
            if(student instanceof Student) {
                database.remove(student);
                System.out.println("The student has been deleted! Here is updated structure of students:\n");
                showStudents(database);
            } else {
                throw new IllegalAccessException("It is not a student!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete student!" + exception);
        }
    }

    public static void assignStudentToClassroom(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select student by DatabaseObjectId");
            showStudents(database);

            int pickedDatabaseStudentObject = scanner.nextInt();
            DatabaseObject studentDatabaseObject = database.get(pickedDatabaseStudentObject - 1);
            if(!(studentDatabaseObject instanceof Student))  throw new IllegalAccessException("It is not a student!");

            Student student = (Student) studentDatabaseObject;

            System.out.println("Select classroom by DatabaseObjectId");
            showClassrooms(database);

            int pickedDatabaseClassroomObject = scanner.nextInt();
            DatabaseObject classroomDatabaseObject = database.get(pickedDatabaseClassroomObject - 1);
            if(!(classroomDatabaseObject instanceof Classroom))  throw new IllegalAccessException("It is not a classroom!");

            Classroom classroom = (Classroom) classroomDatabaseObject;
            classroom.addStudent(student);
            System.out.println("Assigned student to the classroom!");
        } catch (Exception exception) {
            System.out.println("Could not assign student to the classroom!" + exception);
        }
    }
}
