package org.mateuszosinski;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.enums.Grades;
import org.mateuszosinski.enums.Subjects;
import org.mateuszosinski.grades.Grade;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;
import org.mateuszosinski.seeds.Seeds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<DatabaseObject> database = new ArrayList();
    public static void main(String[] args) {
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
                    "16. Exit.\n" +
                    "17. Seed it!"
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
                        deleteTeacher();
                        break;
                    case 4:
                        createStudent();
                        break;
                    case 5:

                        break;
                    case 6:
                        deleteStudent();
                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 10:
                        createGrade();
                        break;
                    case 12:
                        deleteGrade();
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
                    case 17:
                        Seeds.run(database);
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
        int teacherCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Teacher) {
                System.out.println(databaseObject.toString());
                teacherCount++;
            }
        }

        if (teacherCount == 0) {
            System.out.println("There are no teachers!");
        }
    }

    public static void showStudents() {
        int studentsCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Student) {
                System.out.println(databaseObject);
                studentsCount++;
            }
        }

        if(studentsCount == 0) {
            System.out.println("There are no students!");
        }
    }

    public static void showGrades() {
        int gradesCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Grade) {
                System.out.println(databaseObject);
                gradesCount++;
            }
        }

        if (gradesCount == 0) {
            System.out.println("There are no grades!");
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

            scanner.nextLine();

            System.out.println("Provide the birthdate, in format year-month-day [yyyy-mm-dd]");
            LocalDate birthdate = LocalDate.parse(scanner.nextLine());

            System.out.println("Provide the enrollmentDate, in format year-month-day [yyyy-mm-dd]");
            LocalDate enrollmentDate = LocalDate.parse(scanner.nextLine());

            Teacher teacher = new Teacher(firstname, lastname, phoneNumber, birthdate, enrollmentDate, salary);
            System.out.println("Teacher created successfully!");
            database.add(teacher);
        } catch (Exception exception) {
            System.out.println("Could not create Teacher!" + exception);
        }
    }

    public static void createStudent() {
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


    /*
     STEPS:
     1. Select subject,
     2. Select grade,
     3. Select teacher,
     4. Select student
     */
    public static void createGrade() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select a subject by name");
            for (Subjects subject : Subjects.values()) {
                System.out.println(subject + " ");
            }

            String subjectInput = scanner.nextLine();
            Subjects selectedSubject = Subjects.valueOf(subjectInput.toUpperCase());

            System.out.println("Select a grade by name");
            for (Grades grade : Grades.values()) {
                System.out.println(grade + " ");
            }

            String gradeInput = scanner.nextLine();
            Grades selectedGrade = Grades.valueOf(gradeInput.toUpperCase());

            System.out.println("Select teacher by DatabaseObjectId");
            showTeachers();

            int pickedDatabaseTeacherObject = scanner.nextInt();
            DatabaseObject teacherDatabaseObject = database.get(pickedDatabaseTeacherObject - 1);
            if(!(teacherDatabaseObject instanceof Teacher))  throw new IllegalAccessException("It is not a teacher!");

            System.out.println("Select student by DatabaseObjectId");
            showStudents();

            int pickedDatabaseStudentObject = scanner.nextInt();
            DatabaseObject studentDatabaseObject = database.get(pickedDatabaseStudentObject - 1);
            if(!(studentDatabaseObject instanceof Student))  throw new IllegalAccessException("It is not a student!");

            Student student = (Student) studentDatabaseObject;
            Teacher teacher = (Teacher) teacherDatabaseObject;

            Grade grade = new Grade(selectedSubject, student, teacher, selectedGrade);
            System.out.println("Grade created successfully!");
            database.add(grade);
        } catch (Exception exception) {
            System.out.println("Could not create grade!" + exception);
        }
    }

    public static void deleteTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a teacher by databaseObject");
        showTeachers();
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject teacher = database.get(pickedDatabaseObject - 1);
            if(teacher instanceof Teacher) {
                database.remove(teacher);
                System.out.println("The teacher has been deleted! Here is updated structure of teachers:\n");
                showTeachers();
            } else {
                throw new IllegalAccessException("It is not a teacher!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete teacher!" + exception);
        }
    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a student by databaseObject");
        showStudents();
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject student = database.get(pickedDatabaseObject - 1);
            if(student instanceof Student) {
                database.remove(student);
                System.out.println("The student has been deleted! Here is updated structure of students:\n");
                showStudents();
            } else {
                throw new IllegalAccessException("It is not a student!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete student!" + exception);
        }
    }

    public static void deleteGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a grade by databaseObject");
        showGrades();
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject grade = database.get(pickedDatabaseObject - 1);
            if(grade instanceof Student) {
                database.remove(grade);
                System.out.println("The grade has been deleted! Here is updated structure of students:\n");
                showGrades();
            } else {
                throw new IllegalAccessException("It is not a grade!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete grade!" + exception);
        }
    }
}