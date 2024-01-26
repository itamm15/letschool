package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.student.methods.*;

public class StudentMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Student\n" +
                                "1. Create Student\n" +
                                "2. Delete Student\n" +
                                "3. Show all Students\n" +
                                "4. Show students contact details\n" +
                                "5. Assign student to classroom\n" +
                                "6. Go back."
                    );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createStudent(database);
                    break;
                case 2:
                    deleteStudent(database);
                    break;
                case 3:
                    showStudents(database);
                    break;
                case 4:
                    showStudentsContactDetails(database);
                    break;
                case 5:
                    assignStudentToClassroom(database);
                    break;
                default:
                    System.out.println("Going back!");
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong for the Student menu!" + exception);
        }
    }
}
