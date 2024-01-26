package org.mateuszosinski.people.teacher;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.people.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class methods {
    public static void showTeachers(ArrayList<DatabaseObject>  database) {
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

    public static void showTeachersContactDetails(ArrayList<DatabaseObject> database) {
        int teachersCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Teacher) {
                System.out.println(((Teacher) databaseObject).getContactDetails());
                teachersCount++;
            }
        }

        if(teachersCount == 0) {
            System.out.println("There are no teachers!");
        }
    }

    public static void showTeachersBasicInfo(ArrayList<DatabaseObject> database) {
        int teachersCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Teacher) {
                System.out.println(((Teacher) databaseObject).basicPersonInformation());
                teachersCount++;
            }
        }

        if(teachersCount == 0) {
            System.out.println("There are no teachers!");
        }
    }

    public static void createTeacher(ArrayList<DatabaseObject>  database) {
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

    public static void deleteTeacher(ArrayList<DatabaseObject> database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a teacher by databaseObject");
        showTeachers(database);
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject teacher = database.get(pickedDatabaseObject - 1);
            if(teacher instanceof Teacher) {
                database.remove(teacher);
                teacher = null;
                System.out.println("The teacher has been deleted! Here is updated structure of teachers:\n");
                showTeachers(database);
            } else {
                throw new IllegalAccessException("It is not a teacher!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete teacher!" + exception);
        }
    }
}
