package org.mateuszosinski;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.grades.Grade;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<DatabaseObject> database = new ArrayList();
    public static void main(String[] args) {
        Student student = new Student("Mateusz", "Osiński","123123123", LocalDate.of(2001, 10, 3), LocalDate.of(2010, 10, 10));
        Student student2 = new Student("Mateusz", "Osiński","123123123", LocalDate.of(2001, 10, 3), LocalDate.of(2010, 10, 10));
        Student student3 = new Student("Mateusz", "Osiński","123123123", LocalDate.of(2001, 10, 3), LocalDate.of(2010, 10, 10));

        System.out.println(student.getStudentId());
        System.out.println(student2.getStudentId());
        System.out.println(student3.getStudentId());

        System.out.println(student.getPersonId());
        System.out.println(student2.getPersonId());
        System.out.println(student3.getPersonId());

        Teacher teacher = new Teacher("Kamil", "Osinski", "123321123", LocalDate.of(2010, 10, 4), LocalDate.of(2018, 12, 20), 123);

        System.out.println(teacher.getTeacherId());
        System.out.println(teacher.getPersonId());

        menu();
    }

    public static void menu() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println(
                    "Pick the action to proceed!\n" +
                    "1. Create a Teacher\n" +
                    "2. Update a Teacher\n" +
                    "3. Delete a Teacher\n" +
                    "4. Create a Student\n" +
                    "5. Update a Student\n" +
                    "6. Delete a Student\n" +
                    "7. Create a legal guardian for student\n" +
                    "8. Update a legal guardian for student\n" +
                    "9. Delete a legal guardian for student\n" +
                    "10. Create a grade\n" +
                    "11. Update a grade\n" +
                    "12. Delete a grade\n" +
                    "13. Show all Teachers\n" +
                    "14. Show all Students\n" +
                    "15. Show all Grades\n" +
                    "16. Exit."
            );

            Scanner scanner = new Scanner(System.in);

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        createTeacher();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;

                    case 13:
                        showTeachers();
                        break;

                    case 14:
                        showStudents();
                        break;
                    case 15:
                        showGrades();
                        break;
                    case 16:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("There is no such an option! Try again.");
                        break;
                }
            } catch (Exception exception) {
                System.out.println("Could not parse the input!" + exception);
            }
        }
    }

    public static void showTeachers() {
        for(DatabaseObject databaseObject : database) {
            System.out.println(databaseObject + " dada");
            if(databaseObject instanceof Teacher) {
                System.out.println(databaseObject);
            }
        }
    }

    public static void showStudents() {
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Student) {
                System.out.println(databaseObject);
            }
        }
    }

    public static void showGrades() {
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Grade) {
                System.out.println(databaseObject);
            }
        }
    }

    public static void createTeacher() {
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

            System.out.println("Provide salary");
            float salary = scanner.nextFloat();

            System.out.println("Provide the birthdate, in format year-month-day [yyyy-mm-dd]");
            LocalDate birthdate = LocalDate.parse(scanner.nextLine());

            System.out.println("Provide the enrollmentDate, in format year-month-day [yyyy-mm-dd]");
            LocalDate enrollmentDate = LocalDate.parse(scanner.nextLine());

            Teacher teacher = new Teacher(firstname, lastname, phoneNumber, birthdate, enrollmentDate, salary);
            database.add(teacher);
        } catch (Exception exception) {
            System.out.println("Could not create Teacher!" + exception);
        }
    }
}